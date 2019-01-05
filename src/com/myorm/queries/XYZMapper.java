package com.myorm.queries;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public abstract class XYZMapper {

    protected Object obj;

    public XYZMapper(Object obj) {
        this.obj = obj;
    }

    public abstract String getTableName();
    public abstract HashMap getColumnsAndValues() throws InvocationTargetException, IllegalAccessException;
}
