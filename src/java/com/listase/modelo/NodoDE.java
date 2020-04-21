/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.modelo;

/**
 *
 * @author elianajuradx
 */
public class NodoDE {
    private Infante dato;
    private Nodo siguiente;
    private Nodo anterior;

    public NodoDE(Infante dato) {
        this.dato = dato;
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

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
        
    
}
