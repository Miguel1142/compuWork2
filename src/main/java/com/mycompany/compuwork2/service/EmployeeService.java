/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compuwork2.service;



import com.mycompany.compuwork2.model.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();
    private int employeeIdCounter = 1;

    public EmployeeService() {
        loadSampleData();
    }

    private void loadSampleData() {
        Department sales = new Department(1, "Ventas");
        Department it = new Department(2, "Tecnología");
        Department hr = new Department(3, "Recursos Humanos");

        employees.add(new PermanentEmployee(employeeIdCounter++, "Carlos Pérez", 30, sales, 5000, 20));
        employees.add(new TemporaryEmployee(employeeIdCounter++, "Ana Gómez", 25, it, 15.5, 6));
        employees.add(new PermanentEmployee(employeeIdCounter++, "Luis Rodríguez", 40, hr, 6000, 25));
        employees.add(new TemporaryEmployee(employeeIdCounter++, "María Torres", 28, sales, 18.0, 3));
    }

    public Employee addPermanentEmployee(String name, int age, Department dept, double salary, int vacationDays) {
        Employee emp = new PermanentEmployee(employeeIdCounter++, name, age, dept, salary, vacationDays);
        employees.add(emp);
        return emp;
    }

    public Employee addTemporaryEmployee(String name, int age, Department dept, double hourlyRate, int contractDuration) {
        Employee emp = new TemporaryEmployee(employeeIdCounter++, name, age, dept, hourlyRate, contractDuration);
        employees.add(emp);
        return emp;
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeById(int id) {
        return employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public boolean removeEmployee(int id) {
        return employees.removeIf(e -> e.getId() == id);
    }

    public void changeDepartment(int id, Department newDept) {
        Employee emp = getEmployeeById(id);
        if (emp != null) {
            emp.setDepartment(newDept);
        }
    }
}
