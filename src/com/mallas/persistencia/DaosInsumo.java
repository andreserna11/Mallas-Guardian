package com.mallas.persistencia;

import com.mallas.entidades.EntInsumo;

/**
 *
 * @author samsung
 */
public class DaosInsumo {

    int tamaño = 0; //Tamaño de la lista
    EntInsumo cabeza; //Apuntador al primer nodo de la lista

    public DaosInsumo() {
        this.tamaño = 0;
        this.cabeza = null;
    }

    public int getTamaño() {
        return tamaño;
    }

    public boolean guardarInsumo(String codigo, String nombre, int cantidad,
        int precio, String descripcion) {
        //Insertar al final
        EntInsumo N = new EntInsumo();
        EntInsumo Aux;

        N.codigo = codigo;
        N.nombre = nombre;
        N.cantidad = cantidad;
        N.precio = precio;
        N.descripcion = descripcion;

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
        EntInsumo aux;
        aux = cabeza;

        while (aux != null) {
            System.out.println(aux.codigo + "\n" + aux.nombre + "\n" + aux.cantidad + "\n" + aux.precio + "\n" + aux.descripcion);
            aux = aux.next;
        }
    }

    private EntInsumo getUltimoNodo() {
        //Buscar el ultimo nodo
        EntInsumo N, Ant;
        N = cabeza;
        Ant = null;

        while (N != null) {
            Ant = N;
            N = N.next;
        }
        return Ant;
    }

    public EntInsumo consultarInsumo(String codigo) {

        int sw = 0;
        EntInsumo aux;
        aux = cabeza;

        if (cabeza == null) {
            return null;
        } else {
            while (aux != null && sw == 0) {
                if (aux.codigo.equals(codigo)) {
                    sw = 1;
                } else {
                    aux = aux.next;
                }
            }
        }
        return aux;
    }

    public boolean actualizarInsumo(EntInsumo ins) {

        EntInsumo aux = cabeza;
        int sw = 0;

        while (aux != null && sw == 0) {
            if (aux.codigo.equals(ins.codigo)) {
                sw++;
                aux.nombre = ins.nombre;
                aux.cantidad = ins.cantidad;
                aux.precio = ins.precio;
                aux.descripcion = ins.descripcion;
            }
            aux = aux.next;
        }

        if (sw == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean eliminarInsumo(String codigo) {

        if (cabeza.codigo.equals(codigo)) {
            cabeza = cabeza.next;
            return true;
        } else {
            try {
                EntInsumo aux = cabeza;
                while (aux != null) {
                    if (aux.next.codigo.equals(codigo)) {
                        EntInsumo aux2 = aux.next;
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
