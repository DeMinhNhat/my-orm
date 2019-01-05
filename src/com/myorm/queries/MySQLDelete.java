package com.myorm.queries;

import com.myorm.annotations.Table;

public class MySQLDelete extends MySQLExecute {

    public MySQLDelete(Class clazz, String whereClause) {
        Table tableAnnotation = (Table) clazz.getAnnotation(Table.class);
        String tableName = tableAnnotation.name();

        this.sql = String.format("DELETE FROM %s ", tableName);

        if (whereClause != null) {
            if (!whereClause.isEmpty())
                this.sql += " WHERE " + whereClause;
        }
    }
}
