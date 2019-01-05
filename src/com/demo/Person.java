package com.demo;

import com.myorm.annotations.*;

@Table(name="persons")
public class Person {

    private int id;
    private String fname;
    private String lname;

    public Person(int id, String fname) {
        this.id = id;
        this.fname = fname;
    }

    public Person(int id, String fname, String lname) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
    }

    @Column(name="id", type=ColumnType.INT)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="fname", type=ColumnType.CHAR)
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Column(name="lname", type=ColumnType.CHAR)
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
