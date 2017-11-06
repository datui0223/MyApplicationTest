package com.lz.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import java.math.BigDecimal;

import com.lz.bean.ProductTable;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "PRODUCT_TABLE".
*/
public class ProductTableDao extends AbstractDao<ProductTable, Long> {

    public static final String TABLENAME = "PRODUCT_TABLE";

    /**
     * Properties of entity ProductTable.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Pid = new Property(0, Long.class, "pid", true, "_id");
        public final static Property Ptype = new Property(1, String.class, "ptype", false, "PTYPE");
        public final static Property Amount = new Property(2, String.class, "amount", false, "AMOUNT");
        public final static Property LeastInvestAmount = new Property(3, String.class, "leastInvestAmount", false, "LEAST_INVEST_AMOUNT");
        public final static Property MaxInvestAmount = new Property(4, String.class, "maxInvestAmount", false, "MAX_INVEST_AMOUNT");
    }

    private DaoSession daoSession;

    private final BigDecimalConverter amountConverter = new BigDecimalConverter();
    private final BigDecimalConverter leastInvestAmountConverter = new BigDecimalConverter();
    private final BigDecimalConverter maxInvestAmountConverter = new BigDecimalConverter();

    public ProductTableDao(DaoConfig config) {
        super(config);
    }
    
    public ProductTableDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PRODUCT_TABLE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY UNIQUE ," + // 0: pid
                "\"PTYPE\" TEXT," + // 1: ptype
                "\"AMOUNT\" TEXT," + // 2: amount
                "\"LEAST_INVEST_AMOUNT\" TEXT," + // 3: leastInvestAmount
                "\"MAX_INVEST_AMOUNT\" TEXT);"); // 4: maxInvestAmount
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PRODUCT_TABLE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ProductTable entity) {
        stmt.clearBindings();
 
        Long pid = entity.getPid();
        if (pid != null) {
            stmt.bindLong(1, pid);
        }
 
        String ptype = entity.getPtype();
        if (ptype != null) {
            stmt.bindString(2, ptype);
        }
 
        BigDecimal amount = entity.getAmount();
        if (amount != null) {
            stmt.bindString(3, amountConverter.convertToDatabaseValue(amount));
        }
 
        BigDecimal leastInvestAmount = entity.getLeastInvestAmount();
        if (leastInvestAmount != null) {
            stmt.bindString(4, leastInvestAmountConverter.convertToDatabaseValue(leastInvestAmount));
        }
 
        BigDecimal maxInvestAmount = entity.getMaxInvestAmount();
        if (maxInvestAmount != null) {
            stmt.bindString(5, maxInvestAmountConverter.convertToDatabaseValue(maxInvestAmount));
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ProductTable entity) {
        stmt.clearBindings();
 
        Long pid = entity.getPid();
        if (pid != null) {
            stmt.bindLong(1, pid);
        }
 
        String ptype = entity.getPtype();
        if (ptype != null) {
            stmt.bindString(2, ptype);
        }
 
        BigDecimal amount = entity.getAmount();
        if (amount != null) {
            stmt.bindString(3, amountConverter.convertToDatabaseValue(amount));
        }
 
        BigDecimal leastInvestAmount = entity.getLeastInvestAmount();
        if (leastInvestAmount != null) {
            stmt.bindString(4, leastInvestAmountConverter.convertToDatabaseValue(leastInvestAmount));
        }
 
        BigDecimal maxInvestAmount = entity.getMaxInvestAmount();
        if (maxInvestAmount != null) {
            stmt.bindString(5, maxInvestAmountConverter.convertToDatabaseValue(maxInvestAmount));
        }
    }

    @Override
    protected final void attachEntity(ProductTable entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public ProductTable readEntity(Cursor cursor, int offset) {
        ProductTable entity = new ProductTable( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // pid
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // ptype
            cursor.isNull(offset + 2) ? null : amountConverter.convertToEntityProperty(cursor.getString(offset + 2)), // amount
            cursor.isNull(offset + 3) ? null : leastInvestAmountConverter.convertToEntityProperty(cursor.getString(offset + 3)), // leastInvestAmount
            cursor.isNull(offset + 4) ? null : maxInvestAmountConverter.convertToEntityProperty(cursor.getString(offset + 4)) // maxInvestAmount
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ProductTable entity, int offset) {
        entity.setPid(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPtype(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setAmount(cursor.isNull(offset + 2) ? null : amountConverter.convertToEntityProperty(cursor.getString(offset + 2)));
        entity.setLeastInvestAmount(cursor.isNull(offset + 3) ? null : leastInvestAmountConverter.convertToEntityProperty(cursor.getString(offset + 3)));
        entity.setMaxInvestAmount(cursor.isNull(offset + 4) ? null : maxInvestAmountConverter.convertToEntityProperty(cursor.getString(offset + 4)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(ProductTable entity, long rowId) {
        entity.setPid(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(ProductTable entity) {
        if(entity != null) {
            return entity.getPid();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(ProductTable entity) {
        return entity.getPid() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}