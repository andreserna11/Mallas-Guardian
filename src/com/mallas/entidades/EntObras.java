/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mallas.entidades;

/**
 *
 * @author samsung
 */
public class EntObras {

    public String referencia;
    public String nombre;
    public String nombre_cliente;
    public String fecha_inicio;
    public String fecha_final;
    public String ciudad;
    public String direccion;
    public String estado;
    public EntObras next;

    public EntObras() {
        referencia = null;
        nombre = null;
        nombre_cliente = null;
        fecha_inicio = null;
        fecha_final = null;
        ciudad = null;
        direccion = null;
        estado = null;
        next = null;
    }

    public EntObras(String referencia, String nombre, String nombre_cliente, String fecha_inicio, String fecha_final,
            String ciudad, String direccion, String estado) {
        this();
        this.referencia = referencia;
        this.nombre = nombre;
        this.nombre_cliente = nombre_cliente;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.estado = estado;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EntObras getNext() {
        return next;
    }

    public void setNext(EntObras next) {
        this.next = next;
    }
}
