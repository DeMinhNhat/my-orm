package com.vinaorm;

import com.vinaorm.statements.InsertStatement;
import com.vinaorm.statements.VinaStatement;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection extends VinaConnection implements ExecuteUpdate {

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
        return executeUpdateStatement(new InsertStatement(obj));
    }

    @Override
    public int update(Object obj, String whereClause) {
        return 0;
    }

    @Override
    public int delete(String query) {
        return 0;
    }

    @Override
    public int executeUpdateStatement(VinaStatement statement) throws SQLException, InvocationTargetException, IllegalAccessException {
        String sql = statement.buildQuery();

        if(sql == null)
            return 0;

        Statement stmt = conn.createStatement();
        int result = stmt.executeUpdate(sql);

        if(stmt != null)
            if(!stmt.isClosed())
                stmt.close();

        return result;
    }
}
