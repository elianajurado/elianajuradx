/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.modelo;

import com.listaenlazada.modelop.Piloto;
/**
 *
 * @author elianajuradx
 */
public class NodopDE {
    private NodopDE siguiente;
    private NodopDE anterior;
    private Piloto dato;

    public Piloto getDato() {
        return dato;
    }

    public void setDato(Piloto dato) {
        this.dato = dato;
    }

    public NodopDE(Piloto dato) {
        this.dato = dato;
    }


    public NodopDE getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodopDE siguiente) {
        this.siguiente = siguiente;
    }

    public NodopDE getAnterior() {
        return anterior;
    }

    public void setAnterior(NodopDE anterior) {
        this.anterior = anterior;
    }
    
}
