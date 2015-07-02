/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mallas.negocio;

import com.mallas.entidades.EntInsumo;
import com.mallas.persistencia.DaosInsumo;

/**
 *
 * @author samsung
 */
public class InsumosNegocio {
 
    DaosInsumo daoU = new DaosInsumo();
    EntInsumo entI = new EntInsumo();
    
    public boolean guardarInsumo(EntInsumo ins) {

        boolean resp = false;

        String codigo = ins.getCodigo();
        String nombre = ins.getNombre();
        int cantidad = ins.getCantidad();
        int precio = ins.getPrecio();
        String descripcion = ins.getDescripcion();

        entI = daoU.consultarInsumo(codigo);
   
        if (entI == null) {
            resp = daoU.guardarInsumo(codigo, nombre, cantidad, precio, descripcion);
        }

        return resp;

    }
    
    public EntInsumo consultarInsumoEnt(String codigo) { //Consultar usuarios existentes dentro del sistema
        return daoU.consultarInsumo(codigo);
    }
       
    public boolean eliminarInsumoEnt(String codigo) {
        return daoU.eliminarInsumo(codigo);
    }
    
    public boolean actualizarInsumoEnt(EntInsumo ins) {

        boolean resp = false;

        String codigo = ins.getCodigo();
        String nombre = ins.getNombre();
        int cantidad = ins.getCantidad();
        int precio = ins.getPrecio();
        String descripcion = ins.getDescripcion();
        
        entI = daoU.consultarInsumo(codigo);
        
        if (entI != null){
            resp = daoU.actualizarInsumo(ins);
        }
        
        return resp;
    }
    
    public void imprimirLista(){
        daoU.imprimir();
    }
      
}
