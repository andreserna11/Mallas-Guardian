/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mallas.negocio;

import com.mallas.entidades.EntEmpleado;
import com.mallas.persistencia.DaosEmpleado;
/**
 *
 * @author JONATAN
 */
public class EmpleadosNegocio {

    DaosEmpleado daoU = new DaosEmpleado();
    EntEmpleado entU = new EntEmpleado();
    
    public boolean guardarEmpleado(EntEmpleado emp) {
        
        boolean resp = false;
        
        String cedula = emp.getCedula();
        String nombre = emp.getNombre();
        String apellido = emp.getApellido();
        String edad = emp.getEdad();
        String telefono = emp.getTelefono();
        String direccion = emp.getDireccion();     
        
        entU = daoU.consultarEmpleado(cedula);         
   
        if (entU == null) {
            resp = daoU.guardarEmpleado(cedula, nombre, apellido, edad, telefono, direccion);
        }
        
        return resp;

    }
    
    public EntEmpleado consulEntEmpleado(String cedula) {
        return daoU.consultarEmpleado(cedula);
    }
           
    public boolean eliminarEmpleadoEnt(String cedula) {
        return daoU.eliminarEmpleado(cedula);
    }
    
    public boolean actualizarEmpleadoEnt(EntEmpleado emp) {
        
        boolean resp = false;
        
        String cedula = emp.getCedula();
        String edad = emp.getEdad();
        String telefono = emp.getTelefono();
        String direccion = emp.getDireccion();
        
        entU = daoU.consultarEmpleado(cedula);
        
        if (entU != null){
            resp = daoU.actualizarEmpleado(emp);
        }
        
        return resp;
    }
    
    public void imprimirLista(){
        daoU.imprimir();
    }
}
