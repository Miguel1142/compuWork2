/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compuwork2.model;


public abstract class Employee {
    protected int id;
    protected String name;
    protected int age;
    protected Department department;

    public Employee() {}

    public Employee(int id, String name, int age, Department department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public Department getDepartment() { return department; }

    public void setDepartment(Department department) { this.department = department; }

    public abstract String getDetails();

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + name + ", Edad: " + age + ", Departamento: " +
                (department != null ? department.getName() : "No asignado");
    }
}