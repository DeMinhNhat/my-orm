package com.vinaorm.utils;

import java.sql.ResultSet;

public class MapperFactory {

    public static <T> Mapper getMapper(String type, Class<T> clazz, ResultSet rs) {
        switch (type) {
            case "mysql":
                return new MySQLMapper(clazz, rs);
            default:
                return null;
        }
    }
}
