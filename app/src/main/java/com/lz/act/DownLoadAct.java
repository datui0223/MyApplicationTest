package com.lz.act;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import com.lz.adapter.DownLoadAdapter;
import com.lz.base.BaseActivity;
import com.lz.bean.FileBean;
import com.lz.dao.FileInfoDao;
import com.lz.myapplication.MyApplication;
import com.lz.myapplication.R;
import com.lz.service.DownLoadService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by DELL on 2017/11/14.
 */

public class DownLoadAct extends BaseActivity{

    @BindView(R.id.rlv_download)
    RecyclerView rlv_download;
    @BindView(R.id.bt_download_one)
    Button bt_download_one;
    @BindView(R.id.bt_download_more)
    Button bt_download_more;
    @BindView(R.id.bt_stop_one)
    Button bt_stop_one;
    @BindView(R.id.bt_stop_more)
    Button bt_stop_more;
    @Override
    protected int setLayoutId() {
        return R.layout.activity_download;
    }

    List<FileBean> lsFile = new ArrayList<>();
    FileBean fileBean;
    DownLoadAdapter adapter;
    private FileInfoDao infoDao;
    @Override
    protected void initParams() {
        infoDao = MyApplication.getInstance().getDaoSession().getFileInfoDao();
        getPermission();
        fileBean = new FileBean
                (
                 "https://www.imooc.com/mobile/mukewang.apk",
                 "apk",
                  0,0,0
                );
        lsFile.add(fileBean);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DownLoadAct.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rlv_download.setLayoutManager(linearLayoutManager);
        adapter = new DownLoadAdapter(DownLoadAct.this,R.layout.item_download,lsFile);
        rlv_download.setAdapter(adapter);
        //注册广播接收器
        IntentFilter filter = new IntentFilter();
        filter.addAction(DownLoadService.ACTION_START);
        registerReceiver(mReceiver,filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    /**
     *
     * 6.0以上获取权限
     */
    private void getPermission() {
        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            int permission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if(permission != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,permissions,100);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    @OnClick({R.id.bt_download_one,R.id.bt_download_more,R.id.bt_stop_one,R.id.bt_stop_more})
    public void onClick(Button bt){
        switch (bt.getId()){
            case R.id.bt_download_one:
                Intent intent = new Intent(DownLoadAct.this,DownLoadService.class);
                intent.setAction(DownLoadService.ACTION_START);
                intent.putExtra("fileInfo",fileBean);
                startService(intent);
                break;
            case R.id.bt_download_more:
                infoDao.deleteAll();
                break;
            case R.id.bt_stop_one:
                Intent intentStop = new Intent(DownLoadAct.this,DownLoadService.class);
                intentStop.setAction(DownLoadService.ACTION_STOP);
                intentStop.putExtra("fileInfo",fileBean);
                startService(intentStop);
                break;
            case R.id.bt_stop_more:

                break;
            default:
                break;
        }
    }

    /**
     * 更新UI广播接收器
     */
    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            long finished = intent.getLongExtra("finished",0);
            fileBean.setNow(finished);
            Log.i("Receiver",finished+"");
            if(adapter!=null){
                adapter.notifyDataSetChanged();
            }else {
                adapter = new DownLoadAdapter(DownLoadAct.this,R.layout.item_download,lsFile);
                rlv_download.setAdapter(adapter);
            }
        }
    };
}
