/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listacircular.modelo;

/**
 *
 * @author elianajuradx
 */
public class Pirinola {
    private String nombre;
    private int caras;
   

    public Pirinola(String nombre, int caras) {
        this.caras = caras;
        this.nombre = nombre;
    }

    public Pirinola() {
    }

    
    
    public int getCaras() {
        return caras;
    }

    public void setCaras(int caras) {
        this.caras = caras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
