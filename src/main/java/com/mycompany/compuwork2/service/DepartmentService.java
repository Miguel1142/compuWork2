/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compuwork2.service;



import com.mycompany.compuwork2.model.Department;
import java.util.ArrayList;
import java.util.List;

public class DepartmentService {
    private List<Department> departments = new ArrayList<>();
    private int departmentIdCounter = 1;

    public DepartmentService() {
        loadSampleData();
    }

    private void loadSampleData() {
        departments.add(new Department(departmentIdCounter++, "Ventas"));
        departments.add(new Department(departmentIdCounter++, "Tecnología"));
        departments.add(new Department(departmentIdCounter++, "Recursos Humanos"));
    }

    public Department addDepartment(String name) {
        Department dept = new Department(departmentIdCounter++, name);
        departments.add(dept);
        return dept;
    }

    public List<Department> getAllDepartments() {
        return departments;
    }

    public Department getDepartmentById(int id) {
        return departments.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }

    public boolean removeDepartment(int id) {
        return departments.removeIf(d -> d.getId() == id);
    }
}