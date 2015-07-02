/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mallas.entidades;

/**
 *
 * @author samsung
 */
public class EntInsumo {
    public String codigo;
    public String nombre;
    public int cantidad;
    public int precio;
    public String descripcion;
    public EntInsumo next; //Apuntador
    
    public EntInsumo(){
        EntInsumo next = null;
        codigo = null;
        nombre = null;
        descripcion = null;
        cantidad = 0;
        precio = 0;

    }
    
    public EntInsumo(String codigo, String nombre, int cantidad,
            int precio, String descripcion, EntInsumo next){
        
        this();
        this.codigo=codigo;
        this.nombre=nombre;
        this.cantidad=cantidad;
        this.precio=precio;
        this.descripcion=descripcion;
        
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EntInsumo getNext() {
        return next;
    }

    public void setNext(EntInsumo next) {
        this.next = next;
    }   
}