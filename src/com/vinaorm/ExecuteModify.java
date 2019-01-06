package com.vinaorm;

import com.vinaorm.statements.ModifyStatement;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface ExecuteModify {

    int executeModifyStatement(ModifyStatement statement) throws SQLException, InvocationTargetException, IllegalAccessException;
}
