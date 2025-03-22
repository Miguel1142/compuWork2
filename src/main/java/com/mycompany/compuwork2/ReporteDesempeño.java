/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compuwork2;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author USUARIO
 */
public class ReporteDesempeño {
    private Map<Empleado, Integer> desempeño; // Empleado y su puntaje de desempeño

    public ReporteDesempeño() {
        desempeño = new HashMap<>();
    }

    public void agregarDesempeño(Empleado empleado, int puntaje) {
        if (empleado == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo");
        }
        if (puntaje < 0 || puntaje > 100) {
            throw new IllegalArgumentException("El puntaje debe estar entre 0 y 100");
        }
        desempeño.put(empleado, puntaje);
    }

    public void generarReporte() {
        System.out.println("Reporte de Desempeño:");
        for (Map.Entry<Empleado, Integer> entry : desempeño.entrySet()) {
            System.out.println(entry.getKey().getNombre() + ": " + entry.getValue());
        }
    }
}

