package com.lz.service;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;

import com.lz.bean.FileBean;
import com.lz.utils.DownLoadTask;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by DELL on 2017/11/24.
 */

public class DownLoadService extends Service {
    public static final String ACTION_START = "ACTION_START";
    public static final String ACTION_STOP = "ACTION_STOP";

    private FileBean fileBean;
    public static final int handlerFlag = 0;
    public static final String DOWNLOAD_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/download/";
    private DownLoadTask task = null;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case handlerFlag:
                    FileBean fileBean = (FileBean) msg.obj;
                    Log.i("handler", fileBean.toString());
                    //启动下载任务
                    task = new DownLoadTask(DownLoadService.this, fileBean,3);
                    task.download();
                    break;
            }
        }
    };

    class DownLoadThread extends Thread {

        @Override
        public void run() {
            HttpURLConnection connection = null;
            RandomAccessFile rFile = null;
            int length = -1;
            try {
                URL url = new URL(fileBean.getUrl());
                connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(3000);
                connection.setRequestMethod("GET");
                //获取文件长度
                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    length = connection.getContentLength();
                }
                if (length <= 0) {
                    return;
                }
                //判断文件是否存在
                File file = new File(DOWNLOAD_PATH);
                if (!file.exists()) {
                    file.mkdir();
                }
                File randomFile = new File(file, fileBean.getFileName());
                rFile = new RandomAccessFile(randomFile, "rwd");
                //设置文件长度
                rFile.setLength(length);
                fileBean.setStop(length);
                handler.obtainMessage(0, fileBean).sendToTarget();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.disconnect();
                    rFile.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (ACTION_START.equalsIgnoreCase(intent.getAction())) {
            fileBean = (FileBean) intent.getSerializableExtra("fileInfo");
            if(fileBean!=null){
                new DownLoadThread().start();
            }
            Log.i("fileinfoStart", fileBean.toString());
        } else if (ACTION_STOP.equalsIgnoreCase(intent.getAction())) {
//            fileBean = (FileBean) intent.getSerializableExtra("fileInfo");
//            Log.i("fileinfoStop", fileBean.toString());
            if (task != null) {
                task.isPause = true;
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
