package com.mab.employeemysql;

/**
 * Created by MonisBana on 3/3/2018.
 */

public class Student {
    String name,department;
    int id;

    public Student() {
    }

    public Student(int id, String name, String department) {
        this.name = name;
        this.department = department;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
