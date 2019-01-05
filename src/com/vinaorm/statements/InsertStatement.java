package com.vinaorm.statements;

import com.vinaorm.utils.MySQLMapper;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class InsertStatement extends VinaStatement {

    public InsertStatement(Object obj) {
        super(obj);
    }

    @Override
    public String buildQuery() throws InvocationTargetException, IllegalAccessException {
        MySQLMapper mapper = new MySQLMapper(obj);

        String tableName = mapper.getTableName();
        HashMap<String , String> map = mapper.getColumnsAndValues();

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
