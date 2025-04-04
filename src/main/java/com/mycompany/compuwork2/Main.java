/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compuwork2;


import com.mycompany.compuwork2.model.*;

import com.mycompany.compuwork2.service.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static EmployeeService employeeService = new EmployeeService();
    private static DepartmentService departmentService = new DepartmentService();
    private static ReportService reportService = new ReportService();

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("    Bienvenido al sistema CompuWork");
        System.out.println("====================================");

        boolean running = true;
        while (running) {
            printMainMenu();
            int option = getUserInputInt("Seleccione una opción: ");
            switch (option) {
                case 1 -> manageEmployees();
                case 2 -> manageDepartments();
                case 3 -> manageReports();
                case 4 -> {
                    System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                    running = false;
                }
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n--- Menú Principal ---");
        System.out.println("1. Gestión de Empleados");
        System.out.println("2. Gestión de Departamentos");
        System.out.println("3. Reportes de Desempeño");
        System.out.println("4. Salir");
    }

    // =============================
    // Gestión de Empleados
    // =============================
    private static void manageEmployees() {
        System.out.println("\n--- Gestión de Empleados ---");
        System.out.println("1. Agregar empleado permanente");
        System.out.println("2. Agregar empleado temporal");
        System.out.println("3. Listar empleados");
        System.out.println("4. Cambiar empleado de departamento");
        System.out.println("5. Eliminar empleado");
        System.out.println("6. Volver al menú principal");

        int option = getUserInputInt("Seleccione una opción: ");
        switch (option) {
            case 1 -> addPermanentEmployee();
            case 2 -> addTemporaryEmployee();
            case 3 -> listEmployees();
            case 4 -> changeEmployeeDepartment();
            case 5 -> removeEmployee();
            case 6 -> {}
            default -> System.out.println("Opción inválida.");
        }
    }

    private static void addPermanentEmployee() {
        String name = getUserInput("Nombre: ");
        int age = getUserInputInt("Edad: ");
        Department dept = selectDepartment();
        double salary = getUserInputDouble("Salario: ");
        int vacation = getUserInputInt("Días de vacaciones: ");

        Employee emp = employeeService.addPermanentEmployee(name, age, dept, salary, vacation);
        System.out.println("Empleado creado: " + emp.getDetails());
    }

    private static void addTemporaryEmployee() {
        String name = getUserInput("Nombre: ");
        int age = getUserInputInt("Edad: ");
        Department dept = selectDepartment();
        double hourly = getUserInputDouble("Tarifa por hora: ");
        int duration = getUserInputInt("Duración del contrato (meses): ");

        Employee emp = employeeService.addTemporaryEmployee(name, age, dept, hourly, duration);
        System.out.println("Empleado creado: " + emp.getDetails());
    }

    private static void listEmployees() {
        List<Employee> list = employeeService.getAllEmployees();
        if (list.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (Employee emp : list) {
                System.out.println(emp.getDetails());
            }
        }
    }

    private static void changeEmployeeDepartment() {
        int empId = getUserInputInt("ID del empleado: ");
        Employee emp = employeeService.getEmployeeById(empId);
        if (emp == null) {
            System.out.println("Empleado no encontrado.");
            return;
        }
        Department newDept = selectDepartment();
        employeeService.changeDepartment(empId, newDept);
        System.out.println("Empleado actualizado.");
    }

    private static void removeEmployee() {
        int id = getUserInputInt("ID del empleado a eliminar: ");
        boolean removed = employeeService.removeEmployee(id);
        System.out.println(removed ? "Empleado eliminado." : "No se pudo eliminar.");
    }

    // =============================
    // Gestión de Departamentos
    // =============================
    private static void manageDepartments() {
        System.out.println("\n--- Gestión de Departamentos ---");
        System.out.println("1. Crear nuevo departamento");
        System.out.println("2. Listar departamentos");
        System.out.println("3. Eliminar departamento");
        System.out.println("4. Volver al menú principal");

        int option = getUserInputInt("Seleccione una opción: ");
        switch (option) {
            case 1 -> {
                String name = getUserInput("Nombre del departamento: ");
                Department dept = departmentService.addDepartment(name);
                System.out.println("Departamento creado: " + dept);
            }
            case 2 -> {
                List<Department> depts = departmentService.getAllDepartments();
                for (Department dept : depts) {
                    System.out.println(dept);
                }
            }
            case 3 -> {
                int id = getUserInputInt("ID del departamento a eliminar: ");
                boolean removed = departmentService.removeDepartment(id);
                System.out.println(removed ? "Departamento eliminado." : "No se pudo eliminar (puede tener empleados).");
            }
            case 4 -> {}
            default -> System.out.println("Opción inválida.");
        }
    }

    // =============================
    // Gestión de Reportes
    // =============================
    private static void manageReports() {
        System.out.println("\n--- Gestión de Reportes de Desempeño ---");
        System.out.println("1. Crear reporte");
        System.out.println("2. Ver todos los reportes");
        System.out.println("3. Ver reportes por empleado");
        System.out.println("4. Ver reportes por departamento");
        System.out.println("5. Volver al menú principal");

        int option = getUserInputInt("Seleccione una opción: ");
        switch (option) {
            case 1 -> createReport();
            case 2 -> {
                List<PerformanceReport> list = reportService.getAllReports();
                for (PerformanceReport r : list) System.out.println(r);
            }
            case 3 -> {
                int id = getUserInputInt("ID del empleado: ");
                Employee emp = employeeService.getEmployeeById(id);
                if (emp != null) {
                    List<PerformanceReport> reports = reportService.getReportsByEmployee(emp);
                    for (PerformanceReport r : reports) System.out.println(r);
                } else {
                    System.out.println("Empleado no encontrado.");
                }
            }
            case 4 -> {
                Department dept = selectDepartment();
                List<PerformanceReport> reports = reportService.getReportsByDepartment(dept);
                for (PerformanceReport r : reports) System.out.println(r);
            }
            case 5 -> {}
            default -> System.out.println("Opción inválida.");
        }
    }

    private static void createReport() {
        int id = getUserInputInt("ID del empleado: ");
        Employee emp = employeeService.getEmployeeById(id);
        if (emp == null) {
            System.out.println("Empleado no encontrado.");
            return;
        }
        String evaluator = getUserInput("Nombre del evaluador: ");
        double score = getUserInputDouble("Puntaje (0-10): ");
        String comments = getUserInput("Comentarios: ");
        PerformanceReport report = reportService.createReport(emp, evaluator, score, comments);
        System.out.println("Reporte creado: " + report);
    }

    // =============================
    // Métodos de utilidad
    // =============================
    private static Department selectDepartment() {
        List<Department> departments = departmentService.getAllDepartments();
        if (departments.isEmpty()) {
            System.out.println("No hay departamentos. Creando uno nuevo.");
            String name = getUserInput("Nombre del departamento: ");
            return departmentService.addDepartment(name);
        } else {
            System.out.println("Departamentos disponibles:");
            for (Department dept : departments) {
                System.out.println(dept.getId() + ". " + dept.getName());
            }
            int id = getUserInputInt("Seleccione ID del departamento: ");
            Department selected = departmentService.getDepartmentById(id);
            return selected != null ? selected : departments.get(0);
        }
    }

    private static String getUserInput(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    private static int getUserInputInt(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor ingrese un número.");
            scanner.next(); // limpia entrada incorrecta
            System.out.print(message);
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // limpia el salto de línea
        return input;
    }

    private static double getUserInputDouble(String message) {
        System.out.print(message);
        while (!scanner.hasNextDouble()) {
            System.out.println("Por favor ingrese un número válido.");
            scanner.next(); // limpia entrada incorrecta
            System.out.print(message);
        }
        double input = scanner.nextDouble();
        scanner.nextLine(); // limpia el salto de línea
        return input;
    }
}
