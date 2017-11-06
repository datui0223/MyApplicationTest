package com.lz.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by DELL on 2017/11/1.
 */
@Entity
public class OrderByProduct {
    @Id
    private Long opid;

    private Long pid;
    private Long oid;
    @Generated(hash = 1999927778)
    public OrderByProduct(Long opid, Long pid, Long oid) {
        this.opid = opid;
        this.pid = pid;
        this.oid = oid;
    }
    @Generated(hash = 845691012)
    public OrderByProduct() {
    }
    public Long getOpid() {
        return this.opid;
    }
    public void setOpid(Long opid) {
        this.opid = opid;
    }
    public Long getPid() {
        return this.pid;
    }
    public void setPid(Long pid) {
        this.pid = pid;
    }
    public Long getOid() {
        return this.oid;
    }
    public void setOid(Long oid) {
        this.oid = oid;
    }

}
