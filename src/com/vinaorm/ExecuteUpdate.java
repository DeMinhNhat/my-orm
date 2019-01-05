package com.vinaorm;

import com.vinaorm.statements.VinaStatement;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface ExecuteUpdate {

    int executeUpdateStatement(VinaStatement statement) throws SQLException, InvocationTargetException, IllegalAccessException;
}
