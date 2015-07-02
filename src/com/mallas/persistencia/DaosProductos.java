/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mallas.persistencia;

import com.mallas.entidades.EntProductos;

/**
 *
 * @author samsung
 */
public class DaosProductos {
 
    int tamaño = 0;
    EntProductos cabeza;
    
    public DaosProductos(){
        this.tamaño = 0;
        this.cabeza = null;
    }
    
    public int getTamaño(){
        return tamaño;
    }
    
    public boolean guardarProducto(String codigo_producto, String nombre, int precio, int stock,
            String descripcion, int cantidad){
        
        EntProductos N = new EntProductos();
        EntProductos aux;
        
        N.codigo_producto = codigo_producto;
        N.nombre = nombre;
        N.precio = precio;
        N.stock = stock;
        N.descripcion = descripcion;
        N.cantidad = cantidad;
        
        if(cabeza == null){
            cabeza = N;            
        }else{
            aux = getUltimoNodo();
            if(aux != null){
                aux.next = N;
            }
        }        
        tamaño++;
        return true;
    }
    
    public void imprimir(){
        EntProductos aux;
        aux = cabeza;
        
        while(aux != null){
            System.out.println(aux.codigo_producto + "\n" + aux.nombre + "\n" + aux.precio + "\n" + aux.stock + "\n" + aux.nombre + "\n"
                    + aux.descripcion + "\n" + aux.cantidad);
            aux = aux.next;
        }
    }
    
    private EntProductos getUltimoNodo(){
        
        EntProductos N, Ant;        
        N = cabeza;
        Ant = null;
        
        while(N != null){
            Ant = N;
            N = N.next;
        }
        return Ant;
    }
    
    public EntProductos consultarProducto(String codigo_producto){
        
        int sw = 0;
        EntProductos aux;
        aux = cabeza;
        
        if(cabeza == null){
            return null;
        }else{
            while(aux != null && sw == 0){
                if(aux.getCodigo_producto().equals(codigo_producto)){
                    sw = 1;
                }else{
                    aux = aux.next;
                }
            }
        }
        return aux;
    }
    
    public boolean actualizarProducto(String codigo_producto, String nombre, int precio, int stock,
            String descripcion, int cantidad){
        
        EntProductos aux = cabeza;
        int sw = 0;
        
        while(aux != null && sw == 0){
            if(aux.codigo_producto.equals(codigo_producto)){
                sw++;
                aux.nombre = nombre;
                aux.precio = precio;
                aux.stock = stock;
                aux.descripcion = descripcion;
                aux.cantidad = cantidad;
            }
            aux = aux.next;
        }
        
        if(sw == 0){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean eliminarProducto(String codigo_producto){
        
        if(cabeza.codigo_producto.equals(codigo_producto)){
            cabeza = cabeza.next;
            return true;
        }else{
            try{
                EntProductos aux = cabeza;
                while(aux != null){
                    if(aux.next.codigo_producto.equals(codigo_producto)){
                        EntProductos aux2 = aux.next;
                        aux.next = aux2.next;
                    }
                    aux = aux.next;
                }
            }catch (Exception e){
                
            }
        }
        tamaño--;
        return false;
    }
}
