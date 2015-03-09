
package arbol;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Familia
 */
public class Arbol {
    private final Nodo raiz;
    
    Arbol(int valor){
        this.raiz = new Nodo(valor, null);
    }
    
    void insertar(int valor){
        int numero = (int)Math.floor(Math.random()*1000);
        
        if(numero < 250){
            raiz.insertarAtras(numero);
        }else if(numero >= 250 && numero < 500){
            raiz.insertarAdelante(numero);
        }else if(numero >=500 && numero < 750){
            raiz.insertarDer(numero);
        }else{
            raiz.insertarIzq(numero);
        }
    }
 
    public void recorridoPos(Nodo nodo){
        System.out.print(nodo.getValor()+ ", ");
        
        if(nodo.getAtras() != null){
            recorridoPos(nodo.getAtras());
        }
        
        if (nodo.getAdelante() != null){
            recorridoPos(nodo.getAdelante());
        }
        
        if (nodo.getIzquierda() != null){
            recorridoPos(nodo.getIzquierda());
        }
        
        if (nodo.getDerecha() != null){
            recorridoPos(nodo.getDerecha());
        }
    }
    
    
    void recorridoIterativoPre(){
        Stack pila = new Stack();
        pila.push(raiz);
        while(raiz!= null && !pila.empty()){
            Nodo aux = (Nodo)pila.pop();
            System.out.print(aux.getValor() + ", ");
            if(aux.getAtras() != null){
                pila.push(aux.getAtras());
            }
            if(aux.getAdelante() != null){
                pila.push(aux.getAdelante());
            }
            if(aux.getIzquierda() != null){
                pila.push(aux.getIzquierda());
            }
            if(aux.getDerecha() != null){
                pila.push(aux.getDerecha());
            }
        }
    }
    
    
    Nodo getRaiz(){
        return raiz;
    }
    public static void main(String[] args){
        Arbol arbol;
        Scanner sc = new Scanner(System.in);
        System.out.println("El orden de inserción de los valores del árbol\nen todos los casos se hará completamente en forma aleatoria\n");
        System.out.println("Digite que opción Desea\n");
        System.out.println("1- Árbol completamente aleatorio\n" + "2- Árbol Manual\n");
        int opcion = sc.nextInt();
        switch(opcion){
            case 1:
                arbol = new Arbol((int)Math.floor(Math.random()*1000));
                System.out.println("¿Cuántos Nodos tendrá el árbol, sin contar la raíz?");
                int cantidad = sc.nextInt();
                for(int i=0; i < cantidad; i++){
                    arbol.insertar((int)Math.floor(Math.random()*1000));
                }
                arbol.recorridoPos(arbol.getRaiz());
                System.out.println("\nIterativo");
                arbol.recorridoIterativoPre();
            break;
                
            case 2:
                System.out.println("Ingrese los valores que contendrá el árbol, empezando por la raíz\n\"Para terminar la inserción digite -1\"");
                arbol = new Arbol(sc.nextInt());
                int valor = sc.nextInt();
                while(valor != -1){
                    arbol.insertar(valor);
                    valor = sc.nextInt();
                }
                arbol.recorridoPos(arbol.getRaiz());
            break;
        }
    }
}
