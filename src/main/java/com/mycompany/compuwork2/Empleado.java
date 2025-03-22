/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compuwork2;

/**
 *
 * @author USUARIO
 */

public class Empleado {
    private String nombre;
    private String id;
    private String tipo; // "Permanente" o "Temporal"
    
    public Empleado(String nombre, String id, String tipo) {
        this.nombre = nombre;
        this.id = id;
        setTipo(tipo); // Usar el setter para validar el tipo
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        if (!tipo.equals("Permanente") && !tipo.equals("Temporal")) {
            throw new IllegalArgumentException("Tipo de empleado debe ser 'Permanente' o 'Temporal'");
        }
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}