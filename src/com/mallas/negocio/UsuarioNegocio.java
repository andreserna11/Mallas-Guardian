/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mallas.negocio;

import com.mallas.entidades.EntUsuario;
import com.mallas.persistencia.DaosUsuario;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samsung
 */
public class UsuarioNegocio{
 
    DaosUsuario daoU;
    EntUsuario entU = new EntUsuario();

    public UsuarioNegocio()  {
        try {
            this.daoU = new DaosUsuario();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public EntUsuario getUltimoNodo(){
        return daoU.getUltimoNodo();
    }
    
    public boolean guardarUsuario(EntUsuario user) throws Exception {
        
        boolean resp = false;
        
        String usuario = user.getUsuario();
        String clave = user.getClave();
        String rol = user.getRol();
        int DNI = user.getDNI();
        String nombre = user.getNombre();
        String apellido = user.getApellido();
        String correo = user.getCorreo();
        String estado = user.getEstado();       
        
        entU = daoU.consultarUsuario(DNI);
        
        if(entU == null){
            resp = daoU.guardarUsuario(usuario, clave, rol, DNI, nombre, apellido, correo, estado);
        }
        
        return resp;                
    }
    
    public EntUsuario consultarUsuarioEnt(int dni) { //Consultar usuarios existentes dentro del sistema
        return daoU.consultarUsuario(dni);
    }
       
    public boolean eliminarUsuarioEnt(int dni) throws Exception {
        return daoU.eliminarUsuario(dni);
    }
    
    public boolean actualizarUsuarioEnt(EntUsuario user) throws Exception {        
        boolean resp = false;
        
        String clave = user.getClave();
        String rol = user.getRol();               
        String correo = user.getCorreo();
        String estado = user.getEstado();
        int dni = user.getDNI();
        
        entU = daoU.consultarUsuario(dni);
        
        if (entU != null){
            resp = daoU.actualizarUsuario(dni, clave, estado, rol, correo);
        }        
        return resp;
    }
    
    public void imprimirLista(){
        daoU.imprimir();
    }
    
    public String verificarUsuario(String NombreUsuario, String clave) {

        entU = daoU.buscarUsuario(NombreUsuario);

        if (entU != null) {
            //Si Encuentra el usuario
            if (clave.equals(entU.getClave())) {
                //Verifico si la clave es correcta
                if (entU.getRol().equals("Administrador")) {
                    return "Administrador";
                } else {
                    return "Empleado";
                }
            } else {
                //lo encuentra pero la clave esta errada
                return "none";
            }
        } else {
            //No encuentra el usuario
            return "none";
        }
    }
    
    public EntUsuario getUsuario(String userName){
        return daoU.buscarUsuario(userName);
    }        
    
    public EntUsuario buscarCorreoEnt(String mail){
        return daoU.buscarCorreo(mail);
    }
    
    public EntUsuario configUser(){
        return daoU.configUser();
    }
      
}
