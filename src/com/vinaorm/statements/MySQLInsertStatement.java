package com.vinaorm.statements;

import com.vinaorm.utils.EntityParser;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class MySQLInsertStatement extends ModifyStatement {

    public MySQLInsertStatement(Object obj) {
        super(obj);
    }

    @Override
    public EntityParser getParser(Object obj) throws IllegalAccessException {
        return new EntityParser(obj);
    }

    @Override
    public String buildQuery() throws InvocationTargetException, IllegalAccessException {
        EntityParser parser = getParser(obj);

        String tableName = parser.getTableName();
        HashMap<String , String> map = parser.getColumnsAndValues();

        if(map.size() != 0) {
            int i = 1;
            String sql_left = "", sql_right = "";

            for(HashMap.Entry<String, String> entry : map.entrySet()) {
                if(i == map.size()) {
                    sql_left += entry.getKey();
                    sql_right += entry.getValue();
                } else {
                    sql_left += entry.getKey() + ",";
                    sql_right += entry.getValue() + ",";
                }

                i++;
            }

            return String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, sql_left, sql_right);
        }

        return null;
    }
}
