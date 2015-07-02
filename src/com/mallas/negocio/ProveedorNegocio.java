/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mallas.negocio;

import com.mallas.entidades.EntProveedores;
import com.mallas.persistencia.DaosProveedores;

/**
 *
 * @author samsung
 */
public class ProveedorNegocio {

    DaosProveedores daoP = new DaosProveedores();
    EntProveedores provE = new EntProveedores();

    public boolean guardarProveedor(EntProveedores prov) {

        boolean resp = false;

        String NIT = prov.getNIT();
        String razon_social = prov.getRazon_social();
        String direccion = prov.getDireccion();
        String telefono = prov.getTelefono();
        String representante_legal = prov.getRepresentante_legal();
        String regimen_tributario = prov.getRegimen_tributario();

        provE = daoP.consultarProveedor(NIT);

        if (provE == null) {
            resp = daoP.guardarUsuario(NIT, razon_social, direccion, telefono, representante_legal, regimen_tributario);
        }

        return resp;
    }

    public EntProveedores consultarProveedor(String NIT) {
        return daoP.consultarProveedor(NIT);
    }

    public boolean eliminarProveedor(String NIT) {
        return daoP.eliminarProveedor(NIT);
    }

    public boolean actualizarProveedor(EntProveedores prov) {

        boolean resp = false;

        String NIT = prov.getNIT();
        String razon_social = prov.getRazon_social();
        String direccion = prov.getDireccion();
        String telefono = prov.getTelefono();
        String representante_legal = prov.getRepresentante_legal();
        String regimen_tributario = prov.getRegimen_tributario();

        provE = daoP.consultarProveedor(NIT);

        if (provE != null) {
            resp = daoP.actualizarProveedor(prov);
        }

        return resp;
    }
    
    public void imprimirLista(){
        daoP.imprimir();
    }
}
