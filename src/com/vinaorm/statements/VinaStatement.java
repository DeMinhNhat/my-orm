package com.vinaorm.statements;

import java.lang.reflect.InvocationTargetException;

public abstract class VinaStatement {

    protected Object obj;

    public VinaStatement() {}

    public VinaStatement(Object obj) {
        this.obj = obj;
    }

    public abstract String buildQuery() throws InvocationTargetException, IllegalAccessException;
}
