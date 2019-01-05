package com.myorm;

import com.myorm.queries.MySQLDelete;
import com.myorm.queries.MySQLInsert;
import com.myorm.queries.MySQLUpdate;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class XYZMySQLConnection extends XYZConnection {

    private String DB_URL;
    private String USER;
    private String PASSWORD;

    private Connection conn = null;

    public XYZMySQLConnection(String HOST, int PORT, String DBNAME, String USER, String PASSWORD) {
        this.DB_URL = String.format("jdbc:mysql://%s:%d/%s?autoReconnect=true&useSSL=false", HOST, PORT, DBNAME);
        this.USER = USER;
        this.PASSWORD = PASSWORD;
    }

    @Override
    public void open() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        this.conn = DriverManager.getConnection(this.DB_URL, USER, PASSWORD);
    }

    @Override
    public void close() throws SQLException {
        if(this.conn != null && !this.conn.isClosed()) {
            this.conn.close();
            this.conn = null;
        }
    }

    @Override
    public <T> int insert(T obj) throws InvocationTargetException, IllegalAccessException, SQLException {
        MySQLInsert insert = new MySQLInsert(obj);
        return insert.executeUpdate(this.conn);
    }

    @Override
    public <T> int update(T obj, String whereClause) throws InvocationTargetException, IllegalAccessException, SQLException {
        MySQLUpdate update = new MySQLUpdate(obj, whereClause);
        return update.executeUpdate(this.conn);
    }

    @Override
    public <T> int delete(Class<T> clazz, String whereClause) throws SQLException {
        MySQLDelete delete = new MySQLDelete(clazz, whereClause);
        return delete.executeUpdate(this.conn);
    }


}
