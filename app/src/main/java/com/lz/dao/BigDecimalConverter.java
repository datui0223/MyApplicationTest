package com.lz.dao;

/**
 * Created by DELL on 2017/11/1.
 */

import org.greenrobot.greendao.converter.PropertyConverter;

import java.math.BigDecimal;

/**
 * <pre>
 * BigDecimal转换类
 * </pre>
 * Created by Zhou on 17/7/18.
 */
public class BigDecimalConverter implements PropertyConverter<BigDecimal, String> {
    @Override
    public BigDecimal convertToEntityProperty(String databaseValue) {
        return databaseValue == null ? null : new BigDecimal(databaseValue);
    }

    @Override
    public String convertToDatabaseValue(BigDecimal entityProperty) {
        return entityProperty == null ? null : entityProperty.toString();
    }
}
