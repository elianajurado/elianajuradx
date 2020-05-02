/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.modelo;

import java.io.Serializable;

/**
 *
 * @author carloaiza
 */
public class Nodo implements Serializable{
    private Infante dato;
    private Nodo siguiente;
    private Piloto referencia;
    
    public Nodo(Infante dato) {
        this.dato = dato;
    }
    
    public Piloto getReferencia() {
    return referencia;
    }

    public void setDato(Piloto referencia) {
        this.referencia = referencia;
    }   

    public Infante getDato() {
        return dato;
    }

    public void setDato(Infante dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
