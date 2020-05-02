package com.listase.controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.listase.controlador.ControladorLocalidades;
import com.listase.excepciones.infanteExcepcion;
import com.listase.modelo.Infante;
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
@Named(value = "sesionInfateDE")
@SessionScoped
public class SesionInfanteDE implements Serializable {
private ListaDE listaInfantes;
    private Infante infante;
    private String alInicio="1";
    private boolean deshabilitarFormulario=true;
    private NodoDE ayudante;   
    private String textoVista="Gráfico";   
    private List listadoInfantes;    
    private DefaultDiagramModel model;    
    private short codigoEliminar;
    private ControladorLocalidades controlLocalidades= new ControladorLocalidades();
    private String codigoDeptoSel;
    private short infanteSeleccionado;
    private Infante InfanteDiagrama;

    public Infante getInfanteDiagrama() {
        return InfanteDiagrama;
    }

    public void setInfanteDiagrama(Infante InfanteDiagrama) {
        this.InfanteDiagrama = InfanteDiagrama;
    }

    public short getInfanteSeleccionado() {
        return infanteSeleccionado;
    }

    public void setInfanteSeleccionado(short infanteSeleccionado) {
        this.infanteSeleccionado = infanteSeleccionado;
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
     * Creates a new instance of SesionInfante
     */
    public SesionInfanteDE() {        
    }
    
    @PostConstruct
    private void inicializar()
    {
        controlLocalidades= new ControladorLocalidades();
        codigoDeptoSel = controlLocalidades.getDepartamentos().get(0).getCodigo();
        listaInfantes = new ListaDE();        
        //LLenado de la bds
        listaInfantes.adicionarNodo(new Infante("Carlitos",(short) 1, (byte)2, true, controlLocalidades.getCiudades().get(0).getNombre()));
        listaInfantes.adicionarNodo(new Infante("Juanita",(short) 2, (byte)3, true, controlLocalidades.getCiudades().get(2).getNombre()));
        listaInfantes.adicionarNodo(new Infante("Martina",(short) 3, (byte)1, false, controlLocalidades.getCiudades().get(0).getNombre()));
        listaInfantes.adicionarNodoAlInicio(new Infante("Mariana",(short) 4, (byte)5, false, controlLocalidades.getCiudades().get(1).getNombre()));
        ayudante = listaInfantes.getCabeza();
        infante = ayudante.getDato();     
        //Me llena el objeto List para la tabla
        listadoInfantes = listaInfantes.obtenerListaInfantes();
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

        
    public List getListadoInfantes() {
        return listadoInfantes;
    }

    public void setListadoInfantes(List listadoInfantes) {
        this.listadoInfantes = listadoInfantes;
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
    
    public ListaDE getListaInfantes() {
        return listaInfantes;
    }

    public void setListaInfantes(ListaDE listaInfantes) {
        this.listaInfantes = listaInfantes;
    }

    public Infante getInfante() {
        return infante;
    }

    public void setInfante(Infante infante) {
        this.infante = infante;
    }
    
    
    
    public void guardarInfante()
    {
        infante.setCodigo((short)(listaInfantes.contarNodos()+1));
        if(alInicio.compareTo("1")==0)
        {
            listaInfantes.adicionarNodoAlInicio(infante);
        }
        else
        {
            listaInfantes.adicionarNodo(infante);
        }  
        //Vuelvo a llenar la lista para la tabla
        irPrimero();
        JsfUtil.addSuccessMessage("El infante se ha guardado correctamente");
        
    }
    
    public void habilitarFormulario()
    {
        deshabilitarFormulario=false;
        infante = new Infante();
    }
    
    public void irSiguiente()
    {
        if(ayudante.getSiguiente()!=null)
        {
            ayudante = ayudante.getSiguiente();
            infante = ayudante.getDato();
        }        
    }
    
    public void irAnterior()
    {
        if(ayudante.getAnterior()!=null)
        {
            ayudante = ayudante.getAnterior();
            infante = ayudante.getDato();
        }        
    }
    
    public void irPrimero()
    {
        if(listaInfantes.getCabeza()!=null)
        {
            ayudante = listaInfantes.getCabeza();
            infante = ayudante.getDato();
        }
        else
        {
            infante = new Infante();
        }
        listadoInfantes = listaInfantes.obtenerListaInfantes();
        pintarLista();
    }
    
    public void irUltimo()
    {
        if(listaInfantes.getCabeza()!=null)
        {            
            while(ayudante.getSiguiente()!=null)
            {
                ayudante = ayudante.getSiguiente();
            }
            infante=ayudante.getDato();
        }
    }
    
    public void cambiarVistaInfantes()
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
        listaInfantes.invertirLista();
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
        if(listaInfantes.getCabeza() !=null)
        {
            NodoDE temp= listaInfantes.getCabeza();
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
        infanteSeleccionado = Short.valueOf(id.replaceAll("frmInfante:diagrama-", ""));
        System.out.println(infanteSeleccionado);
    }

    
    public void eliminarInfante()
    {
        if(codigoEliminar >0)
        {
            try {
                listaInfantes.eliminarInfante(codigoEliminar);
                irPrimero();
                infante= listaInfantes.getCabeza().getDato();
                JsfUtil.addSuccessMessage("Infante " +codigoEliminar+ " eliminado");
            } catch (infanteExcepcion e) {
                JsfUtil.addErrorMessage(e.getMessage());
            }
{
            
            }
        }
  
        else
        {
            JsfUtil.addErrorMessage("El código a elminar: " +codigoEliminar+ " No es válido" );
        }
    }
    
    public void obtenerInfanteDiagrama()
    {
        try {
            InfanteDiagrama = listaInfantes.obtenerInfante(infanteSeleccionado);
        } catch (infanteExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    
    public void enviarAlFinal() {
        try
        {
            Infante InfTemporal = listaInfantes.obtenerInfante(infanteSeleccionado);
            listaInfantes.eliminarInfante(infanteSeleccionado);
            listaInfantes.adicionarNodo(InfTemporal);
            
            pintarLista();
        }
        catch (infanteExcepcion ex)
            {
                JsfUtil.addErrorMessage(ex.getMessage());
            }
        
    }
    
    public void enviarAlInicio() {
        try
        {
            Infante InfTemporal = listaInfantes.obtenerInfante(infanteSeleccionado);
            listaInfantes.eliminarInfante(infanteSeleccionado);
            listaInfantes.adicionarNodoAlInicio(InfTemporal);
            
            pintarLista();
        }
        catch (infanteExcepcion ex)
            {
                JsfUtil.addErrorMessage(ex.getMessage());
            }
        
    }
    public void adelantarInfante() {
        try
        {
            Infante InfTemporal = listaInfantes.obtenerInfante(infanteSeleccionado);
            ayudante = ayudante.getSiguiente().getSiguiente();
            infante = ayudante.getDato();
            listaInfantes.eliminarInfante(infanteSeleccionado);
            listaInfantes.adicionarNodoAlInicio(InfTemporal);
            
            pintarLista();
        }
        catch (infanteExcepcion ex)
            {
                JsfUtil.addErrorMessage(ex.getMessage());
            }
        
    }
}
