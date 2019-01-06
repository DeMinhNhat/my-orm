package com.myorm.queries;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class MySQLInsert extends MySQLExecute {

    private Object obj;

    public MySQLInsert(Object obj) throws InvocationTargetException, IllegalAccessException {
        this.obj = obj;

        XYZMySQLMapper mapperMySQL = new XYZMySQLMapper(this.obj);

        String tableName = mapperMySQL.getTableName();
        HashMap<String, String> map = mapperMySQL.getColumnsAndValues();

        if (map.size() != 0) {
            int i = 1;
            String sql_left = "", sql_right = "";

            for (HashMap.Entry<String, String> entry : map.entrySet()) {
                if (i == map.size()) {
                    sql_left += entry.getKey();
                    sql_right += entry.getValue();
                } else {
                    sql_left += entry.getKey() + ",";
                    sql_right += entry.getValue() + ",";
                }

                i++;
            }

            this.sql = String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, sql_left, sql_right);
        }
    }
}
