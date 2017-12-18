package com.lz.sqlbean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by DELL on 2017/10/23.
 */
@Entity
public class MemberInfo {
    @Id
    private Long uid;
    private Long WealthPoint;
    private Integer grade;
    @Generated(hash = 433245381)
    public MemberInfo(Long uid, Long WealthPoint, Integer grade) {
        this.uid = uid;
        this.WealthPoint = WealthPoint;
        this.grade = grade;
    }
    @Generated(hash = 175316736)
    public MemberInfo() {
    }
    public Long getUid() {
        return this.uid;
    }
    public void setUid(Long uid) {
        this.uid = uid;
    }
    public Long getWealthPoint() {
        return this.WealthPoint;
    }
    public void setWealthPoint(Long WealthPoint) {
        this.WealthPoint = WealthPoint;
    }
    public Integer getGrade() {
        return this.grade;
    }
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "MemberInfo{" +
                "uid=" + uid +
                ", WealthPoint=" + WealthPoint +
                ", grade=" + grade +
                '}';
    }
}
