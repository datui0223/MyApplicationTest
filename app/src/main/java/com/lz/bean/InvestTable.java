package com.lz.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Unique;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.lz.dao.DaoSession;
import com.lz.dao.ProductTableDao;
import com.lz.dao.InvestTableDao;


/**
 * Created by DELL on 2017/10/31.
 */

@Entity
public class InvestTable {
    @Id
    @Unique
    private Long investId;
    private double investMoney;
    private Date investDate;
    private double investIncome;

    private Long pid;
    @ToOne(joinProperty = "pid")
    private ProductTable productTable;

    private Long oid;//订单id
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 275580120)
    private transient InvestTableDao myDao;

    @Generated(hash = 862449694)
    public InvestTable(Long investId, double investMoney, Date investDate,
            double investIncome, Long pid, Long oid) {
        this.investId = investId;
        this.investMoney = investMoney;
        this.investDate = investDate;
        this.investIncome = investIncome;
        this.pid = pid;
        this.oid = oid;
    }

    @Generated(hash = 1571632562)
    public InvestTable() {
    }

    public Long getInvestId() {
        return this.investId;
    }

    public void setInvestId(Long investId) {
        this.investId = investId;
    }

    public double getInvestMoney() {
        return this.investMoney;
    }

    public void setInvestMoney(double investMoney) {
        this.investMoney = investMoney;
    }

    public Date getInvestDate() {
        return this.investDate;
    }

    public void setInvestDate(Date investDate) {
        this.investDate = investDate;
    }

    public double getInvestIncome() {
        return this.investIncome;
    }

    public void setInvestIncome(double investIncome) {
        this.investIncome = investIncome;
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

    @Generated(hash = 1666673978)
    private transient Long productTable__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1578971973)
    public ProductTable getProductTable() {
        Long __key = this.pid;
        if (productTable__resolvedKey == null
                || !productTable__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ProductTableDao targetDao = daoSession.getProductTableDao();
            ProductTable productTableNew = targetDao.load(__key);
            synchronized (this) {
                productTable = productTableNew;
                productTable__resolvedKey = __key;
            }
        }
        return productTable;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1708950325)
    public void setProductTable(ProductTable productTable) {
        synchronized (this) {
            this.productTable = productTable;
            pid = productTable == null ? null : productTable.getPid();
            productTable__resolvedKey = pid;
        }
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
    @Generated(hash = 911775310)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getInvestTableDao() : null;
    }

}
