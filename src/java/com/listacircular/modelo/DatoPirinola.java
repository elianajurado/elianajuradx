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
public class DatoPirinola {
    private String texto;
    private int numero; 
    private boolean Ganar=true;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isGanar() {
        return Ganar;
    }

    public void setGanar(boolean Ganar) {
        this.Ganar = Ganar;
    }
    
    
    
}
