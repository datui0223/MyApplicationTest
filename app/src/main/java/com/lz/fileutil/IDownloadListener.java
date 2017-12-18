package com.lz.fileutil;

import java.net.HttpURLConnection;

/**
 * Created by DELL on 2017/11/23.
 */

public interface IDownloadListener {
    //取消
    public void onCancel();
    //下载失败
    public void onFail();
    //下载预处理通过HttpURLConnection获取文件的长度
    public void onPreDownload(HttpURLConnection connection);
    //下载中监听从传入的进度开始
    public void onProgessing(long location);
    //单一线程的结束位置
    public void onChildComplete(long finishPosition);
    //开始
    public void onStart(long startPosition);
    //子线程恢复下载的位置
    public void onChildResume(long childResumePositon);
    //恢复位置
    public void onResume(long parsePosition);
    //停止
    public void onStop(long stopPosition);
    //下载完成
    public void onComplete();




}
