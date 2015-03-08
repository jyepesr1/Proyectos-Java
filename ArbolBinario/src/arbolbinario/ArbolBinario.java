/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Estudiante
 */
public class ArbolBinario {

    /**
     * @param args the command line arguments
     */
    private final Nodo raiz;
        
    public ArbolBinario(int valor) {
        this.raiz = new Nodo(valor, null);
        
    }

    public void insertar(int valor) {
        raiz.insertar(valor);
    }

    
    public boolean buscar ( int valor){
        Nodo aux = raiz;
        while (aux != null){
            if (aux.getValor() == valor) {
                return true;
            }else if(aux.getValor() > valor){
                aux= aux.getHder();
            }else if (aux.getValor() < valor){
                aux= aux.getHizq();
            }
        }
        return false;
    }
    
    public void recursivo(Nodo nodo){
        if(nodo != null){
            System.out.print(nodo.getValor()+ ", ");
            recursivo(nodo.getHizq());
            recursivo(nodo.getHder());
        }
    }
    
    void recorridoIterativoPre(){
        Stack pila = new Stack();
        pila.push(raiz);
        while(raiz!= null && !pila.empty()){
            Nodo aux = (Nodo)pila.pop();
            System.out.print(aux.getValor() + ", ");
            if(aux.getHder() != null){
                pila.push(aux.getHder());
            }
            if(aux.getHizq() != null){
                pila.push(aux.getHizq());
            }
        }
    }
    
    void recorridoNiveles(){
        Queue cola = new LinkedList();
        cola.add(raiz);
        while(raiz!= null && !cola.isEmpty()){
            Nodo aux = (Nodo)cola.remove();
            System.out.print(aux.getValor() + ", ");
            if(aux.getHizq() != null){
                cola.add(aux.getHizq());
            }
            if(aux.getHder() != null){
                cola.add(aux.getHder());
            }
        }
    }
    
    
    public Nodo getRaiz() {
        return raiz;
    }
   
    public static void main(String[] args) {
        // TODO code application logic here
        ArbolBinario arbol = new ArbolBinario(10);
        arbol.insertar(5);
        arbol.insertar(20);
        arbol.insertar(2);
        arbol.insertar(7);
        arbol.insertar(15);
        arbol.insertar(25);
        arbol.insertar(1);
        arbol.insertar(3);
        arbol.insertar(6);
        arbol.insertar(8);
        arbol.insertar(21);
       
        System.out.println("recursivo");
        arbol.recursivo(arbol.getRaiz());
        System.out.println("\nIterativo");
        arbol.recorridoIterativoPre();
        System.out.println("\nNiveles");
        arbol.recorridoNiveles();
        
    }

}
