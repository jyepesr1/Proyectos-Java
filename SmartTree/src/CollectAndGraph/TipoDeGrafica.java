
package CollectAndGraph;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * This Class allows to Choose some Plot to Graph.
 * @author Johan Yepes
 */
public class TipoDeGrafica {
    static JFreeChart grafica;
    XYSeriesCollection datos = new XYSeriesCollection();
    String  tx, ty , titulo;
    final static int LINEAL = 1;
    final static int POLAR = 2;
    final static int DISPERSION = 3; 
    final static int SERIETIEMPO = 4;       
    final static int PASO = 5;
    int X[] = new int[GuardarVariables.sizeOfColeccion()];
    int Y[] = new int[GuardarVariables.sizeOfTiempo()];

    /**
     * Constructor of TipoGrafica().
     * @param tipo
     * @param titulo 
     */
    public TipoDeGrafica(int tipo, String titulo){
        this.ty = "Variables of Environment";
        this.tx = "Time in Seconds";
        this.titulo = titulo;
        escogerGrafica(tipo);
    }
    
    /**
     * This Method is used to Choose the kind of plot.
     * @param tipo 
     */
    public final void escogerGrafica(int tipo){
        switch (tipo) {
            case LINEAL:
                grafica = ChartFactory.createXYLineChart(titulo, tx, ty, datos, PlotOrientation.VERTICAL, true, true, true);
                break;
            case POLAR:
                grafica = ChartFactory.createPolarChart(titulo, datos, true, true, true);
                break;
            case DISPERSION:
                grafica = ChartFactory.createScatterPlot(titulo, tx, ty, datos, PlotOrientation.VERTICAL, true, true, true);
                break;
            case SERIETIEMPO:
                grafica = ChartFactory.createTimeSeriesChart(titulo, tx, ty, datos, true, true, true);
                break;
            case PASO:
                grafica = ChartFactory.createXYStepChart(titulo, tx, ty, datos, PlotOrientation.VERTICAL, true, true, true);
                break;
        }
    }
    
    /**
     * This Method allows to save the variables to create the Plot.
     * @param id 
     */
    public void agregarGrafica(String id){
        XYSeries serie = new XYSeries(id);
        for(int i=0; i<X.length;i++){
            X[i] = GuardarVariables.getTiempoOfIndex(i);
            Y[i] = GuardarVariables.getColeccionOfIndex(i);
        }
        for (int i = 0; i<X.length; i++){
            serie.add(X[i], Y[i]);
        }
        datos.addSeries(serie);
    }

    /**
     * This Method allows to return the Plot for add to Frame.
     * @return Plot
     */
    public JPanel obtenerPanel(){
        return new ChartPanel(grafica);
    } 
};
