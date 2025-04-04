/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compuwork2.model;



public class PermanentEmployee extends Employee {
    private double salary;
    private int vacationDays;

    public PermanentEmployee() {}

    public PermanentEmployee(int id, String name, int age, Department department, double salary, int vacationDays) {
        super(id, name, age, department);
        this.salary = salary;
        this.vacationDays = vacationDays;
    }

    public double getSalary() { return salary; }

    public void setSalary(double salary) { this.salary = salary; }

    public int getVacationDays() { return vacationDays; }

    public void setVacationDays(int vacationDays) { this.vacationDays = vacationDays; }

    @Override
    public String getDetails() {
        return super.toString() + ", Tipo: Permanente, Salario: $" + salary + ", Vacaciones: " + vacationDays + " días";
    }
}
