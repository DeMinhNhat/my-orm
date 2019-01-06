package com.vinaorm.utils;

import com.vinaorm.annotations.Column;
import com.vinaorm.annotations.PrimaryKey;
import com.vinaorm.annotations.Table;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class MySQLMapper extends VinaMapper {

    private String tableName = null;
    private HashMap<String, String> mapColumnsValues = null;
    private HashMap<String, String> primaryKey = null;

    public MySQLMapper(Object obj) throws InvocationTargetException, IllegalAccessException {
        super(obj);

        Class c = obj.getClass();

        if(c.isAnnotationPresent(Table.class)) {
            Table tableAnnotation = (Table) c.getAnnotation(Table.class);
            this.tableName = tableAnnotation.name();
        }

        this.mapColumnsValues = new HashMap<>();
        this.primaryKey = new HashMap<>();

        Method[] methods = c.getMethods();

        for(Method method : methods) {
            if(method.isAnnotationPresent(Column.class)) {
                Column columnAnnotation = method.getAnnotation(Column.class);

                String columnName = columnAnnotation.name();
                String columnValue = "";

                if(method.invoke(this.obj) != null) {
                    switch(columnAnnotation.type()) {
                        case CHARACTER:
                            columnValue = "\'" + method.invoke(this.obj) + "\'";
                            break;
                        case INTEGER:
                            columnValue = String.valueOf(method.invoke(this.obj));
                            break;
                        case DECIMAL:
                            columnValue = String.valueOf(method.invoke(this.obj));
                            break;
                        default:
                            break;
                    }

                    mapColumnsValues.put(columnName, columnValue);
                }

                if(method.isAnnotationPresent(PrimaryKey.class)) {
                    primaryKey.put(columnName, columnValue);
                }
            }
        }
    }

    @Override
    public String getTableName() {
        return this.tableName;
    }

    @Override
    public HashMap getPrimaryColumn() {
        return this.mapColumnsValues;
    }

    @Override
    public HashMap getColumnsAndValues() {
        return this.mapColumnsValues;
    }
}
