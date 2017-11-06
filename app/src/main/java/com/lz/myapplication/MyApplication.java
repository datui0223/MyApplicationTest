package com.lz.myapplication;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.lz.dao.DaoMaster;
import com.lz.dao.DaoSession;
import com.lz.dao.MyOpenHelper;

/**
 * Created by DELL on 2017/10/23.
 */

public class MyApplication extends Application{

    public static DaoSession daoSession;

    private static MyApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        getDaoSession();
        Fresco.initialize(this);
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
