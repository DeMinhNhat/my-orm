package com.myorm.queries;

import java.sql.Connection;
import java.sql.SQLException;

public interface ExecuteUpdate {

    int executeUpdate(Connection conn) throws SQLException;
}
