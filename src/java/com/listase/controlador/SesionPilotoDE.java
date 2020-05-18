/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.controlador;

import com.listase.excepciones.PilotoExcepcion;
import com.listase.modelo.Piloto;
import com.listase.modelo.ListaDE;
import com.listase.modelo.NodoDE;
import com.listase.utilidades.JsfUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
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
@Named(value = "sesionPiloto")
@SessionScoped
public class SesionPilotoDE implements Serializable {

    private ListaDE listaPilotos;
    private Piloto piloto;
    private String alInicio="1";
    private boolean deshabilitarFormulario=true;
    private NodoDE ayudante;   
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
     * Creates a new instance of SesionPilotoDE
     */
    public SesionPilotoDE() {        
    }
    
    @PostConstruct
    private void inicializar()
    {
        controlLocalidades= new ControladorLocalidades();
        codigoDeptoSel = controlLocalidades.getDepartamentos().get(0).getCodigo();
        listaPilotos = new ListaDE();        
        //LLenado de la bds
        ayudante = listaPilotos.getCabeza();
        piloto = ayudante.getReferencia();     
        //Me llena el objeto List para la tabla
        pintarLista();       
        
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
    
    public ListaDE getListaPilotos() {
        return listaPilotos;
    }

    public void setListaPilotos(ListaDE listaPilotos) {
        this.listaPilotos = listaPilotos;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }
    
    
    
  
    
    public void habilitarFormulario()
    {
        deshabilitarFormulario=false;
        piloto = new Piloto();
    }
    
    public void irSiguiente()
    {
        if(ayudante.getSiguiente()!=null)
        {
            ayudante = ayudante.getSiguiente();
            piloto = ayudante.getReferencia();
        }        
    }
    
    public void irAnterior()
    {
        if(ayudante.getAnterior()!=null)
        {
            ayudante = ayudante.getAnterior();
            piloto = ayudante.getReferencia();
        }        
    }
    
    public void irPrimero()
    {
        if(listaPilotos.getCabeza()!=null)
        {
            ayudante = listaPilotos.getCabeza();
            piloto = ayudante.getReferencia();
        }
        else
        {
            piloto = new Piloto();
        }
        pintarLista();
    }
    
    public void irUltimo()
    {
        if(listaPilotos.getCabeza()!=null)
        {            
            while(ayudante.getSiguiente()!=null)
            {
                ayudante = ayudante.getSiguiente();
            }
            piloto=ayudante.getReferencia();
        }
    }
    
    public void cambiarVistaPilotos()
    {
        if(textoVista.compareTo("Tabla")==0)
        {
            textoVista = "Gráfico";
        }
        else
        {
            textoVista = "Tabla";
        }
    }
    
    public void invertirLista()
    {
        listaPilotos.invertirLista();
        irPrimero();
    }
    
    public void pintarLista()
    {
        //Instancia el modelo
        model = new DefaultDiagramModel();
        //Pude tener n flechas
        model.setMaxConnections(-1);
         
        FlowChartConnector connector = new FlowChartConnector();
        connector.setPaintStyle("{strokeStyle:'#C7B097',lineWidth:3}");
        model.setDefaultConnector(connector);
         
        //adicionar los elementos
        if(listaPilotos.getCabeza() !=null)
        {
            NodoDE temp= listaPilotos.getCabeza();
            int posX=2;
            int posY=2;
            while(temp !=null)
            {
                Element ele = new Element(temp.getReferencia().getNombre(), posX+"em", posY+"em");
                ele.setId(String.valueOf(temp.getReferencia().getCodigo()));
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.TOP));
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM_RIGHT));
                
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM_LEFT));
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM_RIGHT));
                model.addElement(ele);
                temp= temp.getSiguiente();
                posX= posX+5;
                posY= posX+6;
            }
            for(int i=0; i < model.getElements().size() -1; i++)
            {
                model.connect(createConnection(model.getElements().get(i).getEndPoints().get(1), model.getElements().get(i+1).getEndPoints().get(0), "Siguiente"));
                model.connect(createConnection(model.getElements().get(i).getEndPoints().get(1), model.getElements().get(i+1).getEndPoints().get(3), "Anterior"));
                
            }
        }
    }
    
    public void onClickRight() {
        String id = FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get("elementId");
         //Linea nueva
        pilotoSeleccionado = Short.valueOf(id.replaceAll("frmPiloto:diagrama-", ""));
        System.out.println(pilotoSeleccionado);
    }
    
    public void obtenerPilotoDiagrama()
    {
       
    }
 
    
}
