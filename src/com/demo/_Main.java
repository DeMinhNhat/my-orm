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

        ArrayList<Teacher> list = conn.select(Teacher.class, "SELECT * FROM teacher");
        System.out.println(list.size());

        for(int i = 0 ; i < list.size(); i++) {
            System.out.println(list.get(i).height + " " + list.get(i).name);
        }

        conn.close();
    }
}
