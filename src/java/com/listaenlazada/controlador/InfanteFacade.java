/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listaenlazada.controlador;

import com.listasenlazada.modelo.Infante;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author elianajuradx
 */
@Stateless
public class InfanteFacade extends AbstractFacade<Infante> {

    @PersistenceContext(unitName = "MotogpgamePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InfanteFacade() {
        super(Infante.class);
    }
    
}
