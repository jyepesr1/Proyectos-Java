package SmartTree;

import java.awt.Color;
import java.awt.Image;
import javax.swing.*;


/**
 *Class where the different functions you can perform software shown
 * @author Michell Pineda
 */
public class Menu extends JFrame {
    
    private final PanelMenu panel;
    
     /**
     * Constructor method where component graphical interface down.
     */
    public Menu(){
               
        setSize(500,400);
        setResizable(false);
        setBackground(Color.WHITE);
        setTitle("Menu | SmartTree");
        setLocationRelativeTo(getRootPane());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Image icon = new ImageIcon(getClass().getResource("/SmarTree/Imagenes/Logo.png")).getImage();
        setIconImage(icon);
        
        panel = new PanelMenu(this);
        add(panel);
    }
}
