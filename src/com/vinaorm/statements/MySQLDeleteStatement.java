package com.vinaorm.statements;

import com.vinaorm.utils.VinaMapper;

public class MySQLDeleteStatement extends ModifyStatement {

    private String tableName;
    private String whereClause;

    public MySQLDeleteStatement(String tableName, String whereClause) {
        this.tableName = tableName;
        this.whereClause = whereClause;
    }

    @Override
    public VinaMapper getMapper(Object obj) {
        return null;
    }

    @Override
    public String buildQuery() {
        return String.format("DELETE FROM %s WHERE %s", this.tableName, this.whereClause);
    }


}
