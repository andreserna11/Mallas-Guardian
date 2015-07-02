/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mallas.entidades;

/**
 *
 * @author samsung
 */
public class EntProductos {

    public String codigo_producto;
    public String nombre;
    public int precio;
    public int stock;
    public String descripcion;
    public int cantidad;
    public EntProductos next;

    public EntProductos() {
        codigo_producto = null;
        nombre = null;
        precio = 0;
        stock = 0;
        descripcion = null;
        cantidad = 0;
        next = null;
    }
    
    public EntProductos(String codigo_producto, String nombre, int precio, int stock, String descripcion,
            int cantidad){
        this();
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
        this.cantidad = cantidad;        
    }

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public EntProductos getNext() {
        return next;
    }

    public void setNext(EntProductos next) {
        this.next = next;
    }
    
    
}
