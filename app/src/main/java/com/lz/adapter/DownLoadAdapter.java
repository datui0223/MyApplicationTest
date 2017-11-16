package com.lz.adapter;

import android.content.Context;
import android.widget.ProgressBar;

import com.lz.bean.FileInfo;
import com.lz.commonadapter.CommonAdapter;
import com.lz.commonadapter.ViewHolder;
import com.lz.myapplication.R;

import java.util.List;

/**
 * Created by DELL on 2017/11/14.
 */

public class DownLoadAdapter extends CommonAdapter<FileInfo>{
    public DownLoadAdapter(Context context, int layoutId, List mDates) {
        super(context, layoutId, mDates);
    }

    @Override
    public void convert(ViewHolder vh, FileInfo fileInfo) {
        ProgressBar pb = vh.getView(R.id.pb_load1);
        pb.setMax(fileInfo.getLength());
        pb.setProgress(fileInfo.getNow());
        vh.setText(R.id.tv_progress1,fileInfo.getNow()+"/"+fileInfo.getLength());
    }
}
