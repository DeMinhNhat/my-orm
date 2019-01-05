package com.demo;

import com.vinaorm.MySQLConnection;

public class Main {

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

        conn.insert(new Person(5, "Nghia", "Nguyen"));

        conn.close();
    }
}
