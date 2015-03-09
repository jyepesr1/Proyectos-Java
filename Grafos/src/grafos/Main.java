/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.Scanner;

/**
 *
 * @author johan
 */
public class Main {
     static Grafo grafo = new Grafo();//<--Se declara que grafo va a ser accesible desde la clase Grafo
    
    public static void llenandoGrafo(){
        
        Scanner sc= new Scanner(System.in);
        
        System.out.println("Ingrese el número de Nodos:");
        int numNodos = sc.nextInt();
        
        System.out.println("Ingrese el número de Aristas:");
        int numAristas = sc.nextInt();
        
        System.out.println("Ingrese el nombre de los nodos como letras, separados con enter");
        for (int i = 0; i <= numNodos; i++) {
            String cade = sc.nextLine();
            grafo.agregarALista(new Nodo(cade));
            System.out.println(cade);
        }
        
        System.out.println("Ingrese las conexiones de los nodos, así A B");
        for (int i = 0; i < numAristas; i++) {
            String relacion = sc.nextLine();
            grafo.crearEnlaces(relacion.substring(0,1), relacion.substring(2,3));
        }
        
//        grafo.agregarALista(new Nodo("A")); //Creacion de los nodos
//        grafo.agregarALista(new Nodo("B")); //ojo no de sus vertices     
//        grafo.agregarALista(new Nodo("C"));
//        grafo.agregarALista(new Nodo("D"));
//        grafo.agregarALista(new Nodo("F"));
       
//        grafo.crearEnlaces("A","B");// de A hacia B
//        grafo.crearEnlaces("B","A");// de B hacia A
//        /*
//         * Lo anterior lo hacemos por ser un grafo no dirigido...
//         * En caso de ser un grafo con peso esto no estaria muy bien que digamos
//         * De la misma forma lo hacemos con los demas vertices
//        */
//        
//        grafo.crearEnlaces("A","C");
//        grafo.crearEnlaces("C","A");
//        
//        grafo.crearEnlaces("A","F");
//        grafo.crearEnlaces("F","A");
//        
////        grafo.crearEnlaces("B","A");//Esta enlace ya existe
////        grafo.crearEnlaces("A","B");//Esta enlace ya existe
//        
//        grafo.crearEnlaces("B","F");
//        grafo.crearEnlaces("F","B");
//        
////        grafo.crearEnlaces("C","A");//Esta enlace ya existe
////        grafo.crearEnlaces("A","C");//Esta enlace ya existe
//        
//        grafo.crearEnlaces("C","D");
//        grafo.crearEnlaces("D","C");
//        
//        grafo.crearEnlaces("D","C");//Esta enlace ya existe
//        grafo.crearEnlaces("C","D");//Esta enlace ya existe
        
//        grafo.crearEnlaces("F","A");//Esta enlace ya existe
//        grafo.crearEnlaces("A","F");//Esta enlace ya existe
        
//        grafo.crearEnlaces("F","B");//Esta enlace ya existe
//        grafo.crearEnlaces("B","F");//Esta enlace ya existe
 
    }
    
    
    public static void main(String []args){        
        
        llenandoGrafo(); //llamando a llenando grafo(si lo que esta arriba)
        
        System.out.println("----------------------------------------------");
        grafo.imprimirLista();
    }
    
}
