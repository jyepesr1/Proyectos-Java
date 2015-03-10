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
public class Grafo {

    private ArrayList<Nodo> listaNodo;//declaracion de un listado que contendra a los dodos

   
    public Grafo(){
        listaNodo = new ArrayList<Nodo>();//creacion del listado
    }
    
    public void agregarALista(Nodo nodo){
        listaNodo.add(nodo);//ingreso del nodo a la lista
    }
    
    public void crearEnlace(String nombreNodoPadre, String nombreNodoHijo){//creacion de los enlaces
        Nodo padre = buscarNodo(nombreNodoPadre); //de donde va     
        Nodo hijo = buscarNodo(nombreNodoHijo);//a donde va
        if(padre != null && hijo != null){  
            padre.setNodo(hijo);//indica que no esta dirigido el nodo
        }
    }
    
    public Nodo buscarNodo(Object nombreNodo){
       Nodo temp = null;//cra un nodo temporal nulo , por si no se encuentra el nodo en el listado
        for(int i = 0;i < listaNodo.size(); i++){//recorre el listado de nodos
            if(((String)nombreNodo).equals((String)listaNodo.get(i).getDato())){
                return listaNodo.get(i);// si el nombre del nodo esta en la lista y regresa el nodo y su marca(visitado o no visitado)
            }
        }
        return temp;//si todo falla regresa dato nulo
    }
    
    public void imprimirLista(){
        for (Nodo nodo : listaNodo) {
            if((String)nodo.getDato()!=""){
                System.out.print((String)nodo.getDato()+"-> ");
                nodo.imprimirNodos();
            }
        }
        
    }


}
