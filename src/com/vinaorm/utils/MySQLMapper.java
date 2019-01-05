package com.vinaorm.utils;

import com.vinaorm.annotations.Column;
import com.vinaorm.annotations.Table;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class MySQLMapper extends VinaMapper {

    public MySQLMapper(Object obj) {
        super(obj);
    }

    @Override
    public String getTableName() {
        Class c = obj.getClass();

        if(!c.isAnnotationPresent(Table.class)) {
            return null;
        }

        Table tableAnnotation = (Table) c.getAnnotation(Table.class);

        return tableAnnotation == null ? null : tableAnnotation.name();
    }

    @Override
    public HashMap getColumnsAndValues() throws InvocationTargetException, IllegalAccessException {
        Class c = obj.getClass();

        HashMap<String, String> map = new HashMap<>();

        Method[] methods = c.getMethods();

        for(Method method : methods) {
            if(method.isAnnotationPresent(Column.class)) {
                Column columnAnnotation = method.getAnnotation(Column.class);

                String columnName = columnAnnotation.name();
                String columnValue = "";

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

                map.put(columnName, columnValue);
            }
        }

        return map;
    }
}
