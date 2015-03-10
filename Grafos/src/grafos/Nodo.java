/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;

/**
 *
 * @author johan
 */
public class Nodo {
    private Object dato;// define a dato como un objeo simple
    private ArrayList<Nodo> listaNodos;//define a los lugares en la lista como nodos
    public boolean visitado = false;// define un parametro del tipo booleano para la marca visitado

    public Nodo(){// prepara espacio para el nodo
    	this(new Object());
    }
    public Nodo(Object dato){//metodo sobre cargado de Nodo
        this.dato = dato;//define un puntero para dato
        listaNodos = new ArrayList<Nodo>();//creacion del nodo en el arreglo
    }
    public void setDato(Object dato){//los metodos getDato y setDato sirven para poder marcar al nodo con un dato (el booleano)
        this.dato = dato;
    }
    public Object getDato(){
        return this.dato;
    }
    public void setNodo(Nodo nodo){//puntero para el nodo al agragarlo
        this.listaNodos.add(nodo);
    }
    public ArrayList<Nodo> getHijos(){//para identificar en el arreglo quien es nodo hijo y devolverlo
        return listaNodos;
    }
    
     public void imprimirNodos(){
        for (Nodo nodo : listaNodos){
            if((String)nodo.getDato()!="") System.out.print((String)nodo.getDato()+" ");
        }
        
         System.out.println();
        
    }
}
