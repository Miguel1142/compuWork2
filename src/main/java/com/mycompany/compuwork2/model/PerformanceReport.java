/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compuwork2.model;

public class PerformanceReport {
    private int id;
    private Employee employee;
    private String evaluator;
    private double score;
    private String comments;

    public PerformanceReport() {}

    public PerformanceReport(int id, Employee employee, String evaluator, double score, String comments) {
        this.id = id;
        this.employee = employee;
        this.evaluator = evaluator;
        this.score = score;
        this.comments = comments;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Employee getEmployee() { return employee; }

    public void setEmployee(Employee employee) { this.employee = employee; }

    public String getEvaluator() { return evaluator; }

    public void setEvaluator(String evaluator) { this.evaluator = evaluator; }

    public double getScore() { return score; }

    public void setScore(double score) { this.score = score; }

    public String getComments() { return comments; }

    public void setComments(String comments) { this.comments = comments; }

    @Override
    public String toString() {
        return "Reporte #" + id + " - Evaluado: " + employee.getName() + ", Evaluador: " + evaluator +
                ", Puntuación: " + score + ", Comentarios: " + comments;
    }
}
