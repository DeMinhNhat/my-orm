package com.vinaorm.statements;

import com.vinaorm.utils.VinaMapper;

import java.lang.reflect.InvocationTargetException;

public abstract class ModifyStatement implements VinaStatement {

    protected Object obj;

    public ModifyStatement() {
        obj = null;
    }

    public ModifyStatement(Object obj) {
        this.obj = obj;
    }

    public abstract VinaMapper getMapper(Object obj) throws InvocationTargetException, IllegalAccessException;
}
