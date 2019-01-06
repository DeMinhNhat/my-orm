package com.vinaorm;

import com.vinaorm.statements.*;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MySQLConnection extends VinaConnection implements ExecuteModify, ExecuteSelect {

    private String DB_URL;
    private String USERNAME;
    private String PASSWORD;

    private Connection conn = null;


    public static class Builder {

        private String HOST = "";
        private int PORT;
        private String DBNAME = "";
        private String USERNAME = "";
        private String PASSWORD = "";

        public Builder() {}

        public Builder setHost(String HOST) {
            this.HOST = HOST;
            return this;
        }

        public Builder setPort(int PORT) {
            this.PORT = PORT;
            return this;
        }

        public Builder setDbName(String DBNAME) {
            this.DBNAME = DBNAME;
            return this;
        }

        public Builder setUsername(String USERNAME) {
            this.USERNAME = USERNAME;
            return this;
        }

        public Builder setPassword(String PASSWORD) {
            this.PASSWORD = PASSWORD;
            return this;
        }

        public MySQLConnection build() {
            return new MySQLConnection(this);
        }
    }

    private MySQLConnection(Builder builder) {
        this.DB_URL = String.format("jdbc:mysql://%s:%d/%s?autoReconnect=true&useSSL=false", builder.HOST, builder.PORT, builder.DBNAME);
        this.USERNAME = builder.USERNAME;
        this.PASSWORD = builder.PASSWORD;
    }

    @Override
    public void open() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        this.conn = DriverManager.getConnection(this.DB_URL, USERNAME, PASSWORD);
    }

    @Override
    public void close() throws SQLException {
        if(this.conn != null)
            if(!this.conn.isClosed())
                this.conn.close();
    }

    @Override
    public int insert(Object obj) throws SQLException, InvocationTargetException, IllegalAccessException {
        return executeModifyStatement(new MySQLInsertStatement(obj));
    }

    @Override
    public int update(Object obj, String whereClause) throws IllegalAccessException, SQLException, InvocationTargetException {
        return executeModifyStatement(new MySQLUpdateStatement(obj, whereClause));
    }

    @Override
    public int delete(String tableName, String whereClause) throws IllegalAccessException, SQLException, InvocationTargetException {
        return executeModifyStatement(new MySQLDeleteStatement(tableName, whereClause));
    }

    @Override
    public <T> ArrayList<T> select(Class<T> clazz, String statement) {
        return executeSelectStatement(clazz, new MySQLSelectStatement(statement));
    }

    @Override
    public int executeModifyStatement(ModifyStatement statement) throws SQLException, InvocationTargetException, IllegalAccessException {
        String sql = statement.buildQuery();

        if(sql == null)
            return 0;

        System.out.println(sql);

        Statement stmt = conn.createStatement();
        int result = stmt.executeUpdate(sql);

        if(stmt != null)
            if(!stmt.isClosed())
                stmt.close();

        return result;
    }

    @Override
    public <T> ArrayList<T> executeSelectStatement(Class<T> clazz, MySQLSelectStatement statement) {
        // clazz.getName() -> Tên Class để map
        // statement.buildQuery() -> SQL Query
        // Lẹt gô



        return null;
    }
}
