/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mallas.persistencia;

import com.mallas.entidades.EntClientes;
import com.mallas.entidades.EntObras;

/**
 *
 * @author samsung
 */
public class DaosObras {

    int tamaño = 0;
    EntObras cabeza;
    EntClientes cliE = new EntClientes();
    String cliente;

    public DaosObras() {
        this.tamaño = 0;
        this.cabeza = null;
    }

    public int getTamaño() {
        return tamaño;
    }

    public boolean guardarObra(String referencia, String nombre, String nombre_cliente, String fecha_inicio, String fecha_final,
            String ciudad, String direccion, String estado) {

        EntObras N = new EntObras();
        EntObras aux = null;

        N.referencia = referencia;
        N.nombre = nombre;
        N.nombre_cliente = nombre_cliente;
        N.fecha_inicio = fecha_inicio;
        N.fecha_final = fecha_final;
        N.ciudad = ciudad;
        N.direccion = direccion;
        N.estado = estado;

        if (cabeza == null) {
            cabeza = N;
        } else {
            aux = getUltimoNodo();
            if (aux != null) {
                aux.next = N;
            }
        }
        tamaño++;
        return true;
    }

    private EntObras getUltimoNodo() {
        //Buscar el ultimo nodo
        EntObras N, Ant;
        N = cabeza;
        Ant = null;

        while (N != null) {
            Ant = N;
            N = N.next;
        }
        return Ant;
    }

    public void imprimir() {
        EntObras aux;
        aux = cabeza;

        while (aux != null) {
            System.out.println(aux.referencia + "\n" + aux.nombre + "\n" + aux.nombre_cliente + "\n" + aux.fecha_inicio + "\n" + aux.fecha_final + "\n"
                    + aux.ciudad + "\n" + aux.direccion + "\n" + aux.estado);
            aux = aux.next;
        }
    }

    public EntObras consultarObra(String referencia) {

        int sw = 0;
        EntObras aux;
        aux = cabeza;

        if (cabeza == null) {
            return null;
        } else {
            while (aux != null && sw == 0) {
                if (aux.getReferencia().equals(referencia)) {
                    sw = 1;
                } else {
                    aux = aux.next;
                }
            }
        }
        return aux;
    }

    public boolean actualizarObra(String referencia, String nombre, String nombre_cliente, String fecha_inicio,
            String fecha_final, String ciudad, String direccion, String estado) {

        EntObras aux = cabeza;
        int sw = 0;

        while (aux != null && sw == 0) {
            if (aux.referencia.equals(referencia)) {
                sw++;
                aux.nombre = nombre;
                aux.nombre_cliente = nombre_cliente;
                aux.fecha_inicio = fecha_inicio;
                aux.fecha_final = fecha_final;
                aux.ciudad = ciudad;
                aux.direccion = direccion;
                aux.estado = estado;

            }
            aux = aux.next;
        }

        if (sw == 0) {
            return false;
        } else {
            return true;
        }
    }
    
    public boolean eliminarObra(String referencia) {

        if (cabeza.referencia.equals(referencia)) {
            cabeza = cabeza.next;
            return true;
        } else {
            try {
                EntObras aux = cabeza;
                while (aux != null) {
                    if (aux.next.referencia.equals(referencia)) {
                        EntObras aux2 = aux.next;
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
    
    public void verificarCliente(){
        
        if(cliE == null){
           cliente = "Sin Cliente";           
        }else{
            while(cliE != null){
                cliente = cliE.getNIT();                
            }
        }
    }
}
