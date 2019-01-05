package com.vinaorm;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public abstract class VinaConnection {

    public abstract void open() throws ClassNotFoundException, SQLException;
    public abstract void close() throws SQLException;
    public abstract int insert(Object obj) throws SQLException, InvocationTargetException, IllegalAccessException;
    public abstract int update(Object obj, String whereClause);
    public abstract int delete(String query);
}
