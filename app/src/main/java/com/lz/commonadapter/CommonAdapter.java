package com.lz.commonadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by DELL on 2017/11/14.
 */

public abstract class CommonAdapter<T> extends RecyclerView.Adapter<ViewHolder>{
    protected Context context;
    protected int layoutId;
    protected List<T> mDates;
    protected LayoutInflater inflater;

    public CommonAdapter(Context context, int layoutId, List<T> mDates) {
        this.context = context;
        this.layoutId = layoutId;
        this.mDates = mDates;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = ViewHolder.get(context,parent,layoutId);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.updatePosition(position);
        convert(holder, mDates.get(position));
    }

    @Override
    public int getItemCount() {
        return mDates.size();
    }

    public abstract void convert(ViewHolder vh,T t);
}
