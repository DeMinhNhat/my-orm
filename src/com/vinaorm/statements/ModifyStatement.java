package com.vinaorm.statements;

import com.vinaorm.utils.EntityParser;

public abstract class ModifyStatement implements VinaStatement {

    protected Object obj;

    public ModifyStatement() {
        obj = null;
    }

    public ModifyStatement(Object obj) {
        this.obj = obj;
    }

    public abstract EntityParser getParser(Object obj) throws IllegalAccessException;
}
