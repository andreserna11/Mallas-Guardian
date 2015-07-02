package com.mallas.entidades;

import java.io.Serializable;

/**
 *
 * @author samsung
 */
public class EntUsuario implements Serializable{

    public String usuario;
    public String clave;
    public String rol;
    public int DNI;
    public String nombre;
    public String apellido;
    public String correo;
    public String estado;
    public EntUsuario next; //Apuntador
   
    public EntUsuario(){
        next = null;
        usuario = null;
        clave = null;
        rol = null;
        DNI = 0;
        nombre = null;
        apellido = null;
        correo = null;
        estado = null;
    }   
    
    public EntUsuario(String usuario, String clave, String rol, int DNI, String nombre, String apellido, 
        String correo, String estado) {
        
        this();
        this.usuario = usuario;
        this.clave = clave;
        this.rol = rol;
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.estado = estado;
           
    }   
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EntUsuario getNext() {
        return next;
    }

    public void setNext(EntUsuario next) {
        this.next = next;
    }
    
    
}
