package com.demo;

import com.myorm.XYZMySQLConnection;

public class Main {

    public static void main(String[] args) throws Exception {
        String HOST = "localhost";
        int PORT = 3306;
        String DBNAME = "db";

        XYZMySQLConnection connMySQL = new XYZMySQLConnection(HOST, PORT, DBNAME, "root", "admin");
        Person person1 = new Person(3, "Simon", "Davison");

        connMySQL.open();

        int result = connMySQL.insert(person1);
        System.out.println(result);

        connMySQL.close();
    }
}
