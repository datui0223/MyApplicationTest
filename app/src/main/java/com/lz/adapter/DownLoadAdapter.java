package com.lz.adapter;

import android.content.Context;
import android.widget.ProgressBar;

import com.lz.bean.FileBean;
import com.lz.sqlbean.FileInfo;
import com.lz.commonadapter.CommonAdapter;
import com.lz.commonadapter.ViewHolder;
import com.lz.myapplication.R;

import java.util.List;

/**
 * Created by DELL on 2017/11/14.
 */

public class DownLoadAdapter extends CommonAdapter<FileBean>{
    public DownLoadAdapter(Context context, int layoutId, List mDates) {
        super(context, layoutId, mDates);
    }

    @Override
    public void convert(ViewHolder vh, FileBean fileInfo) {
        ProgressBar pb = vh.getView(R.id.pb_load1);
//        pb.setMax(fileInfo.getLength());
        pb.setMax(100);
        pb.setProgress((int) fileInfo.getNow());
        vh.setText(R.id.tv_progress1,fileInfo.getNow()+"/"+100);
    }

}
