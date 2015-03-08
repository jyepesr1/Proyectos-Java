
package SmartTree;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Michell Pineda
 */
public class PanelLogin extends JPanel{

    private final JLabel lblUser;
    private final JLabel lblPassword; 
    private final JTextField txtUser;
    private final JPasswordField txtPassword;
    private final JButton btnLogin;
    private final Login login;
    private final JTextArea txtPersonas;
    
    public PanelLogin(Login j) {
        setPreferredSize(new Dimension(500,400));
        setVisible(true);
        setLayout(null);
        
        lblUser = new JLabel("User:");
        lblPassword = new JLabel("Password:");
        txtUser = new JTextField("");
        txtPassword = new JPasswordField("");
        btnLogin = new JButton("Log In");
         
        txtPersonas = new JTextArea();
        txtPersonas.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        txtPersonas.setText("Developed by:    Johan Sebastian Yepes Rios \nDayana Michelle Pineda Borja \n Alejandra Cardenas Montoya");
        txtPersonas.setBounds(-45, 285, 300, 200);
        txtPersonas.setForeground(new java.awt.Color(56, 124, 53)); 
        txtPersonas.setFont(new Font("Futura Md BT", 1, 12) );
        txtPersonas.setOpaque(false);
        txtPersonas.setEditable(false);
        add(txtPersonas);
        
        lblUser.setBounds(250, 190, 100, 20);
        lblUser.setFont(new java.awt.Font("Futura Md BT", 0, 18));
        add(lblUser);
        
        lblPassword.setBounds(220, 240, 100, 20);
        lblPassword.setFont(new java.awt.Font("Futura Md BT", 0, 18));
        add(lblPassword);
        
        txtUser.setBounds(320, 190, 140, 20);
        txtUser.setFont(new java.awt.Font("Futura Md BT", 0, 15));
        txtUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 124, 53)));
        add(txtUser);
        
        txtPassword.setBounds(320, 240, 140, 20);
        txtPassword.setFont(new java.awt.Font("Futura Md BT", 0, 15));
        txtPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 124, 53)));
        txtPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        add(txtPassword);
                
        btnLogin.setBounds(340, 310, 100, 30);
        btnLogin.setForeground(new java.awt.Color(56, 124, 53));        
        btnLogin.setBackground(new java.awt.Color(255, 255, 255));
        btnLogin.setFont(new java.awt.Font("Futura Md BT", 1, 14));
        add(btnLogin);
        
        login = j;
        
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
    }
    
    /**
     * This Method allows to set the background of Frame.
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g){
        Dimension tamaño = getSize();
        ImageIcon fondo = new ImageIcon(getClass().getResource("/SmarTree/Imagenes/Fondo.png"));
        g.drawImage(fondo.getImage(), 0, 0, tamaño.width, tamaño.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }
    
    /**
     * Method to capture the enter key pressed, allowing access to the system if the data is correct.
     * @param evt allows you to create the event of the button, setting to do if they are clicked.
     */
    private void txtPasswordActionPerformed(ActionEvent evt) {                                            
        btnLoginActionPerformed(evt);
    }   
    
     /**
     * Method that cleans the text fields of the interface.
     */
    public void limpiarTextos(){
        txtUser.setText("");
        txtPassword.setText("");
        btnLogin.setEnabled(true);	 
    }
    
    /**
     * Method to enter the system if the entries are correct
     * @param evt creates the event that access to the system
     */
    private void btnLoginActionPerformed(ActionEvent evt) {                                         
 	String usuario = txtUser.getText();
 	char[] pass= txtPassword.getPassword();
        String clave = new String(pass);
        login.validar(usuario, clave);
        limpiarTextos();
    }
}
