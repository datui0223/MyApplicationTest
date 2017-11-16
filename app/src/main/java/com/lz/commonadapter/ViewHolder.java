package com.lz.commonadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by DELL on 2017/11/14.
 */

public class ViewHolder extends RecyclerView.ViewHolder{
    private SparseArray<View> mViews;
    private View mConvertView;
    private Context context;

    public ViewHolder(ViewGroup parent, View itemView, Context context) {
        super(itemView);
        this.mConvertView = itemView;
        this.context = context;
        mViews = new SparseArray<View>();
    }

    public static ViewHolder get(Context context,ViewGroup parent,int layoutId){
        View view = LayoutInflater.from(context).inflate(layoutId,parent,false);
        ViewHolder viewHolder = new ViewHolder(parent,view,context);
        return viewHolder;
    }

    /**
     * 通过viewID获取控件
     */
    public <T extends View> T getView(int viewId){
        View view = mViews.get(viewId);
        if(view == null){
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T)view;
    }

    /**
     * 辅助方法
     *
     */
    public ViewHolder setText(int viewId,String text){
        TextView textView = getView(viewId);
        textView.setText(text);
        return this;
    }

    public ViewHolder setImage(int viewId,int imageId){
        ImageView iv = getView(viewId);
        iv.setImageResource(imageId);
        return this;
    }
}
