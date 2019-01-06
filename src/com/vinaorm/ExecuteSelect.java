package com.vinaorm;

import com.vinaorm.statements.MySQLSelectStatement;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ExecuteSelect {

    <T> ArrayList<T> executeSelectStatement(Class<T> clazz, MySQLSelectStatement statement) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, SQLException;
}
