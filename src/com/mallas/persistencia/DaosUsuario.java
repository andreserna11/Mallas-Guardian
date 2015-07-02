package com.mallas.persistencia;

import com.mallas.entidades.EntUsuario;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samsung
 */
public class DaosUsuario {

    int tamaño = 0; //Tamaño de la lista
    EntUsuario cabeza; //Apuntador al primer nodo de la lista
    EntUsuario empleado = new EntUsuario("laz", "lazarocarlos", "Empleado", 2, "Carlos", "Serna", "carlos_serna23151@elpoli.edu.co", "Activo");
    static EntUsuario icUser; //Variable para guardar el usuario de inicio de sesion
    
    
    public DaosUsuario() throws Exception {

        this.tamaño = 1;
        this.cabeza = new EntUsuario();
        cabeza.DNI = 1;
        cabeza.usuario = "dan";
        cabeza.clave = "1234567890";
        cabeza.nombre = "Daniel";
        cabeza.apellido = "Gallego";
        cabeza.rol = "Administrador";
        cabeza.estado = "Activo";
        cabeza.correo = "gallegodaniel9004@gmail.com";
        cabeza.next = empleado;        
    }

    public int getTamaño() {
        return tamaño;
    }

    public boolean guardarUsuario(String usuario, String clave, String rol, int DNI, String nombre, String apellido,
            String correo, String estado) {
        //Insertar al final
        EntUsuario N = new EntUsuario();
        EntUsuario Aux;

        N.usuario = usuario;
        N.clave = clave;
        N.rol = rol;
        N.DNI = DNI;
        N.nombre = nombre;
        N.apellido = apellido;
        N.correo = correo;
        N.estado = estado;

        if (cabeza == null) {
            cabeza = N;
        } else {
            Aux = getUltimoNodo();
            if (Aux != null) {
                Aux.next = N;
            }
        }
        tamaño++;
        return true;

    }

    public void imprimir() {
        EntUsuario aux;
        aux = cabeza;

        while (aux != null) {
            System.out.println(aux.usuario + "\n" + aux.clave + "\n" + aux.rol + "\n" + aux.DNI + "\n" + aux.nombre + "\n"
                    + aux.apellido + "\n" + aux.correo + "\n" + aux.estado);

            aux = aux.next;
        }

    }

    public EntUsuario getUltimoNodo() {
        //Buscar el ultimo nodo
        EntUsuario N, Ant;
        N = cabeza;
        Ant = null;

        while (N != null) {
            Ant = N;
            N = N.next;
        }
        return Ant;
    }

    public EntUsuario consultarUsuario(int dni) {

        int sw = 0;
        EntUsuario aux;
        aux = cabeza;

        if (cabeza == null) {
            return null;
        } else {
            while (aux != null && sw == 0) {
                if (aux.getDNI() == dni) {
                    sw = 1;                    
                } else {                    
                    aux = aux.next;
                }
            }
        }

        return aux;
    }

   //Busca la existencia de un usuario para inicio de sesion
    public EntUsuario buscarUsuario(String userName) {

        int sw = 0;
        EntUsuario aux;
        aux = cabeza;

        if (cabeza == null) {
            return null;
        } else {
            while (aux != null && sw == 0) {
                if (aux.getUsuario().equals(userName)) {
                    sw = 1;
                } else {
                    aux = aux.next;
                }
            }
        }
        
        icUser = aux;
        return icUser;
    }
    
    public EntUsuario configUser(){
        return icUser;
    }
    

    public boolean actualizarUsuario(int dni, String clave, String estado, String rol, String correo) {

        EntUsuario aux = cabeza;
        int sw = 0;

        while (aux != null && sw == 0) {
            if (aux.DNI == dni) {
                sw++;
                aux.clave = clave;
                aux.estado = estado;
                aux.rol = rol;
                aux.correo = correo;
            }
            aux = aux.next;
        }
      
        if (sw == 0) {
            return false;
        } else {
            return true;
        }


    }

    public boolean eliminarUsuario(int dni) {

        boolean resp = true;
        EntUsuario aux = null;

        if (cabeza.DNI == dni) {
            cabeza = cabeza.next;
            return resp;
        } else {
            try {
                aux = cabeza;
                while (aux != null) {
                    if (aux.next.DNI == dni) {
                        EntUsuario aux2 = aux.next;
                        aux.next = aux2.next;
                        return resp;
                    } else {
                        aux = aux.next;
                        resp = false;
                    }
                }
            } catch (Exception e) {
            }
        }        
        tamaño--;
        return resp;
    }

    public EntUsuario buscarCorreo(String mail) {

        int sw = 0;
        EntUsuario aux;
        aux = cabeza;

        if (cabeza == null) {
            return null;
        } else {
            while (aux != null && sw == 0) {
                if (aux.getCorreo().equals(mail)) {
                    sw = 1;
                } else {
                    aux = aux.next;
                }
            }
        }

        return aux;
    }
}
