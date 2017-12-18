package com.lz.myapplication;

import android.Manifest;
import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.lz.dao.DaoMaster;
import com.lz.dao.DaoSession;
import com.lz.dao.MyOpenHelper;

/**
 * Created by DELL on 2017/10/23.
 */

public class MyApplication extends Application{

    public static DaoSession daoSession;

    // 当前屏幕的高宽
    public static int screenW = 0;
    public static int screenH = 0;
    private static MyApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        getDaoSession();
        Fresco.initialize(this);
        // 得到屏幕的宽度和高度
        DisplayMetrics dm = getResources().getDisplayMetrics();
        screenW = dm.widthPixels;
        screenH = dm.heightPixels;
    }


    // 单例模式中获取唯一的MyApplication实例
    public static MyApplication getInstance() {
        if (instance == null) {
            instance = new MyApplication();
        }
        return instance;
    }

    public DaoSession getDaoSession(){
        if(daoSession==null){
            synchronized (DaoSession.class){
                if(daoSession == null){
//                    DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(getApplicationContext(),"lz.db",null);
                    MyOpenHelper openHelper = new MyOpenHelper(getApplicationContext(),"lz.db",null);
                    DaoMaster daoMaster = new DaoMaster(openHelper.getWritableDatabase());
                    daoSession = daoMaster.newSession();
                }
            }
        }
        return daoSession;
    }
}
