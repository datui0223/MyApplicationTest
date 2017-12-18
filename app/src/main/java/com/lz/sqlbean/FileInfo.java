package com.lz.sqlbean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

/**
 * Created by DELL on 2017/11/14.
 */
@Entity
public class FileInfo implements Serializable{
    private static final long serialVersionUID = 42L;//实现Serializable接口需要的定义
    @Id
    private long id;
    private String filename;
    private String url;
    private long length;
    private long start;
    private long now;



    @Generated(hash = 1327336950)
    public FileInfo(long id, String filename, String url, long length, long start,
            long now) {
        this.id = id;
        this.filename = filename;
        this.url = url;
        this.length = length;
        this.start = start;
        this.now = now;
    }



    @Generated(hash = 1367591352)
    public FileInfo() {
    }



    @Override
    public String toString() {
        return "FileInfo{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", length=" + length +
                ", start=" + start +
                ", now=" + now +
                '}';
    }



    public long getId() {
        return this.id;
    }



    public void setId(long id) {
        this.id = id;
    }



    public String getFilename() {
        return this.filename;
    }



    public void setFilename(String filename) {
        this.filename = filename;
    }



    public String getUrl() {
        return this.url;
    }



    public void setUrl(String url) {
        this.url = url;
    }



    public long getLength() {
        return this.length;
    }



    public void setLength(long length) {
        this.length = length;
    }



    public long getStart() {
        return this.start;
    }



    public void setStart(long start) {
        this.start = start;
    }



    public long getNow() {
        return this.now;
    }



    public void setNow(long now) {
        this.now = now;
    }


}
