package com.lz.fileutil;

import java.net.HttpURLConnection;

/**
 * Created by DELL on 2017/11/23.
 */

public class DownloadListener implements IDownloadListener {
    @Override
    public void onCancel() {

    }

    @Override
    public void onFail() {

    }

    @Override
    public void onPreDownload(HttpURLConnection connection) {

    }

    @Override
    public void onProgessing(long location) {

    }

    @Override
    public void onChildComplete(long finishPosition) {

    }

    @Override
    public void onStart(long startPosition) {

    }

    @Override
    public void onChildResume(long childResumePositon) {

    }

    @Override
    public void onResume(long parsePosition) {

    }

    @Override
    public void onStop(long stopPosition) {

    }

    @Override
    public void onComplete() {

    }
}
