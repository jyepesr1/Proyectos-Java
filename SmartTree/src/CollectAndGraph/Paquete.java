
package CollectAndGraph;

import java.io.*;

/**
 * This Class allows to create a package that contains the variables in a file.
 * @author Johan Yepes
 */
public class Paquete implements Serializable{
    private final String tipoVariable;
    private final int ultimaVariable;
    private final double latitud;
    private final double longitud;

    /**
     * Constructor Paquete().
     * @param tipoVariable
     * @param ultimaVariable
     * @param latitud
     * @param longitud 
     */
    public Paquete(String tipoVariable, int ultimaVariable, double latitud, double longitud) {
        this.tipoVariable = tipoVariable;
        this.ultimaVariable = ultimaVariable;
        this.latitud = latitud;
        this.longitud = longitud;
    }
    
   
    @Override
    /**
     * This Method overrides the method toString() for shows the variables.
     */
    public String toString(){
        return "Kind: "+tipoVariable+"\n"+"Last Value: "+ultimaVariable+"\n"+"Latitude: "+latitud+"\n"+"Length: "+longitud;
    }
    
    /**
     * this Method returns the kind of variable.
     * @return 
     */
    public String getTipo(){
        return tipoVariable;
    }
    
    /**
     * This Method returns the last variable of the ArrayList.
     * @return 
     */
    public int getVariable(){
        return ultimaVariable;
    }
    
    /**
     * This Method returns the Coordinates of a site (Latitude and Length).
     * @return 
     */
    public String getCoordenadas(){
        return Double.toString(latitud)+","+Double.toString(longitud);
    }
    
}
