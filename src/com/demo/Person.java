package com.demo;

import com.vinaorm.annotations.*;

@Table(name="persons")
public class Person {

    @PrimaryKey
    @Column(name="id", type=ColumnType.CHARACTER)
    public  String id;

    @Column(name="fname", type=ColumnType.CHARACTER)
    public  String fname;

    @Column(name="lname", type=ColumnType.CHARACTER)
    public  String lname;

    @Column(name="class", type=ColumnType.CHARACTER)
    public  String classId;

    public Person(String id, String fname, String lname, String classId) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.classId = classId;
    }


    public String getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public String getLname() {
        return lname;
    }
    public String getClassId(){
        return classId;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public void setClassId(String classId) {
        this.classId = classId;
    }
}
