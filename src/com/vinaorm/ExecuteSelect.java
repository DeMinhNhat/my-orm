package com.vinaorm;

import com.vinaorm.statements.MySQLSelectStatement;

import java.util.ArrayList;

public interface ExecuteSelect {

    <T> ArrayList<T> executeSelectStatement(Class<T> clazz, MySQLSelectStatement statement);
}
