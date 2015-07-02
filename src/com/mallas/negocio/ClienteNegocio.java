/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mallas.negocio;

import com.mallas.entidades.EntClientes;
import com.mallas.persistencia.DaosClientes;
/**
 *
 * @author samsung
 */
public class ClienteNegocio {

    DaosClientes daoP = new DaosClientes();
    EntClientes provE = new EntClientes();

    public boolean guardarCliente(EntClientes cli) {

        boolean resp = false;

        String NIT = cli.getNIT();
        String razon_social = cli.getRazon_social();
        String direccion = cli.getDireccion();
        String telefono = cli.getTelefono();
        String representante_legal = cli.getRepresentante_legal();
        String regimen_tributario = cli.getRegimen_tributario();

        provE = daoP.consultarCliente(NIT);

        if (provE == null) {
            resp = daoP.guardarCliente(NIT, razon_social, direccion, telefono, representante_legal, regimen_tributario);
        }

        return resp;
    }

    public EntClientes consultarCliente(String NIT) {
        return daoP.consultarCliente(NIT);
    }

    public boolean eliminarCliente(String NIT) {
        return daoP.eliminarCliente(NIT);
    }

    public boolean actualizarCliente(EntClientes cli) {

        boolean resp = false;

        String NIT = cli.getNIT();
        String razon_social = cli.getRazon_social();
        String direccion = cli.getDireccion();
        String telefono = cli.getTelefono();
        String representante_legal = cli.getRepresentante_legal();
        String regimen_tributario = cli.getRegimen_tributario();

        provE = daoP.consultarCliente(NIT);

        if (provE != null) {
            resp = daoP.actualizarCliente(cli);
        }

        return resp;
    }
    
    public void imprimirLista(){
        daoP.imprimir();
    }
    
    public EntClientes traerCliente(){        
        return daoP.traerCliente();
    }
}
