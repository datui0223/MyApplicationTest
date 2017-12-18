package com.lz.sqlbean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.lz.dao.DaoSession;
import com.lz.dao.MemberInfoDao;
import com.lz.dao.UserDao;

import java.util.List;
import com.lz.dao.OrderDao;

/**
 * Created by DELL on 2017/10/23.
 */

@Entity(indexes = {})
public class User {
    @Id
    @Unique
    private Long uid;
    @NotNull
    private String name;

    private Integer age;

    private String flag;

    @ToMany(joinProperties = {@JoinProperty(name = "uid",referencedName = "uid")})
    private List<Order> orders;
    @ToOne(joinProperty = "uid")
    private MemberInfo memberInfo;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1507654846)
    private transient UserDao myDao;
    @Generated(hash = 66475789)
    private transient Long memberInfo__resolvedKey;


    @Generated(hash = 586692638)
    public User() {
    }




    @Generated(hash = 191442043)
    public User(Long uid, @NotNull String name, Integer age, String flag) {
        this.uid = uid;
        this.name = name;
        this.age = age;
        this.flag = flag;
    }




    public Long getUid() {
        return this.uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public String getFlag() {
        return this.flag;
    }


    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", flag='" + flag + '\'' +
                '}';
    }




    /** To-one relationship, resolved on first access. */
    @Generated(hash = 95657527)
    public MemberInfo getMemberInfo() {
        Long __key = this.uid;
        if (memberInfo__resolvedKey == null
                || !memberInfo__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MemberInfoDao targetDao = daoSession.getMemberInfoDao();
            MemberInfo memberInfoNew = targetDao.load(__key);
            synchronized (this) {
                memberInfo = memberInfoNew;
                memberInfo__resolvedKey = __key;
            }
        }
        return memberInfo;
    }




    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 252915183)
    public void setMemberInfo(MemberInfo memberInfo) {
        synchronized (this) {
            this.memberInfo = memberInfo;
            uid = memberInfo == null ? null : memberInfo.getUid();
            memberInfo__resolvedKey = uid;
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
    @Generated(hash = 2059241980)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserDao() : null;
    }




    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 589073715)
    public List<Order> getOrders() {
        if (orders == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            OrderDao targetDao = daoSession.getOrderDao();
            List<Order> ordersNew = targetDao._queryUser_Orders(uid);
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
}
