package arbol;

/**
 *
 * @author Familia
 */
public class Nodo {

    private final int valor;
    private final Nodo padre;
    private Nodo izquierda;
    private Nodo derecha;
    private Nodo atras;
    private Nodo adelante;

    Nodo(int valor, Nodo padre) {
        this.valor = valor;
        this.padre = padre;
    }

    void insertarIzq(int valor) {
        if (izquierda != null) {
            izquierda.insertarIzq(valor);
        } else {
            izquierda = new Nodo(valor, this);
        }
    }

    void insertarDer(int valor) {
        if (derecha != null) {
            derecha.insertarDer(valor);
        } else {
            derecha = new Nodo(valor, this);
        }
    }
    
    void insertarAtras(int valor) {
        if (atras != null) {
            atras.insertarAtras(valor);
        } else {
            atras = new Nodo(valor, this);
        }
    }
    
    void insertarAdelante(int valor) {
        if (adelante != null) {
            adelante.insertarAdelante(valor);
        } else {
            this.adelante = new Nodo(valor, this);
        }
    }

    int getValor() {
        return valor;
    }

    Nodo getPadre() {
        return padre;
    }

    Nodo getIzquierda() {
        return izquierda;
    }

    Nodo getDerecha() {
        return derecha;
    }

    Nodo getAtras(){
        return atras;
    }
    
    Nodo getAdelante(){
        return adelante;
    }
    
}
