package com.lz.bean;


import com.lz.dao.BigDecimalConverter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Unique;

import java.math.BigDecimal;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.lz.dao.DaoSession;
import com.lz.dao.OrderDao;
import com.lz.dao.ProductTableDao;

/**
 * Created by DELL on 2017/10/31.
 */
@Entity
public class ProductTable {
    @Id
    @Unique
    private Long pid;
    private String ptype;
    @Convert(converter = BigDecimalConverter.class,columnType = String.class)//类型不支持
    private BigDecimal amount;
    @Convert(converter = BigDecimalConverter.class,columnType = String.class)
    private BigDecimal leastInvestAmount;
    @Convert(converter = BigDecimalConverter.class,columnType = String.class)
    private BigDecimal maxInvestAmount;
    @ToMany
    @JoinEntity(entity = OrderByProduct.class,sourceProperty = "pid",targetProperty = "oid")
    private List<Order> orders;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 2065091662)
    private transient ProductTableDao myDao;
    @Generated(hash = 1627747929)
    public ProductTable(Long pid, String ptype, BigDecimal amount,
            BigDecimal leastInvestAmount, BigDecimal maxInvestAmount) {
        this.pid = pid;
        this.ptype = ptype;
        this.amount = amount;
        this.leastInvestAmount = leastInvestAmount;
        this.maxInvestAmount = maxInvestAmount;
    }
    @Generated(hash = 1824922615)
    public ProductTable() {
    }
    public Long getPid() {
        return this.pid;
    }
    public void setPid(Long pid) {
        this.pid = pid;
    }
    public String getPtype() {
        return this.ptype;
    }
    public void setPtype(String ptype) {
        this.ptype = ptype;
    }
    public BigDecimal getAmount() {
        return this.amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public BigDecimal getLeastInvestAmount() {
        return this.leastInvestAmount;
    }
    public void setLeastInvestAmount(BigDecimal leastInvestAmount) {
        this.leastInvestAmount = leastInvestAmount;
    }
    public BigDecimal getMaxInvestAmount() {
        return this.maxInvestAmount;
    }
    public void setMaxInvestAmount(BigDecimal maxInvestAmount) {
        this.maxInvestAmount = maxInvestAmount;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 33038143)
    public List<Order> getOrders() {
        if (orders == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            OrderDao targetDao = daoSession.getOrderDao();
            List<Order> ordersNew = targetDao._queryProductTable_Orders(pid);
            synchronized (this) {
                if (orders == null) {
                    orders = ordersNew;
                }
            }
        }
        return orders;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1446109810)
    public synchronized void resetOrders() {
        orders = null;
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1206923914)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getProductTableDao() : null;
    }
}
