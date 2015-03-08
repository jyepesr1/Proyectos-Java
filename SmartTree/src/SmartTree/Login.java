package SmartTree;

import java.awt.Image;
import javax.swing.*;

/**
 * Class where the user enters the respective data with which you can access to application.
 * @author Michell Pineda
 */
public class Login extends JFrame {
    
    
    private final PanelLogin panel;
    
    /**
     * Constructor method where component graphical interface down.
     */
    public Login(){
               
        setSize(500,400);
        setResizable(false);
        setTitle("Login | SmartTree");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(getRootPane());
        
        Image icon = new ImageIcon(getClass().getResource("/SmarTree/Imagenes/Logo.png")).getImage();
        setIconImage(icon);
        
        panel = new PanelLogin(this);
        add(panel);
    
    }

     /**
    * Charge method to validate if the data entered are incorrect.
    * @param usuario is compared with the data stored in the array user of the Log class.
    * @param clave  is compared with the data stored in the array pass the Log class.
    */
    public void validar(String usuario,String clave){
        if (usuario.equals ("")|| clave.equals("")){
            JOptionPane.showMessageDialog(null, "Please check your user and password and try again","Login Failed!" , JOptionPane.WARNING_MESSAGE);
        }else if (Log.validarIngreso(usuario,clave)){
            Menu m = new Menu();
            m.setVisible(true);
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Data entered is incorrect. Please check" , "Login Failed!",JOptionPane.ERROR_MESSAGE);
 	}
    }
    
   
}
