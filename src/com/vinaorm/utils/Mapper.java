package com.vinaorm.utils;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Mapper<T> {

    protected Class<T> clazz;

    public Mapper(Class<T> clazz) {
        this.clazz = clazz;
    }

    public abstract ArrayList<T> getEntities() throws NoSuchMethodException, SQLException, IllegalAccessException, InvocationTargetException, InstantiationException;

}
