/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compuwork2.service;



import com.mycompany.compuwork2.model.*;
import java.util.ArrayList;
import java.util.List;

public class ReportService {
    private List<PerformanceReport> reports = new ArrayList<>();
    private int reportIdCounter = 1;

    public ReportService() {
        loadSampleData();
    }

    private void loadSampleData() {
        Employee employee1 = new PermanentEmployee(1, "Carlos Pérez", 30, new Department(1, "Ventas"), 5000, 20);
        Employee employee2 = new TemporaryEmployee(2, "Ana Gómez", 25, new Department(2, "Tecnología"), 15.5, 6);
        
        reports.add(new PerformanceReport(reportIdCounter++, employee1, "Jefe de Ventas", 8.5, "Buen desempeño en ventas"));
        reports.add(new PerformanceReport(reportIdCounter++, employee2, "Líder Técnico", 9.0, "Excelente trabajo en desarrollo"));
    }

    public PerformanceReport createReport(Employee emp, String evaluator, double score, String comments) {
        PerformanceReport report = new PerformanceReport(reportIdCounter++, emp, evaluator, score, comments);
        reports.add(report);
        return report;
    }

    public List<PerformanceReport> getAllReports() {
        return reports;
    }

    public List<PerformanceReport> getReportsByEmployee(Employee emp) {
        List<PerformanceReport> result = new ArrayList<>();
        for (PerformanceReport report : reports) {
            if (report.getEmployee().getId() == emp.getId()) {
                result.add(report);
            }
        }
        return result;
    }

    public List<PerformanceReport> getReportsByDepartment(Department dept) {
        List<PerformanceReport> result = new ArrayList<>();
        for (PerformanceReport report : reports) {
            if (report.getEmployee().getDepartment().getId() == dept.getId()) {
                result.add(report);
            }
        }
        return result;
    }
}