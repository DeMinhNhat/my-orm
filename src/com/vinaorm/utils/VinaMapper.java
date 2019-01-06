package com.vinaorm.utils;

import java.util.HashMap;

public abstract class VinaMapper {

    protected Object obj;

    public VinaMapper(Object obj) {
        this.obj = obj;
    }

    public abstract String getTableName();
    public abstract HashMap getPrimaryColumn();
    public abstract HashMap getColumnsAndValues();
}
