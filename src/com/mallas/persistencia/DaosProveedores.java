/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mallas.persistencia;

import com.mallas.entidades.EntProveedores;

/**
 *
 * @author samsung
 */
public class DaosProveedores {
    
    int tamaño = 0;
    EntProveedores cabeza;
    
    public DaosProveedores(){
        this.tamaño = 0;
        this.cabeza = null;
    }
    
    public int getTamaño(){
        return tamaño;
    }
    
    public boolean guardarUsuario(String NIT, String razon_social, String direccion, String telefono, String representante_legal,
            String regimen_tributario) {
        //Insertar al final
        EntProveedores N = new EntProveedores();
        EntProveedores Aux;

        N.NIT = NIT;
        N.razon_social = razon_social;
        N.direccion = direccion;
        N.telefono = telefono;
        N.representante_legal = representante_legal;
        N.regimen_tributario = regimen_tributario;

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
    
    private EntProveedores getUltimoNodo() {
        //Buscar el ultimo nodo
        EntProveedores N, Ant;
        N = cabeza;
        Ant = null;

        while (N != null) {
            Ant = N;
            N = N.next;
        }
        return Ant;
    }
    
    public void imprimir() {
        EntProveedores aux;
        aux = cabeza;

        while (aux != null) {
            System.out.println(aux.NIT + "\n" + aux.razon_social + "\n" + aux.direccion + "\n" + aux.telefono + "\n" + aux.representante_legal + "\n"
                    + aux.regimen_tributario);
            aux = aux.next;
        }
    }
    
    public EntProveedores consultarProveedor(String NIT) {

        int sw = 0;
        EntProveedores aux;
        aux = cabeza;

        if (cabeza == null) {
            return null;
        } else {
            while (aux != null && sw == 0) {
                if(aux.getNIT().equals(NIT)){
                    sw=1;
                }else{
                    aux = aux.next;
                }
            }
        }
        return aux;
    }
     
    public boolean actualizarProveedor(EntProveedores prov) {

        EntProveedores aux = cabeza;
        int sw = 0;

        while (aux != null && sw == 0) {
            if (aux.NIT.equals(prov.NIT)) {
                sw++;
                aux.razon_social = prov.getRazon_social();
                aux.direccion = prov.getDireccion();
                aux.telefono = prov.getTelefono();
                aux.representante_legal = prov.getRepresentante_legal();
                aux.regimen_tributario = prov.getRegimen_tributario();
            }
            aux = aux.next;
        }

        if (sw == 0) {
            return false;
        } else {
            return true;
        }
    }
    
    public boolean eliminarProveedor(String NIT) {

        if (cabeza.NIT.equals(NIT)) {
            cabeza = cabeza.next;
            return true;
        } else {
            try {
                EntProveedores aux = cabeza;
                while (aux != null) {
                    if (aux.next.NIT.equals(NIT)) {
                        EntProveedores aux2 = aux.next;
                        aux.next = aux2.next;
                    }
                    aux = aux.next;
                }
            } catch (Exception e) {
            }
        }
        tamaño--;
        return false;
    }
}
