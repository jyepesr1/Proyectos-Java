/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario;

/**
 *
 * @author Estudiante
 */
public class Nodo {

    private final int valor;
    private final Nodo padre;
    private Nodo hizq;
    private Nodo hder;

    public Nodo(int valor, Nodo padre) {
        this.valor = valor;
        this.padre = padre;
    }

    public void insertar(int valor) {
        if (valor < this.valor) {
            if (hizq != null) {
                hizq.insertar(valor);
            } else {
                hizq = new Nodo(valor, this);
            }
        } else {
            if (hder != null) {
                hder.insertar(valor);
            } else {
                hder = new Nodo(valor, this);
            }
        }
    }
    
    public int getValor() {
        return valor;
    }

    public Nodo getPadre() {
        return padre;
    }

    public Nodo getHizq() {
        return hizq;
    }

    public Nodo getHder() {
        return hder;
    }
    
    
    
}
