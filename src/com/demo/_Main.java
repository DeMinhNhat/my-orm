package com.demo;

import com.vinaorm.MySQLConnection;

import java.util.ArrayList;

public class _Main {

    public static void main(String[] args) throws Exception {

        MySQLConnection.Builder mySQLConnectionBuilder = new MySQLConnection.Builder();
        MySQLConnection conn = mySQLConnectionBuilder
                                    .setHost("localhost")
                                    .setPort(3306)
                                    .setDbName("db")
                                    .setUsername("root")
                                    .setPassword("admin")
                                    .build();
        conn.open();

        ArrayList<Person> rows = conn.select(Person.class, "HIHAHOHE");

        conn.close();
    }
}
