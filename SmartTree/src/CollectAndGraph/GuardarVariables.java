
package CollectAndGraph;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author Johan Yepes
 */
public class GuardarVariables {
    private static final ArrayList<Integer> coleccion = new ArrayList();
    private static final ArrayList<Integer> tiempo = new ArrayList();

    /**
     * Constructor of GuardarVariables().
     */
    public static void verValores(){
        for (Integer valor : coleccion) {
            JOptionPane.showMessageDialog(null, "El número es: " + valor);
        }
    }
    
    /**
     * This Method returns an ArrayList.
     * @return  Coleccion ArrayList
     */
    public static ArrayList<Integer> getArray(){
        return coleccion;
    }
     
    /**
     * This Method adds an Integer in index i of Coleccion.
     * @param i 
     */
    public static void addToColeccion(Integer i){
        coleccion.add(i);
    }
    
    /**
     * This Method clears all of ArrayList.
     */
    public static void clearColeccion(){
        coleccion.clear();
    }
    
    /**
     * This Method adds an Integer in index i of Tiempo.
     * @param i 
     */
    public static void addToTiempo(Integer i){
        tiempo.add(i);
    }
    
    /**
     * This Method returns the Size of Coleccion.
     * @return 
     */
    public static int sizeOfColeccion(){
        return coleccion.size();
    }
    
    /**
     * This Method returns the Size of Tiempo.
     * @return 
     */
    public static int sizeOfTiempo(){
        return tiempo.size();
    }
    
    /**
     * This Method returns the number in index i of Coleccion.
     * @param i
     * @return 
     */
    public static int getColeccionOfIndex(int i){
        return coleccion.get(i);
    }
    
    /**
     * This Method returns the number in index i of Tiempo.
     * @param i
     * @return 
     */
    public static int getTiempoOfIndex(int i){
        return tiempo.get(i);
    } 
};

