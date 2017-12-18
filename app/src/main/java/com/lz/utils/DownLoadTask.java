package com.lz.utils;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;

import com.lz.bean.FileBean;
import com.lz.dao.FileInfoDao;
import com.lz.myapplication.MyApplication;
import com.lz.service.DownLoadService;
import com.lz.sqlbean.FileInfo;

import org.greenrobot.greendao.query.WhereCondition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2017/11/27.
 */

public class DownLoadTask {
    private Context context;
    private FileBean fileBean;
    private FileInfoDao infoDao;
    private int mThreadCount = 1;//线程数量
    private List<DownLoadThread> threadList = null;

    public DownLoadTask(Context context, FileBean fileBean,int mThreadCount) {
        this.context = context;
        this.fileBean = fileBean;
        this.mThreadCount = mThreadCount;
        infoDao = MyApplication.getInstance().getDaoSession().getFileInfoDao();
    }

    public void download(){
        //检查数据库有没有下载信息
//        Cursor cursor = MyApplication.getInstance().getDaoSession().getDatabase().rawQuery("select * from FILE_INFO where URl=?",new String[]{fileBean.getUrl()});
//        Log.i("infosdb", infos.toString());
        List<FileInfo> fileInfos = infoDao.queryBuilder().where(FileInfoDao.Properties.Url.eq(fileBean.getUrl())).list();
        if(fileInfos.size() == 0){
            //获取每个线程下载长度
            long length = fileBean.getStop()/mThreadCount;
            for (int i = 0;i<mThreadCount;i++){
                FileInfo info = new FileInfo(0,fileBean.getFileName(),fileBean.getUrl()
                        ,(i+1)*length-1,i*length,0);
                //不管能不能整除，最后一个线程内剩下的全部下载完毕
                if(i == mThreadCount-1){
                    info.setNow(fileBean.getStop());
                }
                fileInfos.add(info);
            }
        }
//        for (int i = 0;i<mThreadCount;i++){
//            new DownLoadThread(fileInfos.get(i)).start();
//        }
        threadList = new ArrayList<>();
        for (FileInfo info : fileInfos){
            DownLoadThread thread = new DownLoadThread(info);
            thread.start();
            threadList.add(thread);
        }
    }

    /**
     * 判断所有线程是否下载完毕
     */
    private synchronized  void checkAllThreadFinished(){
        boolean allFinished = true;
        //遍历线程集合，判断线程是否都执行完毕

    }

    /**
     * 下载线程
     */
    public boolean isPause = false;
    class DownLoadThread extends Thread{

        FileInfo fileInfo;
        public DownLoadThread (FileInfo fileInfo){
            this.fileInfo = fileInfo;
        }
        @Override
        public void run() {
            super.run();
            //向数据库中插入线程信息
            FileInfo infoKeep = infoDao.queryBuilder().where(FileInfoDao.Properties.Url.eq(fileInfo.getUrl())).build().unique();
            if(infoKeep==null){
                infoDao.insert(fileInfo);
            }
            //设置下载位置
            HttpURLConnection conn = null;
            RandomAccessFile accessFile = null;
            InputStream input = null;
            long start = 0;
            long end = 0;
            try {
                URL url = new URL(fileInfo.getUrl());
                conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(3000);
                conn.setRequestMethod("GET");
                start = fileInfo.getStart()+fileInfo.getNow();
                end = fileInfo.getLength();
                conn.setRequestProperty("Range","bytes="+start+"-"+end);

                //设置写入位置
                File file = new File(DownLoadService.DOWNLOAD_PATH, String.valueOf(fileInfo.getFilename()));
                accessFile = new RandomAccessFile(file,"rwd");
                accessFile.seek(start);
                Intent intent = new Intent(DownLoadService.ACTION_START);

                //开始下载
                if(conn.getResponseCode() == HttpURLConnection.HTTP_PARTIAL){
                    //读取数据
                    input = conn.getInputStream();
                    byte[] buffer = new byte[1024*4];
                    int len = -1;
                    long mfinished = fileInfo.getNow();
//                    long time = System.currentTimeMillis();
                    while ((len = input.read(buffer))!=-1) {
                        //写入文件
                        accessFile.write(buffer,0,len);
                        //整个文件的进度
                        mfinished +=len;
                        //累加每个线程完成的进度
                        fileInfo.setNow(mfinished);
                        //把下载进度发送广播给Activity
//                        if(System.currentTimeMillis() - time>200){
//                            time = System.currentTimeMillis();
                            intent.putExtra("finished",mfinished*100/fileInfo.getLength());
                            context.sendBroadcast(intent);
//                        }
                        //在下载暂停时，保存下载进度
                        if(isPause){
                            FileInfo filePause = infoDao.queryBuilder().where(FileInfoDao.Properties.Url.eq(fileInfo.getUrl())).build().unique();
                            if(filePause!=null){
                                filePause.setNow(fileInfo.getNow());
                                infoDao.update(filePause);
                                return;
                            }
                        }
                    }
                    //下载完成后删除线程信息
                    infoDao.delete(fileInfo);
                    file.delete();
                    Log.i("finish", "run: finish"+mfinished+"length:"+fileInfo.getLength());
                }
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    accessFile.close();
                    conn.disconnect();
                    input.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }finally {
                try {
                    accessFile.close();
                    conn.disconnect();
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
