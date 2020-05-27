/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.controlador;

import com.listacircularde.modelo.ListaCircularDE;
import com.listaenlazada.controlador.InfanteFacade;
import com.listaenlazada.controlador.util.JsfUtil;
import com.listasenlazada.modelo.Infante;
import com.listase.modelo.NodoDE;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author elianajuradx
 */
@Named(value = "appBean")
@ApplicationScoped
public class AppBean {
    
    private String correoTurno="elianajurado0825@gmail.com";    
    private int cont=0;   
    
    private List<Infante> listadoInfantes;
    @EJB
    private InfanteFacade connInfante;
    
    private Infante infanteSeleccionado;
    
    private ListaCircularDE listaCircularInfantes;
    
    private NodoDE ayudante;
    
    private boolean verInicio=true;
    
    /**
     * Creates a new instance of AppBean
     */
    public AppBean() {
    }
    
    @PostConstruct
    public void inicializar()
    {
        listadoInfantes = connInfante.findAll();
        listaCircularInfantes = new ListaCircularDE();
        for(Infante inf:listadoInfantes)
        {
            listaCircularInfantes.adicionarNodo(inf);
        }
        
        ayudante = listaCircularInfantes.getCabeza();
        infanteSeleccionado = new Infante();
        //infanteSeleccionado = ayudante.getDato();               
        
    }

    public boolean isVerInicio() {
        return verInicio;
    }

    public void setVerInicio(boolean verInicio) {
        this.verInicio = verInicio;
    }
    
    

    public Infante getInfanteSeleccionado() {
        return infanteSeleccionado;
    }

    public void setInfanteSeleccionado(Infante infanteSeleccionado) {
        this.infanteSeleccionado = infanteSeleccionado;
    }

    public ListaCircularDE getListaCircularInfantes() {
        return listaCircularInfantes;
    }

    public void setListaCircularInfantes(ListaCircularDE listaCircularInfantes) {
        this.listaCircularInfantes = listaCircularInfantes;
    }
    
    

    public List<Infante> getListadoInfantes() {
        return listadoInfantes;
    }

    public void setListadoInfantes(List<Infante> listadoInfantes) {
        this.listadoInfantes = listadoInfantes;
    }

    
    
    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public String getCorreoTurno() {
        return correoTurno;
    }

    public void setCorreoTurno(String correoTurno) {
        this.correoTurno = correoTurno;
    }
    
    
    
    
    public void aumentarContador(String correo)
    {
        switch(correo)
        {
            case "elianajurado0825@gmail.com":
                correoTurno= "ejurado69896@umanizales.edu.co";
                break;
            default:
                correoTurno= "elianajurado0825@gmail.com";
        }
        
        cont++;
    }
    
    public boolean validarTurno(String correo)
    {
        if(correo.equals(correoTurno))
        {
            return true;
        }
        return false;
    }
    
    
    public void pasarTingo()
    {        
       if(!verInicio)
       {
            ayudante = ayudante.getSiguiente();
            infanteSeleccionado = ayudante.getDato();
       }
       
    }
    
    public void controlarCiclo()
    {
        //False fue por que va a parar
        if(!verInicio)
        {
            //Eliminaría el niño . Valido lo seleccionado
            for(Infante inf: listadoInfantes)
            {
                if(inf.getCodigo() == infanteSeleccionado.getCodigo())
                {
                    listadoInfantes.remove(inf);
                    break;
                }
            }    
            
            if(listadoInfantes.size()==1)
            {
                JsfUtil.addSuccessMessage("Ha ganado "+listadoInfantes.get(0));
            }
            
        }    
        verInicio = !verInicio;
    }
    
    
}
