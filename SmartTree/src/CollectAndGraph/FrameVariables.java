
package CollectAndGraph;

import java.awt.Image;
import javax.swing.*;

/**
 * This Class Create a New Variables Frame and add the Variables Panel.
 * @author Johan Yepes
 */
public class FrameVariables extends JFrame {
    

    public static void main(String[] args) {
        FrameVariables interfazGrafica = new FrameVariables();
        interfazGrafica.setVisible(true);
    }

    private final PanelVariables panelVariable;
            
    /**
     * Constructor of FrameVariables().
     */
    public FrameVariables(){
        setTitle("Collection Of Variables");
        setSize(500, 400);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(getRootPane());
        
        Image icon = new ImageIcon(getClass().getResource("/SmarTree/Imagenes/Logo.png")).getImage();
        setIconImage(icon);

        panelVariable = new PanelVariables(this);
        add(panelVariable);  
    } 
};
