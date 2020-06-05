/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listacircular.modelo;

import com.listase.excepciones.PirinolaExcepcion;
import java.io.Serializable;

/**
 *
 * @author elianajuradx
 */
public class ListaCircularPirinolaDE implements Serializable {

    private NodoPirinolaDE cabeza;

    public NodoPirinolaDE getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoPirinolaDE cabeza) {
        this.cabeza = cabeza;
    }

    public void adicionarNodo(Pirinola pirinola) {
        if (cabeza == null) {
            cabeza = new NodoPirinolaDE(pirinola);
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);

        } else {
            NodoPirinolaDE temp = cabeza.getAnterior();
            NodoPirinolaDE nodoInsertar = new NodoPirinolaDE(pirinola);
            temp.setSiguiente(nodoInsertar);
            nodoInsertar.setAnterior(temp);
            nodoInsertar.setSiguiente(cabeza);
            cabeza.setAnterior(nodoInsertar);
        }
    }

    public void adicionarNodoAlInicio(Pirinola pirinola) {
        if (cabeza == null) {
            cabeza = new NodoPirinolaDE(pirinola);
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
        } else {
            NodoPirinolaDE temp = cabeza.getAnterior();
            NodoPirinolaDE nodoInsertar = new NodoPirinolaDE(pirinola);
            temp.setSiguiente(nodoInsertar);
            nodoInsertar.setAnterior(temp);
            nodoInsertar.setSiguiente(cabeza);
            cabeza.setAnterior(nodoInsertar);
            cabeza = cabeza.getAnterior();
        }
    }

    public short contarNodos() {
        if (cabeza == null) {
            return 0;
        } else {
            NodoPirinolaDE temp = cabeza;
            short cont = 1;
            while (temp.getSiguiente() != cabeza) {
                temp = temp.getSiguiente();
                cont++;
            }
            return cont;
        }
    }

    public String listarPirinolas(String listado) throws PirinolaExcepcion {
        if (cabeza != null) {
            NodoPirinolaDE temp = cabeza;
            do {
                listado += temp.getDato() + "\n";
                temp = temp.getSiguiente();
            } while (temp != cabeza);

            return listado;
        }
        throw new PirinolaExcepcion(("No existen pirinolas en la lista"));
    }
}
