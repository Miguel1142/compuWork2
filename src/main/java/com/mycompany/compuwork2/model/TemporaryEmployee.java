/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compuwork2.model;

public class TemporaryEmployee extends Employee {
    private double hourlyRate;
    private int contractDuration; // en meses

    public TemporaryEmployee() {}

    public TemporaryEmployee(int id, String name, int age, Department department, double hourlyRate, int contractDuration) {
        super(id, name, age, department);
        this.hourlyRate = hourlyRate;
        this.contractDuration = contractDuration;
    }

    public double getHourlyRate() { return hourlyRate; }

    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }

    public int getContractDuration() { return contractDuration; }

    public void setContractDuration(int contractDuration) { this.contractDuration = contractDuration; }

    @Override
    public String getDetails() {
        return super.toString() + ", Tipo: Temporal, Tarifa por hora: $" + hourlyRate + ", Duración contrato: " + contractDuration + " meses";
    }
}