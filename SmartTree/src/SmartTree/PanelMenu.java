
package SmartTree;

import DescriptionTrees.FrameDescription;
import CollectAndGraph.FrameVariables;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import StaticMaps.Maps;

/**
 * This Class contains the three principal buttons Description, Collect Variables, Static Map.
 * @author Michell Pineda
 */
public class PanelMenu extends JPanel{
    private final JLabel lblFondo;
    private final JButton btnGraph;    
    private final JButton btnMaps;
    private final JButton btnDescription;
    private final JButton btnReturn;
    private final ImageIcon fondo;
    private final Menu menu;
    
    /**
     * Constructor of PanelMenu that sets the values of variables.
     * @param m 
     */
    public PanelMenu(Menu m){
        
        setPreferredSize(new Dimension(500,400));
        setVisible(true);
        setLayout(null);
        setBackground(Color.WHITE);
        
        fondo =  new ImageIcon(getClass().getResource("/SmarTree/Imagenes/LogoMenu.png"));
        lblFondo = new JLabel();
        lblFondo.setIcon(fondo);
        btnGraph = new JButton("Collect Variables");
        btnMaps = new JButton("Static Map");
        btnDescription = new JButton("Description");
        btnReturn = new JButton("Log Out");
        
        lblFondo.setBounds(140, 30, 200, 140);
        add(lblFondo);      
        
        btnGraph.setBounds(150, 220, 190, 80);
        btnGraph.setBackground(new java.awt.Color(56, 124, 53));
        btnGraph.setForeground(Color.WHITE);
        btnGraph.setFont(new java.awt.Font("Futura Md BT", 1, 14));
        add(btnGraph);
        
        btnMaps.setBounds(350, 220, 130, 80);
        btnMaps.setBackground(new java.awt.Color(56, 124, 53));
        btnMaps.setForeground(Color.WHITE);        
        btnMaps.setFont(new java.awt.Font("Futura Md BT", 1, 14)); 
        add(btnMaps);
        
        btnDescription.setBounds(10, 220, 130, 80);
        btnDescription.setBackground(new java.awt.Color(56, 124, 53));
        btnDescription.setForeground(Color.WHITE);
        btnDescription.setFont(new java.awt.Font("Futura Md BT", 1, 14)); 
        add(btnDescription);
        
        btnReturn.setBounds(190, 320, 100, 30);
        btnReturn.setBackground(Color.WHITE); 
        btnReturn.setForeground(new java.awt.Color(56, 124, 53));
        btnReturn.setFont(new java.awt.Font("Futura Md BT", 1, 14));
        add(btnReturn);
        
        menu = m;
        
         btnGraph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnGraphActionPerformed(evt);
            }
        });
         
         btnMaps.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnMapsActionPerformed(evt);
            }
        });
         
         btnDescription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnDescriptionActionPerformed(evt);
            }
        });
         
         btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
    
    }
    
    /**
     * Method that allows access to the function of obtaining graphs
     * @param evt make the event button to access the function to get the graphic
     */
    private void btnGraphActionPerformed(ActionEvent evt) {                                         
        FrameVariables p = new FrameVariables();
        p.setVisible(true);
        menu.dispose();
    }  
    
    /**
     * Method that allows access to the function of obtaining maps
     * @param evt make the event button to access the function maps
     */
    private void btnMapsActionPerformed(ActionEvent evt) {                                       
        Maps w = new Maps();
        w.setVisible(true);
        menu.dispose();
        
    } 
    
    /**
     * Method that allows access to the function of obtaining the description of trees
     * @param evt make the event button to access the function to get a description of the trees
     */
    private void btnDescriptionActionPerformed(ActionEvent evt) {                                            
        FrameDescription l = new FrameDescription();
        l.setVisible(true);
        menu.dispose();
    }

    /**
     * Method to return to the menu
     * @param evt make the event button returns you to menu
     */
    private void btnReturnActionPerformed(ActionEvent evt) {                                    
        Login i = new Login();
        i.setVisible(true);
        menu.dispose();
    }                              
}
