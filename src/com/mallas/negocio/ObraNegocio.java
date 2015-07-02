/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mallas.negocio;

import com.mallas.entidades.EntObras;
import com.mallas.persistencia.DaosObras;

/**
 *
 * @author samsung
 */
public class ObraNegocio {

    DaosObras daoO = new DaosObras();
    EntObras entO = new EntObras();

    public boolean guardarObraEnt(EntObras obra) {

        boolean resp = false;

        String referencia = obra.getReferencia();
        String nombre = obra.getNombre();
        String nombre_cliente = obra.getNombre_cliente();
        String fecha_inicio = obra.getFecha_inicio();
        String fecha_final = obra.getFecha_final();
        String direccion = obra.getDireccion();
        String ciudad = obra.getCiudad();
        String estado = obra.getEstado();

        entO = daoO.consultarObra(referencia);

        if (entO == null) {
            resp = daoO.guardarObra(referencia, nombre, nombre_cliente, fecha_inicio, fecha_final, ciudad, direccion, estado);
        }

        return resp;
    }

    public EntObras consultarObraEnt(String referencia) {
        return daoO.consultarObra(referencia);
    }

    public boolean eliminarObraEnt(String referencia) {
        return daoO.eliminarObra(referencia);
    }

    public boolean actualizarObraEnt(EntObras obra) {

        boolean resp = false;

        String referencia = obra.getReferencia();
        String nombre = obra.getNombre();
        String nombre_cliente = obra.getNombre_cliente();
        String fecha_inicio = obra.getFecha_inicio();
        String fecha_final = obra.getFecha_final();
        String ciudad = obra.getCiudad();
        String direccion = obra.getDireccion();
        String estado = obra.getEstado();

        entO = daoO.consultarObra(referencia);

        if (entO != null) {
            resp = daoO.actualizarObra(referencia, nombre, nombre_cliente, fecha_inicio, fecha_final, ciudad, direccion, estado);
        }
        return resp;
    }
    
    public void imprimirLista(){
        daoO.imprimir();
    }
    
    public void verificarCliente(){
        daoO.verificarCliente();
    }
}
