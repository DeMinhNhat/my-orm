package com.demo;

import com.myorm.annotations.PrimaryKey;
import com.vinaorm.annotations.Column;
import com.vinaorm.annotations.ColumnType;
import com.vinaorm.annotations.OneToMany;

import java.util.ArrayList;

public class Class {

    private String id;
    private String name;
    private ArrayList<Person> persons;

    @PrimaryKey
    @Column(name="id", type= ColumnType.CHARACTER)
    public String getId() {
        return id;
    }

    @Column(name="name", type= ColumnType.CHARACTER)
    public String getName() {
        return name;
    }

    @OneToMany(tableName="persons")
    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }
}
