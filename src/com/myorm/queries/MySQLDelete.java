package com.myorm.queries;

import com.myorm.annotations.Table;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDelete implements ExecuteUpdate {

    private String sql = "";

    public MySQLDelete(Class clazz, String whereClause) {
        Table tableAnnotation = (Table) clazz.getAnnotation(Table.class);
        String tableName = tableAnnotation.name();

        this.sql = String.format("DELETE FROM %s ", tableName);

        if(whereClause != null) {
            if(!whereClause.isEmpty())
                this.sql += " WHERE " + whereClause;
        }
    }

    @Override
    public int executeUpdate(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        int result = stmt.executeUpdate(this.sql);

        if(stmt != null)
            if (!stmt.isClosed())
                stmt.close();

        return result;
    }
}
