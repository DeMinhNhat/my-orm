package com.vinaorm.statements;

import java.lang.reflect.InvocationTargetException;

public interface VinaStatement {

    String buildQuery() throws InvocationTargetException, IllegalAccessException;
}
