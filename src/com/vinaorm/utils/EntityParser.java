package com.vinaorm.utils;

import com.vinaorm.annotations.Column;
import com.vinaorm.annotations.PrimaryKey;
import com.vinaorm.annotations.Table;

import java.lang.reflect.Field;
import java.util.HashMap;

public class EntityParser {

    private Object obj;
    private String tableName = null;
    private HashMap<String, String> mapColumnsValues = null;
    private HashMap<String, String> primaryKey = null;

    public EntityParser(Object obj) throws IllegalAccessException {
        this.obj = obj;

        Class c = obj.getClass();

        if(c.isAnnotationPresent(Table.class)) {
            Table tableAnnotation = (Table) c.getAnnotation(Table.class);
            this.tableName = tableAnnotation.name();
        }

        this.mapColumnsValues = new HashMap<>();
        this.primaryKey = new HashMap<>();

        Field[] fields = c.getFields();

        for(Field field : fields) {
            if(field.isAnnotationPresent(Column.class)) {
                Column columnAnnotation = field.getAnnotation(Column.class);

                String columnName = columnAnnotation.name();
                String columnValue = "";

                if(field.get(this.obj) != null) {
                    switch(columnAnnotation.type()) {
                        case CHARACTER:
                            columnValue = "\'" + field.get(this.obj) + "\'";
                            break;
                        case INTEGER:
                            columnValue = String.valueOf(field.get(this.obj));
                            break;
                        case DECIMAL:
                            columnValue = String.valueOf(field.get(this.obj));
                            break;
                        default:
                            break;
                    }

                    mapColumnsValues.put(columnName, columnValue);

                    if(field.isAnnotationPresent(PrimaryKey.class)) {
                        primaryKey.put(columnName, columnValue);
                    }
                }
            }
        }
    }

    public String getTableName() {
        return this.tableName;
    }

    public HashMap getPrimaryColumn() {
        return this.mapColumnsValues;
    }

    public HashMap getColumnsAndValues() {
        return this.mapColumnsValues;
    }
}
