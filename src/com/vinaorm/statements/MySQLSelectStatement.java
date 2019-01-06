package com.vinaorm.statements;

public class MySQLSelectStatement implements VinaStatement {

    private String sql;

    public MySQLSelectStatement(String sql) {
        this.sql = sql;
    }

    @Override
    public String buildQuery() {
        return this.sql;
    }
}
