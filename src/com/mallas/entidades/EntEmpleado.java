/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mallas.entidades;

/**
 *
 * @author JONATAN
 */
public class EntEmpleado {
    
    public String cedula;
    public String nombre;
    public String apellido;
    public String edad;
    public String telefono;
    public String direccion;
    public EntEmpleado next; //Apuntador
    
    public EntEmpleado(){
        EntEmpleado next = null;
        cedula = null;
        nombre = null;
        apellido = null;
        edad = null;
        telefono = null;
        direccion = null;    
        
    }
    
    public EntEmpleado(String cedula, String nombre, String apellido, 
        String edad, String telefono, String direccion) {
        
        this();
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
           
    } 

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public EntEmpleado getNext() {
        return next;
    }

    public void setNext(EntEmpleado next) {
        this.next = next;
    }
}
