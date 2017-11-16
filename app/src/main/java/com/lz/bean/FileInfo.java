package com.lz.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by DELL on 2017/11/14.
 */
@Entity
public class FileInfo {
    @Id
    private long id;
    private String url;
    private int length;
    private int start;
    private int now;
    public String getUrl() {
        return url;
    }

    public FileInfo(String url, int length, int start, int now) {
        this.url = url;
        this.length = length;
        this.start = start;
        this.now = now;
    }

    @Generated(hash = 692062177)
    public FileInfo(long id, String url, int length, int start, int now) {
        this.id = id;
        this.url = url;
        this.length = length;
        this.start = start;
        this.now = now;
    }

    @Generated(hash = 1367591352)
    public FileInfo() {
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getNow() {
        return now;
    }

    public void setNow(int now) {
        this.now = now;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
