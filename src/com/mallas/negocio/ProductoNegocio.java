/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mallas.negocio;

import com.mallas.entidades.EntProductos;
import com.mallas.persistencia.DaosProductos;

/**
 *
 * @author samsung
 */
public class ProductoNegocio {
    
    DaosProductos daoP = new DaosProductos();
    EntProductos entP = new EntProductos();
    
    public boolean guardarProducto(EntProductos prod){
        
        boolean resp = false;
        
        String codigo_producto = prod.getCodigo_producto();
        String nombre = prod.getNombre();
        int precio = prod.getPrecio();
        int stock = prod.getStock();
        String descripcion = prod.getDescripcion();
        int cantidad = prod.getCantidad();
        
        entP = daoP.consultarProducto(codigo_producto);
        
        if(entP == null){
            resp = daoP.guardarProducto(codigo_producto, nombre, precio, stock, descripcion, cantidad);
        }
        
        return resp;                
    }
    
    public EntProductos consutlarProducto(String codigo_producto){
        return daoP.consultarProducto(codigo_producto);        
    }
    
    public boolean eliminarProducto(String codigo_producto){
        return daoP.eliminarProducto(codigo_producto);
    }
    
    public boolean actualizarProducto(EntProductos prod){
        
        boolean resp = false;
        
        String codigo_producto = prod.getCodigo_producto();
        String nombre = prod.getNombre();
        int precio = prod.getPrecio();
        int stock = prod.getStock();
        String descripcion = prod.getDescripcion();
        int cantidad = prod.getCantidad();
        
        entP = daoP.consultarProducto(codigo_producto);
        
        if(entP != null){
            resp = daoP.actualizarProducto(codigo_producto, nombre, precio, stock, descripcion, cantidad);
        }
        return resp;
    }
    
    public void imprimirLista(){
        daoP.imprimir();
    }
}
