/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.controlador;

import com.listase.modelo.Moto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elianajuradx
 */
public class ControladorMotos {
    private List<Moto> motos;

    public ControladorMotos() {
        //llenar las ciudades y los moto
        llenarMotos();
    }


    public List<Moto> getMoto() {
        return motos;
    }

    public void setDepartamentos(List<Moto> moto) {
        this.motos = motos;
    }
    
    
    private void llenarMotos()
    {
     motos=  new ArrayList<>();
     motos.add(new Moto("17", "HONDA RC213V"));
     motos.add(new Moto("66", "YAMAHA YZR-M1"));
     motos.add(new Moto("63", "DUCATI DESMOSEDICI GP18"));     
    }


    
    
    
    
}
