package StaticMaps;
import java.awt.Color;
import java.awt.Image;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import javax.swing.*;

/**
 * Class where the simulated data of Smart Tree is located in a static map
 * @author Michell Pineda
 */
public class Maps extends JFrame{
      
   private final PanelMaps panel;
    /**
    * Create a new type map format where GUI methods are assigned.
    */
    public Maps() {
          
        setSize(500,400);
        setResizable(false);
        setLocation(350,200);
        setBackground(Color.WHITE);
        setTitle("Static Maps | SmartTree");
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setLocationRelativeTo(getRootPane());
        
        Image icon = new ImageIcon(getClass().getResource("/SmarTree/Imagenes/Logo.png")).getImage();
        setIconImage(icon);
        
        panel = new PanelMaps(this);
        add(panel);
    }
    
    public void crearMapa(String coor){
        try{
            panel.crearMapaArbol(coor);
        }catch(MalformedURLException | UnsupportedEncodingException e){
           JOptionPane.showMessageDialog(null, "Error!");
        }
    }
}
