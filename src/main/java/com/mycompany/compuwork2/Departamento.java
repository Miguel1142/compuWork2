/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compuwork2;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author USUARIO
 */

public class Departamento {
    private String nombre;
    private List<Empleado> empleados;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarEmpleado(Empleado empleado) {
        if (empleado == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo");
        }
        empleados.add(empleado);
    }

    public void eliminarEmpleado(Empleado empleado) {
        if (empleado == null || !empleados.contains(empleado)) {
            throw new IllegalArgumentException("El empleado no existe en el departamento");
        }
        empleados.remove(empleado);
    }

    public List<Empleado> getEmpleados() {
        return new ArrayList<>(empleados); // Retornar una copia para evitar modificaciones externas
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "nombre='" + nombre + '\'' +
                ", empleados=" + empleados +
                '}';
    }
}



   

