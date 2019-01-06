package com.myorm.queries;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class MySQLExecute {

    protected String sql;

    public int executeUpdate(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        int result = stmt.executeUpdate(this.sql);

        if (stmt != null)
            if (!stmt.isClosed())
                stmt.close();

        return result;
    }
}