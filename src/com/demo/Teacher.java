package com.demo;

import com.vinaorm.annotations.Column;
import com.vinaorm.annotations.ColumnType;
import com.vinaorm.annotations.PrimaryKey;
import com.vinaorm.annotations.Table;

@Table(name="teacher")
public class Teacher {

    @PrimaryKey
    @Column(name="id", type= ColumnType.INTEGER)
    public int id;

    @Column(name="height", type= ColumnType.DECIMAL)
    public double height;

    @Column(name="name", type= ColumnType.CHARACTER)
    public String name;

    public Teacher(int id, float height, String name) {
        this.id = id;
        this.height = height;
        this.name = name;
    }

    public Teacher() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
