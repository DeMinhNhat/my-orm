package com.vinaorm.statements;

import com.vinaorm.utils.MySQLMapper;
import com.vinaorm.utils.VinaMapper;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class MySQLUpdateStatement extends ModifyStatement {

    private String whereClause;

    public MySQLUpdateStatement(Object obj, String whereClause) {
        super(obj);
        this.whereClause = whereClause;
    }

    @Override
    public VinaMapper getMapper(Object obj) throws InvocationTargetException, IllegalAccessException {
        return new MySQLMapper(obj);
    }

    @Override
    public String buildQuery() throws InvocationTargetException, IllegalAccessException {
        MySQLMapper mapper = (MySQLMapper) getMapper(obj);

        String tableName = mapper.getTableName();
        HashMap<String , String> map = mapper.getColumnsAndValues();

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
