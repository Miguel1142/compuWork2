/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.compuwork2;

/**
 *
 * @author USUARIO
 */
public class CompuWork2 {

    public static void main(String[] args) {
        try {
            // Crear empleados
            Empleado emp1 = new Empleado("Juan Pérez", "001", "Permanente");
            Empleado emp2 = new Empleado("Ana Gómez", "002", "Temporal");
            Empleado emp3 = new Empleado("Miguel Oyola", "003", "Permanente");

            // Crear departamento
            Departamento depto = new Departamento("Recursos Humanos");
            depto.agregarEmpleado(emp1);
            depto.agregarEmpleado(emp2);
            depto.agregarEmpleado(emp3);

            // Generar reporte de desempeño
            ReporteDesempeño reporte = new ReporteDesempeño();
            reporte.agregarDesempeño(emp1, 85);
            reporte.agregarDesempeño(emp2, 90);
            reporte.agregarDesempeño(emp3, 75);
            
            // Mostrar información
            System.out.println(depto);
            reporte.generarReporte();
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

