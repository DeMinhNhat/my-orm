package com.myorm;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public abstract class XYZConnection {

    public abstract void open() throws ClassNotFoundException, SQLException;
    public abstract void close() throws SQLException;
    public abstract <T> int insert(T obj) throws InvocationTargetException, IllegalAccessException, SQLException;
    public abstract <T> int update(T obj, String whereClause) throws InvocationTargetException, IllegalAccessException, SQLException;
    public abstract <T> int delete(Class<T> clazz, String whereClause) throws SQLException;
}
