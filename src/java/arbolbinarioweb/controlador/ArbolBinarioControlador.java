/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinarioweb.controlador;

import arbolbinario.modelo.ArbolBinario;
import arbolbinario.modelo.Nodo;
import arbolbinario.modelo.excepciones.ArbolBinarioException;
import arbolbinarioweb.controlador.util.JsfUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.connector.Connector;
import org.primefaces.model.diagram.connector.StraightConnector;
import org.primefaces.model.diagram.endpoint.DotEndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;

/**
 *
 * @author carloaiza
 */
@Named(value = "arbolBinarioControlador")
@SessionScoped
public class ArbolBinarioControlador implements Serializable {

    private DefaultDiagramModel model;
    private DefaultDiagramModel modelArbol2;

    private ArbolBinario arbol = new ArbolBinario();
    private int dato;
    private int nummultiplicar;
    private boolean verInOrden = false; 
    private boolean verPreOrden = false;
    private boolean verPostOrden = false;
    private boolean verMenor= false;
    private boolean verMayor= false;
    private boolean verNivel= false;
    private boolean verPorNivel= false;
    private boolean verHojas= false;
    private boolean verRamaMayor= false;
    private boolean verBalance= false;
    private boolean verPadre= false;
    
    private String datoscsv = "1,2,-1";
    private int terminado;
    private int numero;
    private int hijo;
    private ArbolBinario arbolTerminados = new ArbolBinario();

    

    
    
    
    public ArbolBinario getArbolTerminados() {
        return arbolTerminados;
    }

    public void setArbolTerminados(ArbolBinario arbolTerminados) {
        this.arbolTerminados = arbolTerminados;
    }

    public int getTerminado() {
        return terminado;
    }

    public void setTerminado(int terminado) {
        this.terminado = terminado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getHijo() {
        return hijo;
    }

    public void setHijo(int hijo) {
        this.hijo = hijo;
    }
   
    public DefaultDiagramModel getModelArbol2() {
        return modelArbol2;
    }

    public void setModelArbol2(DefaultDiagramModel modelArbol2) {
        this.modelArbol2 = modelArbol2;
    }

    public String getDatoscsv() {
        return datoscsv;
    }

    public void setDatoscsv(String datoscsv) {
        this.datoscsv = datoscsv;
    }

    public boolean isVerInOrden() {
        return verInOrden;
    }

    public void setVerInOrden(boolean verInOrden) {
        this.verInOrden = verInOrden;
    }
    
    public boolean isVerPreOrden() {
        return verPreOrden;
    }

    public void setVerPreOrden(boolean verPreOrden) {
        this.verPreOrden = verPreOrden;
    }
    
     public boolean isVerPostOrden() {
        return verPostOrden;
    }

    public void setVerPostOrden(boolean verPostOrden) {
        this.verPostOrden = verPostOrden;
    }
     public boolean isVerMenor() {
        return verMenor;
    }
    public void setVerMenor(boolean verMenor) {
        this.verMenor = verMenor;
    }

    public boolean isVerMayor() {
        return verMayor;
    }

    public void setVerMayor(boolean verMayor) {
        this.verMayor = verMayor;
    }
    public boolean isVerNivel() {
        return verNivel;
    }

    public void setVerNivel(boolean verNivel) {
        this.verNivel = verNivel;
    }
    public boolean isVerPorNivel() {
        return verPorNivel;
    }

    public void setVerPorNivel(boolean verPorNivel) {
        this.verPorNivel = verPorNivel;
    }
    public boolean isVerHojas() {
        return verHojas;
    }

    public void setVerHojas(boolean verPorHojas) {
        this.verHojas = verPorHojas;
    } 
    public boolean isVerRamaMayor() {
        return verRamaMayor;
    }

    public void setVerRamaMayor(boolean verRamaMayor) {
        this.verRamaMayor = verRamaMayor;
    }
    public boolean isVerBalance() {
        return verBalance;
    }

    public void setVerBalance(boolean verBalance) {
        this.verBalance = verBalance;
    }
    public boolean isVerPadre() {
        return verPadre;
    }

    public void setVerPadre(boolean verPadre) {
        this.verPadre = verPadre;
    }
    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public int getNummultiplicar() {
        return nummultiplicar;
    }

    public void setNummultiplicar(int nummultiplicar) {
        this.nummultiplicar = nummultiplicar;
    }

    
  
     
    
    
    public ArbolBinario getArbol() {
        return arbol;
    }

    public void setArbol(ArbolBinario arbol) {
        this.arbol = arbol;
    }

    /**
     * Creates a new instance of ArbolBinarioControlador
     */
    public ArbolBinarioControlador() {

    }

    public void adicionarNodo() {
        try {
            arbol.adicionarNodo(dato, arbol.getRaiz());
            JsfUtil.addSuccessMessage("El dato ha sido adicionado");
            dato = 0;
            pintarArbol();

        } catch (ArbolBinarioException ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }

    public void habilitarInOrden() {
        try {
            arbol.isLleno();
            verInOrden = true;
        } catch (ArbolBinarioException ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    public void habilitarPreOrden() {
        try {
            arbol.isLleno();
            verPreOrden = true;
        } catch (ArbolBinarioException ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }

    public void habilitarPostOrden() {
        try {
            arbol.isLleno();
            verPostOrden = true;
        } catch (ArbolBinarioException ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    public String menorValor() {
        return this.arbol.Menor();
    }

    public String mayorValor() {
        return this.arbol.Mayor();
    }

    public void habilitaMenor() {
        try {
            arbol.isLleno();
            verMenor = true;
        } catch (ArbolBinarioException ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    public void habilitaMayor() {
        try {
            arbol.isLleno();
            verMayor = true;
        } catch (ArbolBinarioException ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }

    public void borrarMenor() {
        try{
        arbol.isLleno();
        this.arbol.borrarMenor();
        pintarArbol();
        } catch (ArbolBinarioException ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    public void borrarMayor() {
        try{
        arbol.isLleno();
        this.arbol.borrarMayor();
        pintarArbol();
        }catch (ArbolBinarioException ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    public void cambiar() {
        try{
        arbol.isLleno();
        this.arbol.cambiar();
        pintarArbol();
        }catch (ArbolBinarioException ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
     
    public void multiplicar() {
        try{
        arbol.isLleno();
        this.arbol.cambiar();
        pintarArbol();
        }catch (ArbolBinarioException ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    
    
    
    public void buscarNumeros() {
        for (Element ele : model.getElements()) {
            ele.setStyleClass("ui-diagram-element");
            int numbusc = Integer.parseInt(ele.getData().toString());
            if (numbusc < 0) {
                numbusc *= -1;
            }
            if (numbusc == numero) {
                ele.setStyleClass("ui-diagram-element-busc");
            }
        }    
    }
       public String porNivel(){
        this.arbol.alturaArbol();
        ArrayList it = this.arbol.imprimirNivel();
        return (recorrido(it, "Imprimir Por niveles en orden!!!"));
    }
       public void habilitarPorNivel() {
        try {
            arbol.isLleno();
            verPorNivel = true;
        } catch (ArbolBinarioException ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }   
       public void podarArbol() {
         try {
            arbol.isLleno();
            this.arbol.podar();
            pintarArbol();
        } catch (ArbolBinarioException ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
        private String recorrido(ArrayList it, String msg) {
        int i = 0;
        String r = msg + "\n";
        while (i < it.size()) {
            r += "\t" + it.get(i).toString() + "\n";
            i++;
        }
        return (r);
    }
       public String imprimirPorNiveles() {
        ArrayList it = this.arbol.impNiveles();
        return (recorrido(it, ""));
    }
       public void habilitarNivel() {
        try {
            arbol.isLleno();
            verNivel = true;
        } catch (ArbolBinarioException ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }  
       
        public String darHojas() {
        ArrayList it = this.arbol.imprimirHojas();
        return (recorrido(it, "Hojas del Arbol"));
    }
        public String CantidadHojas(){
        return this.arbol.cantidadNodosHoja();
    }
         public void habilitarHojas() {
        try {
            arbol.isLleno();
            verHojas = true;
        } catch (ArbolBinarioException ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }  
          public String alturaArbol(){
        return this.arbol.retornarAltura();
    }
          public String ramaMayor() {
        ArrayList it = this.arbol.ObtenerRamamayor();
        return (recorrido(it, "Rama(s) con mas valores"));
    }
          public void habilitarRamaMayor() {
        try {
            arbol.isLleno();
            verRamaMayor = true;
        } catch (ArbolBinarioException ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }  
          public String balance(){
        return this.arbol.imprimirBalance();
    }
           public void habilitarBalance() {
        try {
            arbol.isLleno();
            verBalance= true;
        } catch (ArbolBinarioException ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }  
      public String darPadre() {
        if (this.arbol.getRaiz().getDato() == (numero)) {
            return ("La raiz no tiene padre");
        }
        Integer padre = this.arbol.padre();
        if (padre == null) {
            return ("No existe el Dato: " + numero);
        }
        return ("El padre de: " + numero + "\n es : " + padre.toString());
    }

    public String esta(Integer dato) {
        boolean siEsta = this.arbol.buscar(dato);
        String r = "El dato:" + dato.toString() + "\n";
        r += siEsta ? "Si se encuentra en el arbol" : "No se encuentra en el arbol";
        return (r);
    }
    public void habilitarPadre() {
        try {
            arbol.isLleno();
            verPadre = true;
        } catch (ArbolBinarioException ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    public DefaultDiagramModel getModel() {
        return model;
    }

    public void setModel(DefaultDiagramModel model) {
        this.model = model;
    }

    public void pintarArbol() {

        model = new DefaultDiagramModel();
        model.setMaxConnections(-1);
        model.setConnectionsDetachable(false);
        StraightConnector connector = new StraightConnector();
        connector.setPaintStyle("{strokeStyle:'#404a4e', lineWidth:2}");
        connector.setHoverPaintStyle("{strokeStyle:'#20282b'}");
        model.setDefaultConnector(connector);
        pintarArbol(arbol.getRaiz(), model, null, 30, 0);

    }

    private void pintarArbol(Nodo reco, DefaultDiagramModel model, Element padre, int x, int y) {

        if (reco != null) {
            Element elementHijo = new Element(reco.getDato());

            elementHijo.setX(String.valueOf(x) + "em");
            elementHijo.setY(String.valueOf(y) + "em");

            if (padre != null) {
                elementHijo.addEndPoint(new DotEndPoint(EndPointAnchor.TOP));
                DotEndPoint conectorPadre = new DotEndPoint(EndPointAnchor.BOTTOM);
                padre.addEndPoint(conectorPadre);
                model.connect(new Connection(conectorPadre, elementHijo.getEndPoints().get(0)));

            }

            model.addElement(elementHijo);

            pintarArbol(reco.getIzquierda(), model, elementHijo, x - 5, y + 5);
            pintarArbol(reco.getDerecha(), model, elementHijo, x + 5, y + 5);
        }
    }

    public void extraerDatos() {
        try {
            arbol.setRaiz(null);
            arbol.llenarArbol(datoscsv);
            pintarArbol();
            datoscsv = "";
        } catch (ArbolBinarioException ex) {
            JsfUtil.addErrorMessage("Los datos ingresados no tienen el formato separado por comas");
        }
    }

    public void buscarTerminadosEn() {
        for (Element ele : model.getElements()) {
            ele.setStyleClass("ui-diagram-element");
            int numTerm = Integer.parseInt(ele.getData().toString());
            if (numTerm < 0) {
                numTerm *= -1;
            }
            if (numTerm % 10 == terminado) {
                ele.setStyleClass("ui-diagram-element-busc");
            }
        }
    }

    public void encontrarTerminadosEn() {
        try {
            arbolTerminados = new ArbolBinario();
            encontrarTerminadosEn(arbol.getRaiz());
            pintarArbolTerminados();
        } catch (ArbolBinarioException ex) {
            JsfUtil.addErrorMessage("Ocurrio un error generando el árbol de terminados" + ex);
        }
    }

    private void encontrarTerminadosEn(Nodo reco) throws ArbolBinarioException {
        if (reco != null) {
            int numTerm= reco.getDato();
            if(numTerm<0)
            {
                numTerm *=-1;
            }
            if(numTerm%10==terminado)
            {
                arbolTerminados.adicionarNodo(reco.getDato(), arbolTerminados.getRaiz());
            }
            encontrarTerminadosEn(reco.getIzquierda());
            encontrarTerminadosEn(reco.getDerecha());
        }
    }

    public void pintarArbolTerminados() {

        modelArbol2 = new DefaultDiagramModel();
        modelArbol2.setMaxConnections(-1);
        modelArbol2.setConnectionsDetachable(false);
        StraightConnector connector = new StraightConnector();
        connector.setPaintStyle("{strokeStyle:'#404a4e', lineWidth:2}");
        connector.setHoverPaintStyle("{strokeStyle:'#20282b'}");
        modelArbol2.setDefaultConnector(connector);
        pintarArbolTerminados(arbolTerminados.getRaiz(), modelArbol2, null, 30, 0);

    }

    private void pintarArbolTerminados(Nodo reco, DefaultDiagramModel model, Element padre, int x, int y) {

        if (reco != null) {
            Element elementHijo = new Element(reco.getDato());

            elementHijo.setX(String.valueOf(x) + "em");
            elementHijo.setY(String.valueOf(y) + "em");

            if (padre != null) {
                elementHijo.addEndPoint(new DotEndPoint(EndPointAnchor.TOP));
                DotEndPoint conectorPadre = new DotEndPoint(EndPointAnchor.BOTTOM);
                padre.addEndPoint(conectorPadre);
                model.connect(new Connection(conectorPadre, elementHijo.getEndPoints().get(0)));

            }

            model.addElement(elementHijo);

            pintarArbolTerminados(reco.getIzquierda(), model, elementHijo, x - 5, y + 5);
            pintarArbolTerminados(reco.getDerecha(), model, elementHijo, x + 5, y + 5);
        }
    }

}
