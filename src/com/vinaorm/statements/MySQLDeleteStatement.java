package com.vinaorm.statements;


import com.vinaorm.utils.EntityParser;

public class MySQLDeleteStatement extends ModifyStatement {

    private String tableName;
    private String whereClause;

    public MySQLDeleteStatement(String tableName, String whereClause) {
        this.tableName = tableName;
        this.whereClause = whereClause;
    }

    @Override
    public EntityParser getParser(Object obj) {
        return null;
    }

    @Override
    public String buildQuery() {
        return String.format("DELETE FROM %s WHERE %s", this.tableName, this.whereClause);
    }
}
