/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.controlador;

import com.listase.modelo.Piloto;
import com.listase.modelo.ListaSE;
import com.listase.modelo.Nodo;
import com.listase.utilidades.JsfUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.DiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.connector.FlowChartConnector;
import org.primefaces.model.diagram.endpoint.BlankEndPoint;
import org.primefaces.model.diagram.endpoint.EndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;
import org.primefaces.model.diagram.overlay.ArrowOverlay;
import org.primefaces.model.diagram.overlay.LabelOverlay;

/**
 *
 * @author elianajuradx
 */
public class SesionPiloto implements Serializable{
    private ListaSE listaPilotos;
    private Piloto piloto;
    private String alInicio="1";
    private boolean deshabilitarFormulario=true;
    private Nodo ayudante;   
    private String textoVista="Gráfico";   
    private List listadoPilotos;    
    private DefaultDiagramModel model;    
    private short codigoEliminar;
    private ControladorLocalidades controlLocalidades= new ControladorLocalidades();
    private String codigoDeptoSel;
    private short pilotoSeleccionado;
    private Piloto PilotoDiagrama;

    public Piloto getPilotoDiagrama() {
        return PilotoDiagrama;
    }

    public void setPilotoDiagrama(Piloto PilotoDiagrama) {
        this.PilotoDiagrama = PilotoDiagrama;
    }

    public short getPilotoSeleccionado() {
        return pilotoSeleccionado;
    }

    public void setPilotoSeleccionado(short pilotoSeleccionado) {
        this.pilotoSeleccionado = pilotoSeleccionado;
    }

    public ControladorLocalidades getControlLocalidades() {
        return controlLocalidades;
    }

    public void setControlLocalidades(ControladorLocalidades controlLocalidades) {
        this.controlLocalidades = controlLocalidades;
    }
    

    public short getCodigoEliminar() {
        return codigoEliminar;
    }

    public void setCodigoEliminar(short codigoEliminar) {
        this.codigoEliminar = codigoEliminar;
    }
    
    /**
     * Creates a new instance of SesionPiloto
     */
    public SesionPiloto() {        
    }
    
    @PostConstruct
    private void inicializar()
    {
        controlLocalidades= new ControladorLocalidades();
        codigoDeptoSel = controlLocalidades.getDepartamentos().get(0).getCodigo();
        listaPilotos = new ListaSE();        
        //LLenado de la bds
        
    }
     
    public DiagramModel getModel() {
        return model;
    }
     
    private Connection createConnection(EndPoint from, EndPoint to, String label) {
        Connection conn = new Connection(from, to);
        conn.getOverlays().add(new ArrowOverlay(20, 20, 1, 1));
         
        if(label != null) {
            conn.getOverlays().add(new LabelOverlay(label, "flow-label", 0.5));
        }
         
        return conn;
    }

    public String getTextoVista() {
        return textoVista;
    }

    public void setTextoVista(String textoVista) {
        this.textoVista = textoVista;
    }

    public String getCodigoDeptoSel() {
        return codigoDeptoSel;
    }

    public void setCodigoDeptoSel(String codigoDeptoSel) {
        this.codigoDeptoSel = codigoDeptoSel;
    }

        
    public List getListadoPilotos() {
        return listadoPilotos;
    }

    public void setListadoPilotos(List listadoPilotos) {
        this.listadoPilotos = listadoPilotos;
    }
    
    

    public boolean isDeshabilitarFormulario() {
        return deshabilitarFormulario;
    }

    public void setDeshabilitarFormulario(boolean deshabilitarFormulario) {
        this.deshabilitarFormulario = deshabilitarFormulario;
    }

  
    
    

    public String getAlInicio() {
        return alInicio;
    }

    public void setAlInicio(String alInicio) {
        this.alInicio = alInicio;
    }
    
    public ListaSE getListaPilotos() {
        return listaPilotos;
    }

    public void setListaPilotos(ListaSE listaPilotos) {
        this.listaPilotos = listaPilotos;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }
    
    
    
}
