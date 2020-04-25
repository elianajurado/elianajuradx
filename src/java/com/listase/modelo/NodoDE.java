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
    private NodoDE siguiente;
    private NodoDE anterior;
    private Piloto referencia;

    public Piloto getReferencia() {
        return referencia;
    }

    public void setReferencia(Piloto referencia) {
        this.referencia = referencia;
    }

    public NodoDE(Piloto referencia) {
        this.referencia = referencia;
    }

    public NodoDE(Infante dato) {
        this.dato = dato;
    }

    public Infante getDato() {
        return dato;
    }

    public void setDato(Infante dato) {
        this.dato = dato;
    }

    public NodoDE getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDE siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDE getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDE anterior) {
        this.anterior = anterior;
    }
        
    
}
