package com.myorm.queries;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class MySQLUpdate extends MySQLExecute {

    private Object obj;

    public MySQLUpdate(Object obj, String whereClause) throws InvocationTargetException, IllegalAccessException {
        this.obj = obj;

        XYZMySQLMapper mapperMySQL = new XYZMySQLMapper(this.obj);

        String tableName = mapperMySQL.getTableName();
        HashMap<String, String> map = mapperMySQL.getColumnsAndValues();

        if (map.size() != 0) {
            int i = 1;
            String sql_set = "";
            for (HashMap.Entry<String, String> entry : map.entrySet()) {
                if (i == map.size()) {
                    sql_set += entry.getKey() + " = " + entry.getValue();
                } else {
                    sql_set += entry.getKey() + " = " + entry.getValue() + ",";
                }
                i++;
            }

            this.sql = String.format("UPDATE %s SET %s WHERE %s", tableName, sql_set, whereClause);
        }
    }
}
