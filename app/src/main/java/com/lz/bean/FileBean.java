package com.lz.bean;

import java.io.Serializable;

/**
 * Created by DELL on 2017/11/28.
 */

public class FileBean implements Serializable{
    private String url;
    private String fileName;
    private long start;
    private long now;
    private long stop;

    public FileBean(String url, String fileName, long start, long now, long stop) {
        this.url = url;
        this.fileName = fileName;
        this.start = start;
        this.now = now;
        this.stop = stop;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public long getStop() {
        return stop;
    }

    public void setStop(long stop) {
        this.stop = stop;
    }
}
