package com.vinaorm;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class VinaConnection {

    public abstract void open() throws ClassNotFoundException, SQLException;
    public abstract void close() throws SQLException;
    public abstract int insert(Object obj) throws SQLException, InvocationTargetException, IllegalAccessException;
    public abstract int update(Object obj, String whereClause) throws IllegalAccessException, SQLException, InvocationTargetException;
    public abstract int delete(String tableName, String whereClause) throws IllegalAccessException, SQLException, InvocationTargetException;
    public abstract <T> ArrayList<T> select(Class<T> clazz, String selectStatement);
}
