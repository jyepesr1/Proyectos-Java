package DescriptionTrees;

import java.awt.*;
import javax.swing.*;


 /**
 * This class allows to create a Frame of Description.
 * @author Alejandra Cardenas
 */
public class FrameDescription extends JFrame{
       
    private final PanelDescription panelDescription;
    
    /**
     * Constructor of Description
     */
    public FrameDescription(){
        setSize(new Dimension(800, 550));
        setResizable(false);
        setLocationRelativeTo(getRootPane());
        setTitle("Description Trees | SmarTree");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panelDescription = new PanelDescription(this);
        add(panelDescription);
    }
}
