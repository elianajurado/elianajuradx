/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.controlador;

import com.listaenlazada.controladorp.PilotoFacade;
import com.listase.excepciones.PilotoExcepcion;
import com.listaenlazada.modelop.Piloto;
import com.listase.modelo.ListapDE;
import com.listase.modelo.NodopDE;
import com.listase.utilidades.JsfUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.DiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.connector.FlowChartConnector;
import org.primefaces.model.diagram.connector.StateMachineConnector;
import org.primefaces.model.diagram.endpoint.BlankEndPoint;
import org.primefaces.model.diagram.endpoint.EndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;
import org.primefaces.model.diagram.overlay.ArrowOverlay;
import org.primefaces.model.diagram.overlay.LabelOverlay;

/**
 *
 * @author elianajuradx
 */
@Named(value = "sesionPilotoDE")
@SessionScoped
public class SesionPilotoDE implements Serializable {
    @EJB
    private PilotoFacade connPiloto;
    private ListapDE listaPilotos;
    private Piloto piloto;
    private String alInicio="1";
    private boolean deshabilitarFormulario=true;
    private NodopDE ayudante;   
    private String textoVista="Gráfico";   
    private List<Piloto> listadoPilotos;    
    private DefaultDiagramModel model;    
    private short codigoEliminar;
    private ControladorMotos controlMotos= new ControladorMotos();
    private String codigoMoto;
    private short pilotoSeleccionado;
    private Piloto PilotoDiagrama;
    private int numeroPosiciones=1;
    private int posicionPiloto;
    private String opcionElegida="1";

    public String getOpcionElegida() {
        return opcionElegida;
    }

    public void setOpcionElegida(String opcionElegida) {
        this.opcionElegida = opcionElegida;
    }
    

    public int getPosicionPiloto() {
        return posicionPiloto;
    }

    public void setPosicionPiloto(int posicionPiloto) {
        this.posicionPiloto = posicionPiloto;
    }

    public int getNumeroPosiciones() {
        return numeroPosiciones;
    }

    public void setNumeroPosiciones(int numeroPosiciones) {
        this.numeroPosiciones = numeroPosiciones;
    }

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

    public ControladorMotos getControlMotos() {
        return controlMotos;
    }

    public void setControlMotos(ControladorMotos controlMotos) {
        this.controlMotos = controlMotos;
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
        
        listaPilotos = new ListapDE(); 
        listadoPilotos = connPiloto.findAll();
        for(Piloto pil:listadoPilotos){
            listaPilotos.adicionarNodo(pil);
        } 
        
        if(listadoPilotos.size()>0){
        ayudante = listaPilotos.getCabeza();
        piloto = ayudante.getDato();
        } else {
        piloto = new Piloto();
        }
              
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

    public String getCodigoMoto() {
        return codigoMoto;
    }

    public void setCodigoMoto(String codigoDeptoSel) {
        this.codigoMoto = codigoDeptoSel;
    }

        
    public List getListadoPilotos() {
        inicializar();
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
    
    public ListapDE getListaPilotos() {
        return listaPilotos;
    }

    public void setListaPilotos(ListapDE listaPilotos) {
        this.listaPilotos = listaPilotos;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }
    
    
    public void guardarPiloto()
    {
        //obtiene el consecutivo
        piloto.setCodigo((short)(listaPilotos.contarNodos()+1));
        if(alInicio.compareTo("1")==0)
        {
            listaPilotos.adicionarNodoAlInicio(piloto);
        }
        else
        {
            listaPilotos.adicionarNodo(piloto);
        }  
        //Vuelvo a llenar la lista para la tabla
        listadoPilotos = listaPilotos.obtenerListaPilotos();
        pintarLista();
        deshabilitarFormulario=true;
        JsfUtil.addSuccessMessage("El piloto se ha guardado exitosamente");
        
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
            piloto = ayudante.getDato();
        }        
    }
    
    public void irAnterior()
    {
        if(ayudante.getAnterior()!=null)
        {
            ayudante = ayudante.getAnterior();
            piloto = ayudante.getDato();
        }        
    }
    
    public void irPrimero()
    {
        if(listaPilotos.getCabeza()!=null)
        {
            ayudante = listaPilotos.getCabeza();
            piloto = ayudante.getDato();
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
            piloto=ayudante.getDato();
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
            NodopDE temp= listaPilotos.getCabeza();
            int posX=2;
            int posY=2;
            while(temp !=null)
            {
                Element ele = new Element(temp.getDato().getNombre(), posX+"em", posY+"em");
                ele.setId(String.valueOf(temp.getDato().getCodigo()));
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
    
    public void eliminarPiloto()
    {
        if(codigoEliminar >0)
        {
            //llamo el eliminar de la lista
            try{
                listaPilotos.eliminarPiloto(codigoEliminar);
                irPrimero();
                JsfUtil.addSuccessMessage("Piloto "+codigoEliminar +" eliminado.");
            }
            catch(PilotoExcepcion e)
            {
                JsfUtil.addErrorMessage(e.getMessage());
            }
        }
        else
        {
            JsfUtil.addErrorMessage("El código a eliminar "+codigoEliminar+ " no es válido");
        }
    }
    
    
    public void obtenerPilotoDiagrama()
    {
        try {
            PilotoDiagrama = listaPilotos.obtenerPiloto(pilotoSeleccionado);
        } catch (PilotoExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    
    public void obtenerPilotoMenor()
    {
        try {
            PilotoDiagrama = listaPilotos.obtenerPilotoMenorEdad();
        } catch (PilotoExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    
    public void obtenerPosicionPiloto()
    {
        try {
            posicionPiloto = listaPilotos.obtenerPosicionPiloto(pilotoSeleccionado);
        } catch (PilotoExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    
    public void obtenerGanador()
    {
        try {
            posicionPiloto = listaPilotos.obtenerGanador(pilotoSeleccionado);
        } catch (PilotoExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    
    
    public void enviarAlFinal()
    {
        try {
            ///Buscar el piloto y guardar los datos en una variable temporal
            Piloto infTemporal = listaPilotos.obtenerPiloto(pilotoSeleccionado);
            // Eliminar el nodo
            listaPilotos.eliminarPiloto(pilotoSeleccionado);
            // Adicionarlo al final
            listaPilotos.adicionarNodo(infTemporal);
            
            pintarLista();
        } catch (PilotoExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    
    public void enviarAlInicio()
    {
        try {
            ///Buscar el piloto y guardar los datos en una variable temporal
            Piloto infTemporal = listaPilotos.obtenerPiloto(pilotoSeleccionado);
            // Eliminar el nodo
            listaPilotos.eliminarPiloto(pilotoSeleccionado);
            // Adicionarlo al inicio
            listaPilotos.adicionarNodoAlInicio(infTemporal);
            
            pintarLista();
        } catch (PilotoExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    
    public void cambiarPosicion()
    {
        boolean bandera=false;
        int posicionFinal=0;
        switch(opcionElegida)
        {
            //Ganar
            case "1":
                if(numeroPosiciones <= (posicionPiloto-1) )
                {
                    bandera=true;
                    posicionFinal = posicionPiloto - numeroPosiciones;
                }
                break;
            //Perder
            case "0":
                if(numeroPosiciones <= (listaPilotos.contarNodos()-posicionPiloto))
                {
                    bandera=true;
                    posicionFinal = posicionPiloto + numeroPosiciones;
                }
                break;
        }
        
        if(bandera)
        {
            try {
                //Realizaria la función de insertar
                Piloto datosPiloto = listaPilotos.obtenerPiloto(pilotoSeleccionado);
                // cambia la cantidad de pilotos
                listaPilotos.eliminarPiloto(pilotoSeleccionado);
                listaPilotos.adicionarNodoPosicion(posicionFinal, datosPiloto);
                irPrimero();
                JsfUtil.addSuccessMessage("Se ha realizado el cambio");
                
                
            } catch (PilotoExcepcion ex) {
               JsfUtil.addErrorMessage(ex.getMessage());
            }
            
        }
        else
        {
            JsfUtil.addErrorMessage("El número de posiciones no es válido para el piloto dado");
        }
    }
 
    
}
