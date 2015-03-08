
package CollectAndGraph;

import java.awt.*;
import javax.swing.*;

/**
 * This Class Create a New Frame With a Plot.
 * @author Johan Yepes
 */
public class FrameGrafica extends JFrame{
    int opcion;
    String dato;
    String menu= " 1- Linear\n 2- Polar\n 3- Dispersion\n 4- Time Series\n 5- Step";

    /**
     * Constructor of Framegrafica().
     */
    public FrameGrafica(){
        do{
            dato=JOptionPane.showInputDialog(menu);
            opcion=Integer.parseInt(dato);
            if(opcion>0 && opcion<6){  
                TipoDeGrafica grafica = new TipoDeGrafica(opcion, "Plot");
                grafica.agregarGrafica("Variables");
                JPanel panelGrafica = grafica.obtenerPanel();
                setSize(new Dimension(500, 400));
                setLocationRelativeTo(getRootPane());
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                add(panelGrafica);
                setVisible(true);
            }else{
                 JOptionPane.showMessageDialog(null, "Please, Choose a valid option", "Alert", JOptionPane.WARNING_MESSAGE);
            }
        }while(opcion<1 || opcion>5);
    }
};
