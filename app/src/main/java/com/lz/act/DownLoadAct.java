package com.lz.act;

import android.content.IntentFilter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lz.adapter.DownLoadAdapter;
import com.lz.base.BaseActivity;
import com.lz.bean.FileInfo;
import com.lz.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Created by DELL on 2017/11/14.
 */

public class DownLoadAct extends BaseActivity{

    @BindView(R.id.rlv_download)
    RecyclerView rlv_download;
    @Override
    protected int setLayoutId() {
        return R.layout.activity_download;
    }

    List<FileInfo> lsFile = new ArrayList<>();
    @Override
    protected void initParams() {
        for(int i = 10;i<=100;i+=10){
            FileInfo fileInfo = new FileInfo();
            fileInfo.setUrl("");
            fileInfo.setLength(100);
            fileInfo.setStart(0);
            fileInfo.setNow(i);
            lsFile.add(fileInfo);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rlv_download.setLayoutManager(linearLayoutManager);
        DownLoadAdapter adapter = new DownLoadAdapter(this,R.layout.item_download,lsFile);
        rlv_download.setAdapter(adapter);
//        rlv_download.setAdapter(new CommonAdapter<FileInfo>(DownLoadAct.this,R.layout.item_download,lsFile) {
//            @Override
//            public void convert(ViewHolder vh, FileInfo fileInfo) {
//                ProgressBar pb = vh.getView(R.id.pb_load1);
//                pb.setMax(fileInfo.getLength());
//                pb.setProgress(fileInfo.getNow());
//                vh.setText(R.id.tv_progress1,fileInfo.getNow()+"/"+fileInfo.getLength());
//            }
//        });
    }
}
