package com.vinaorm.statements;


import com.vinaorm.utils.EntityParser;

import java.util.HashMap;

public class MySQLUpdateStatement extends ModifyStatement {

    private String whereClause;

    public MySQLUpdateStatement(Object obj, String whereClause) {
        super(obj);
        this.whereClause = whereClause;
    }

    @Override
    public EntityParser getParser(Object obj) throws IllegalAccessException {
        return new EntityParser(obj);
    }

    @Override
    public String buildQuery() throws IllegalAccessException {
        EntityParser parser = getParser(obj);

        String tableName = parser.getTableName();
        HashMap<String , String> map = parser.getColumnsAndValues();

        if(map.size() != 0) {
            int i = 1;
            String sql_set = "";

            for(HashMap.Entry<String, String> entry : map.entrySet()) {
                if(i == map.size()) {
                    sql_set += entry.getKey() + " = " + entry.getValue();
                } else {
                    sql_set += entry.getKey() + " = " + entry.getValue() + ",";
                }

                i++;
            }

            return String.format("UPDATE %s SET %s WHERE %s", tableName, sql_set, whereClause);
        }

        return null;
    }
}
