
package StaticMaps;

import SmartTree.Menu;
import CollectAndGraph.Paquete;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;

/**
 * This Class contains all variables and functionalities for create a new Map.
 * @author Michell Pineda
 */
public class PanelMaps extends JPanel{
    
    private final StaticMaps ObjStaticMaps = new StaticMaps();
    private final JSlider zoom;
    private final JScrollPane scrollMap;
    private final JLabel lblZoom2;
    private final JLabel lblType;
    private final JLabel lblVariables;
    private final JLabel lblImage;
    private final JLabel lblZoom;
    private final JComboBox cbType;
    private final JButton btnVariables;
    private final JButton btnMap;
    private final JButton btnReturn;
    private final Maps mapa;
    
    /**
     *Create an object of the class Static Maps
     */
    private Paquete dato;
    
    public PanelMaps(Maps map){
        
        setPreferredSize(new Dimension(500,400));
        setVisible(true);
        setLayout(null);
        setBackground(Color.WHITE);
        
        zoom = new JSlider();
        scrollMap = new JScrollPane();
        lblZoom = new JLabel("Zoom");
        lblType = new JLabel("Map Type");
        lblVariables = new JLabel("Return Variables");
        lblImage = new JLabel("Static Map");
        lblZoom2 = new JLabel("10", SwingConstants.CENTER);
        cbType = new JComboBox();
        btnVariables = new JButton("View");
        btnMap = new JButton("Create Map");
        btnReturn = new JButton("Return");
        
        
        lblZoom.setFont(new java.awt.Font("Futura Md BT", 0, 12));
        lblZoom.setBounds(20, 20, 100, 20);
        add(lblZoom);
        
        zoom.setValue(10);
        zoom.setMinimum(1);
        zoom.setMaximum(20);
        zoom.setPaintTicks(true);
        zoom.setBounds(60, 25, 390, 20);
        zoom.setForeground(new java.awt.Color(121, 156, 40));
        zoom.setBackground(new java.awt.Color(255, 255, 255));
        zoom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(zoom);
        
        lblZoom2.setFont(new java.awt.Font("Futura Md BT", 0, 12));
        lblZoom2.setBounds(450, 20, 30, 20);
        lblZoom2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 124, 53)));
        add(lblZoom2);
        
        lblType.setFont(new java.awt.Font("Futura Md BT", 0, 12));
        lblType.setBounds(310, 50, 100, 20);
        add(lblType);
        
        cbType.setFont(new java.awt.Font("Futura Md BT", 0, 12));
        cbType.setBounds(390, 50, 90, 20);
	cbType.addItem("roadmap");
	cbType.addItem("satellite");
	cbType.addItem("hybrid");
	cbType.addItem("terrain");
        add(cbType);
        
        lblVariables.setFont(new java.awt.Font("Futura Md BT", 0, 12));
        lblVariables.setBounds(20, 50, 100, 20);
        add(lblVariables);
        
        btnVariables.setBackground(new java.awt.Color(255, 255, 255));
        btnVariables.setFont(new java.awt.Font("Futura Md BT", 0, 14));
        btnVariables.setForeground(new java.awt.Color(56, 124, 53));
        btnVariables.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(56, 124, 53)));
        btnVariables.setBounds(130, 50, 90, 20);
        add(btnVariables);
        
        
        lblImage.setBackground(new java.awt.Color(255, 255, 255));
        lblImage.setFont(new java.awt.Font("Futura Md BT", 0, 12)); 
        lblImage.setHorizontalAlignment(SwingConstants.CENTER);
        lblImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 124, 53)));
        lblImage.setOpaque(true);
        lblImage.setBounds(10, 80, 480, 240);
        scrollMap.setBounds(10, 80, 480, 240);
        scrollMap.setViewportView(lblImage);
        add(scrollMap);

        btnMap.setBackground(new java.awt.Color(56, 124, 53));
        btnMap.setFont(new java.awt.Font("Futura Md BT", 1, 14));
        btnMap.setForeground(new java.awt.Color(255, 255, 255));
        btnMap.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 124, 53)));
        btnMap.setBounds(70, 330, 120, 30);
        btnMap.setEnabled(false);
        add(btnMap);
        
        btnReturn.setBackground(new java.awt.Color(56, 124, 53));
        btnReturn.setFont(new java.awt.Font("Futura Md BT", 1, 14)); 
        btnReturn.setForeground(new java.awt.Color(255, 255, 255));
        btnReturn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 124, 53)));
        btnReturn.setBounds(320, 330, 120, 30);
        add(btnReturn);
        
        mapa = map;
        
        btnVariables.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnVariablesActionPerformed(evt);
            }
        });
               
        btnMap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnMapActionPerformed(evt);
            }
        });
        
        btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        
        
        zoom.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                zoomStateChanged(evt);
            }
        });
        
    }
   
     /**
     * Method that manages to capture the mouse click, allowing the main menu.
     * @param evt returns the button event.
     */
    public void btnReturnActionPerformed(ActionEvent evt) {                                          
        Menu m = new Menu();
        m.setVisible(true);
        mapa.dispose();
    }                                         

    /**
     * Method that manages to capture the mouse click, allowing you to create a map that will be seen by the user.
     * @param evt returns the event of the button, allowing you to create the map
     */
    public void btnMapActionPerformed(ActionEvent evt) {                                                  
        JOptionPane.showMessageDialog(null, "¡Remember that you need an Internet Conection\nfor Generate the Map!, Thanks", "Warning", JOptionPane.WARNING_MESSAGE);
        try {
            crearMapa();
        } catch (MalformedURLException | UnsupportedEncodingException ex) {
            JOptionPane.showMessageDialog(null, "An Error has Ocurred, Please Try Again", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }                                                 

    /**
     * Method to capture the event of a slider, setting a parameter of type integer to decide how close or far the map will look.
     * @param evt returns an integer value, setting the zoom map.
     */
    public void zoomStateChanged(ChangeEvent evt) {                                             
        lblZoom2.setText(String.valueOf(zoom.getValue()));
    }                                            

    /**
     * Method to capture the mouse click, allowing you to see the tags on the interface variables.  
     * @param evt button returns the event data showing the class variables
     */
    public void btnVariablesActionPerformed(ActionEvent evt) {                                             
         try{
            try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("objetos.obj"))) {
                dato = (Paquete) entrada.readObject();
                JOptionPane.showMessageDialog(null, dato);
            }
        }catch(IOException | ClassNotFoundException | HeadlessException e){
            JOptionPane.showMessageDialog(null, "The File could not be Read", "Error", JOptionPane.ERROR_MESSAGE);
        }
         btnMap.setEnabled(true);
    } 
    
    
    /**
     * This method returns the type of map that the user chooses through the JComboBox.
     * @return returns the type of map, either RoadMap, Satellite, Hybrid or Terrain.
     */
    public StaticMaps.Maptype seleccionarTipoMapa(){
        StaticMaps.Maptype tipoMapa= StaticMaps.Maptype.roadmap;
        switch(cbType.getSelectedItem().toString()){
            case "roadmap":
                tipoMapa= StaticMaps.Maptype.roadmap;
                break;
            case "satellite":
                tipoMapa= StaticMaps.Maptype.satellite;
                break;
            case "hybrid":
                tipoMapa= StaticMaps.Maptype.hybrid;
                break;
            case "terrain":
                tipoMapa= StaticMaps.Maptype.terrain;
                break;
        }
        return tipoMapa;
    }
    
    /**
     * This method is responsible for creating the image of the map that the user will observe.
     * @throws MalformedURLException
     * @throws UnsupportedEncodingException 
     */
    public void crearMapa() throws MalformedURLException, UnsupportedEncodingException{
        lblImage.setText("");
        Image imagenMapa;
        imagenMapa = ObjStaticMaps.getStaticMap(dato.getCoordenadas(),
                Integer.valueOf(lblZoom2.getText()),new Dimension(700,300),
                seleccionarTipoMapa());
        if(imagenMapa!=null){
            ImageIcon imgIcon = new ImageIcon(imagenMapa);
            Icon iconImage=(Icon)imgIcon;
            lblImage.setIcon(iconImage);
        }
    }
    
    /**
     * This method allows to create the image of the map of each Tree of Frame Description.
     * @param coordenadas
     * @throws MalformedURLException
     * @throws UnsupportedEncodingException 
     */
    public void crearMapaArbol(String coordenadas) throws MalformedURLException, UnsupportedEncodingException{
        this.lblImage.setText("");
        Image imagenMapa=ObjStaticMaps.getStaticMap(coordenadas,
                 15,new Dimension(700,300),StaticMaps.Maptype.hybrid);
        if(imagenMapa!=null){
            ImageIcon imgIcon=new ImageIcon(imagenMapa);
            Icon iconImage=(Icon)imgIcon;
            lblImage.setIcon(iconImage);
        }
    } 
}
