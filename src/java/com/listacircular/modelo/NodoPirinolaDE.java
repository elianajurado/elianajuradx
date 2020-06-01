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
public class NodoPirinolaDE {
    private Pirinola dato;
    private NodoPirinolaDE siguiente;
    private NodoPirinolaDE anterior;

    public NodoPirinolaDE(Pirinola dato) {
        this.dato = dato;
    }

    public Pirinola getDato() {
        return dato;
    }

    public void setDato(Pirinola dato) {
        this.dato = dato;
    }

    public NodoPirinolaDE getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPirinolaDE siguiente) {
        this.siguiente = siguiente;
    }

    public NodoPirinolaDE getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoPirinolaDE anterior) {
        this.anterior = anterior;
    }
    
    
    
}
