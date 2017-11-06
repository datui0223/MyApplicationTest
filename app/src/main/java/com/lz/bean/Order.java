package com.lz.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.Date;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.lz.dao.DaoSession;
import com.lz.dao.InvestTableDao;
import com.lz.dao.OrderDao;


/**
 * Created by DELL on 2017/11/1.
 */
@Entity
public class Order {
    @Id
    private Long oid;
    private Date odate;

    private Long uid;

    @ToMany(referencedJoinProperty = "oid")
    private List<InvestTable> investTables;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 949219203)
    private transient OrderDao myDao;

    @Generated(hash = 48594303)
    public Order(Long oid, Date odate, Long uid) {
        this.oid = oid;
        this.odate = odate;
        this.uid = uid;
    }

    @Generated(hash = 1105174599)
    public Order() {
    }

    public Long getOid() {
        return this.oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Date getOdate() {
        return this.odate;
    }

    public void setOdate(Date odate) {
        this.odate = odate;
    }

    public Long getUid() {
        return this.uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 81841400)
    public List<InvestTable> getInvestTables() {
        if (investTables == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            InvestTableDao targetDao = daoSession.getInvestTableDao();
            List<InvestTable> investTablesNew = targetDao
                    ._queryOrder_InvestTables(oid);
            synchronized (this) {
                if (investTables == null) {
                    investTables = investTablesNew;
                }
            }
        }
        return investTables;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 2134559196)
    public synchronized void resetInvestTables() {
        investTables = null;
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
    @Generated(hash = 965731666)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getOrderDao() : null;
    }
}
