package DescriptionTrees;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import StaticMaps.StaticMaps;
import StaticMaps.Maps;
import SmartTree.Menu;

/**
 * This class lets you create a description of four trees and see them on a map.
 * @author Alejandra Cardenas
 */
public class PanelDescription extends JPanel{
    
    private final JButton btnOpen1;
    private final JButton btnOpen2;
    private final JButton btnOpen3;
    private final JButton btnOpen4;
    private final JButton btnViewMap1;
    private final JButton btnViewMap2;
    private final JButton btnViewMap3;
    private final JButton btnViewMap4;
    private final JButton btnSave1;
    private final JButton btnSave2;
    private final JButton btnSave3;
    private final JButton btnSave4;
    private final JButton btnReturn;
    private final String infoArbol1; 
    private final String infoArbol2;
    private final String infoArbol3; 
    private final String infoArbol4;
    private final JLabel lblImg1;
    private final JLabel lblImg2;
    private final JLabel lblImg3;
    private final JLabel lblImg4;
    private final JScrollPane scrolPanel1;
    private final JScrollPane scrolPanel2;
    private final JScrollPane scrolPanel3;
    private final JScrollPane scrolPanel4;
    private final JTextArea txtInfoArbol1;
    private final JTextArea txtInfoArbol2;
    private final JTextArea txtInfoArbol3;
    private final JTextArea txtInfoArbol4;
    private final double latitudArbol1;
    private final double longitudArbol1;
    private final double latitudArbol2;
    private final double longitudArbol2;
    private final double latitudArbol3;
    private final double longitudArbol3;
    private final double latitudArbol4;
    private final double longitudArbol4;
    private final StaticMaps ObjStaticMaps;
    private Maps mapa;
    private  final FrameDescription frame;
    
    /**
     * Constructor of Panel that sets all values of variables.
     * @param frame 
     */
    public PanelDescription(FrameDescription frame){
        setPreferredSize(new Dimension(400,500));
        setBackground(Color.WHITE);
        setVisible(true);
        setLayout(null);
        
        ObjStaticMaps=new StaticMaps();
        
        latitudArbol1 = 4.5981000; 
        longitudArbol1 = -74.07603007;
        latitudArbol2 = 6.3042370;
        longitudArbol2 = -75.5593290;
        latitudArbol3 =  6.2060610;
        longitudArbol3 = -75.5545990;
        latitudArbol4 = 6.3421750;
        longitudArbol4 = -75.5757020;
        btnSave1 = new JButton("Save");
        btnSave2 = new JButton("Save");
        btnSave3 = new JButton("Save");
        btnSave4 = new JButton("Save");
        btnOpen1 = new JButton("Open");
        btnOpen2 = new JButton("Open");
        btnOpen3 = new JButton("Open");
        btnOpen4 = new JButton("Open");
        btnViewMap1 = new JButton("View Map");
        btnViewMap2 = new JButton("View Map");
        btnViewMap3 = new JButton("View Map");
        btnViewMap4 = new JButton("View Map");
        btnReturn = new JButton("Return");
        lblImg1 = new JLabel();
        lblImg2 = new JLabel();
        lblImg3 = new JLabel();
        lblImg4 = new JLabel();
        scrolPanel1 = new JScrollPane();
        scrolPanel2 = new JScrollPane();
        scrolPanel3 = new JScrollPane();
        scrolPanel4 = new JScrollPane();
        txtInfoArbol1 = new JTextArea();
        txtInfoArbol2 = new JTextArea();
        txtInfoArbol3 = new JTextArea();
        txtInfoArbol4 = new JTextArea();
        infoArbol1 = "-Nombre científico: Abies excelsa Poir.\n-Nombre común: Abeto rojo, Arbol de Navidad.\n-Ubicación: Latitud: "+latitudArbol1+", Longitud: "+longitudArbol1+"\n-Descripción: El género Abies comprende 40 especies \nextendidas en las regiones templadas de Asia, América \ndel Norte, Norte de África y Sur de Europa. \nEl abeto rojo más alto mide, 63 m, se encuentra en bosque \nvirgen de Perućica, en el Parque Nacional Sutjeska, \nBosnia-Herzegovina.";
        infoArbol2 = "-Nombre científico: Ceratonia siliqua L.\n-Nombre común: Algarrobo, Garrofera, Garrofo, \nGarrofero, Algarrobera.\n-Ubicación: Latitud: "+latitudArbol2+", Longitud: "+longitudArbol2+"\n-Descripción: Arbusto grande perennifolio o árbol de \nhasta 10 m de altura; caracteristico del Mediterraneo. \nViene de la familia Caesalpiniaceae (Leguminosae).";
        infoArbol3 = "-Nombre científico: Pinus pinea L.\n-Nombre común: Pino piñonero, Pino parasol, \nPino doncel, Pino real.\n-Ubicación: Latitud: "+latitudArbol3+", Longitud: "+longitudArbol3+"\n-Descripción: Su origen es de la Región Mediterránea. \nViene de la familia Pinaceae. Su crecimiento es lento \npero es un árbol de gran longevidad, puede llegar a \nvivir hasta 500 años.";
        infoArbol4 = "-Nombre científico: Nyssa sylvatica Marshall.\n-Nombre común: Tupelo.\n-Ubicación: Latitud: "+latitudArbol4+", Longitud: "+longitudArbol4+"\n-Descripción: Su origen es del  Este de América del \nNorte. Viene de la familia Nyssaceae. Sus hojas son \nelípticas de color verde oscuro brillante volviéndose \ncarmín en otoño. Tolera casi toda clases de suelos, \nde ácidos a alcalinos y de húmedos a secos.";
        
            //--------------Arbol 1 --------------------------------        
        txtInfoArbol1.setBorder(BorderFactory.createLineBorder(new Color(56, 124, 53)));
        txtInfoArbol1.setText(infoArbol1);
        txtInfoArbol1.setEditable(true);
        scrolPanel1.setViewportView(txtInfoArbol1);
        scrolPanel1.setBounds(105, 20, 280, 150);
        add(scrolPanel1);
       
        lblImg1.setIcon(new ImageIcon(getClass().getResource("/SmarTree/Imagenes/Tree1.jpg")));
        lblImg1.setBounds(10, 20, 200, 120);
        add(lblImg1);
        
        btnViewMap1.setBounds(105, 180, 90, 20);
        btnViewMap1.setBackground(new java.awt.Color(255, 255, 255));
        btnViewMap1.setFont(new java.awt.Font("Futura Md BT", 0, 14));
        btnViewMap1.setForeground(new java.awt.Color(56, 124, 53));
        btnViewMap1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(56, 124, 53)));
        btnViewMap1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                mapa(e, latitudArbol1, longitudArbol1);
            }
        });
        add(btnViewMap1);
 
        btnOpen1.setBounds(200, 180, 90, 20);
        btnOpen1.setBackground(new java.awt.Color(255, 255, 255));
        btnOpen1.setFont(new java.awt.Font("Futura Md BT", 0, 14));
        btnOpen1.setForeground(new java.awt.Color(56, 124, 53));
        btnOpen1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(56, 124, 53)));
        btnOpen1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                openFile(e, txtInfoArbol1);
            }
        });
        add(btnOpen1);
        
        btnSave1.setBounds(295, 180, 90, 20);
        btnSave1.setBackground(new java.awt.Color(255, 255, 255));
        btnSave1.setFont(new java.awt.Font("Futura Md BT", 0, 14));
        btnSave1.setForeground(new java.awt.Color(56, 124, 53));
        btnSave1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(56, 124, 53)));
        btnSave1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                saveFile(e, txtInfoArbol1);
            }
        });
        add(btnSave1);
        
        //----------------------------Arbol 2-----------------------------------
        
        txtInfoArbol2.setBorder(BorderFactory.createLineBorder(new Color(56, 124, 53)));
        txtInfoArbol2.setText(infoArbol2);
        txtInfoArbol2.setEditable(true);
        scrolPanel2.setViewportView(txtInfoArbol2);
        scrolPanel2.setBounds(105, 230, 280, 150);
        add(scrolPanel2);
       
        lblImg2.setIcon(new ImageIcon(getClass().getResource("/SmarTree/Imagenes/Tree2.jpg")));
        lblImg2.setBounds(10, 245, 200, 120);
        add(lblImg2);
        
        btnViewMap2.setBounds(105, 390, 90, 20);
        btnViewMap2.setBackground(new java.awt.Color(255, 255, 255));
        btnViewMap2.setFont(new java.awt.Font("Futura Md BT", 0, 14));
        btnViewMap2.setForeground(new java.awt.Color(56, 124, 53));
        btnViewMap2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(56, 124, 53)));
        btnViewMap2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                mapa(e, latitudArbol2, longitudArbol2);
            }
        });
        add(btnViewMap2);

        btnOpen2.setBounds(200, 390, 90, 20);
        btnOpen2.setBackground(new java.awt.Color(255, 255, 255));
        btnOpen2.setFont(new java.awt.Font("Futura Md BT", 0, 14));
        btnOpen2.setForeground(new java.awt.Color(56, 124, 53));
        btnOpen2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(56, 124, 53)));
        btnOpen2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                openFile(e, txtInfoArbol2);
            }
        });
        add(btnOpen2);
        
        btnSave2.setBounds(295, 390, 90, 20);
        btnSave2.setBackground(new java.awt.Color(255, 255, 255));
        btnSave2.setFont(new java.awt.Font("Futura Md BT", 0, 14));
        btnSave2.setForeground(new java.awt.Color(56, 124, 53));
        btnSave2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(56, 124, 53)));
        btnSave2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                saveFile(e, txtInfoArbol2);
            }
        });
        add(btnSave2);
        
        //----------------------------Arbol 3---------------------------------
        
        txtInfoArbol3.setBorder(BorderFactory.createLineBorder(new Color(56, 124, 53)));
        txtInfoArbol3.setText(infoArbol3);
        txtInfoArbol3.setEditable(true);
        scrolPanel3.setViewportView(txtInfoArbol3);
        scrolPanel3.setBounds(500, 20, 280, 150);
        add(scrolPanel3);
       
        lblImg3.setIcon(new ImageIcon(getClass().getResource("/SmarTree/Imagenes/Tree3.jpg")));
        lblImg3.setBounds(400, 20, 200, 120);
        add(lblImg3);
        
        btnViewMap3.setBounds(500, 180, 90, 20);
        btnViewMap3.setBackground(new java.awt.Color(255, 255, 255));
        btnViewMap3.setFont(new java.awt.Font("Futura Md BT", 0, 14));
        btnViewMap3.setForeground(new java.awt.Color(56, 124, 53));
        btnViewMap3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(56, 124, 53)));
        btnViewMap3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                mapa(e, latitudArbol3, longitudArbol3);
            }
        });
        add(btnViewMap3);
  
        btnOpen3.setBounds(595, 180, 90, 20);
        btnOpen3.setBackground(new java.awt.Color(255, 255, 255));
        btnOpen3.setFont(new java.awt.Font("Futura Md BT", 0, 14));
        btnOpen3.setForeground(new java.awt.Color(56, 124, 53));
        btnOpen3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(56, 124, 53)));
        btnOpen3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                openFile(e, txtInfoArbol3);
            }
        });
        add(btnOpen3);
        
        btnSave3.setBounds(690, 180, 90, 20);
        btnSave3.setBackground(new java.awt.Color(255, 255, 255));
        btnSave3.setFont(new java.awt.Font("Futura Md BT", 0, 14));
        btnSave3.setForeground(new java.awt.Color(56, 124, 53));
        btnSave3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(56, 124, 53)));
        btnSave3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                saveFile(e, txtInfoArbol3);
            }
        });
        add(btnSave3);
        
        //---------------------------Arbol 4----------------------------------------------
        
        txtInfoArbol4.setBorder(BorderFactory.createLineBorder(new Color(56, 124, 53)));
        txtInfoArbol4.setText(infoArbol4);
        txtInfoArbol4.setEditable(true);
        scrolPanel4.setViewportView(txtInfoArbol4);
        scrolPanel4.setBounds(500, 235, 280, 150);
        add(scrolPanel4);
       
        lblImg4.setIcon(new ImageIcon(getClass().getResource("/SmarTree/Imagenes/Tree4.jpg")));
        lblImg4.setBounds(400, 245, 200, 120);
        add(lblImg4);
        
        btnViewMap4.setBounds(500, 390, 90, 20);
        btnViewMap4.setBackground(new java.awt.Color(255, 255, 255));
        btnViewMap4.setFont(new java.awt.Font("Futura Md BT", 0, 14));
        btnViewMap4.setForeground(new java.awt.Color(56, 124, 53));
        btnViewMap4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(56, 124, 53)));
        btnViewMap4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                mapa(e, latitudArbol4, longitudArbol4);
            }
        });
        add(btnViewMap4);
        
        btnOpen4.setBounds(595, 390, 90, 20);
        btnOpen4.setBackground(new java.awt.Color(255, 255, 255));
        btnOpen4.setFont(new java.awt.Font("Futura Md BT", 0, 14));
        btnOpen4.setForeground(new java.awt.Color(56, 124, 53));
        btnOpen4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(56, 124, 53)));
        btnOpen4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                openFile(e, txtInfoArbol4);
            }
        });
        add(btnOpen4);
        
        btnSave4.setBounds(690, 390, 90, 20);
        btnSave4.setBackground(new java.awt.Color(255, 255, 255));
        btnSave4.setFont(new java.awt.Font("Futura Md BT", 0, 14));
        btnSave4.setForeground(new java.awt.Color(56, 124, 53));
        btnSave4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(56, 124, 53)));
        btnSave4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                saveFile(e, txtInfoArbol4);
            }
        });
        add(btnSave4);
        
        //------------------------------------------------------------
        
        btnReturn.setBounds(350, 435, 120, 30);
        btnReturn.setBackground(new java.awt.Color(56, 124, 53));
        btnReturn.setFont(new java.awt.Font("Futura Md BT", 1, 14)); 
        btnReturn.setForeground(new java.awt.Color(255, 255, 255));
        btnReturn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 124, 53)));
        btnReturn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Return(e);
            }
        });
        add(btnReturn);
       
        this.frame = frame;
        
    }

    /**
     * This Method creates a new Frame of Maps with coordenates like parameters. 
    * @param e
     * @param lati
     * @param longi 
     */
     public void mapa(ActionEvent e, double lati, double longi){
       String coordenadas = lati+","+longi;
       mapa = new Maps();
       mapa.setVisible(true);
       mapa.crearMapa(coordenadas);
    }

     /**
      * This Method allows to back to menu.
      * @param e 
      */
    public void Return(ActionEvent e){
        Menu m = new Menu();
        m.setVisible(true);
        frame.dispose(); 
    } 

    /**
     * This Method allows to save the information that contains each JTextArea on a Desktop.
     * @param e
     * @param txtArea 
     */
    public void saveFile(ActionEvent e, JTextArea txtArea){
        if(txtArea.getText().equals("")){
            JOptionPane.showMessageDialog(null, "The Text Area is Empty, Please type a text.", "Warning", JOptionPane.WARNING_MESSAGE);
        }else{
            try{
                JFileChooser archivo = new JFileChooser(System.getProperty("user.dir"));
                archivo.showSaveDialog(this);
                File GUARDAR = archivo.getSelectedFile();
                if(GUARDAR != null){
                    try (FileWriter GUARDADO = new FileWriter(GUARDAR)) {
                        GUARDADO.write(txtArea.getText());
                    }
                }
            }catch(IOException exp){
                JOptionPane.showMessageDialog(null, "An Error has Ocurred, Please Try Again", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /**
     * This Method allows to open file that contains the information of each JTextArea of the Trees.
     * @param e
     * @param txtArea 
     */
    public void openFile(ActionEvent e, JTextArea txtArea) {
        try {
           String TEXTO;
           JFileChooser archivo = new JFileChooser(System.getProperty("user.dir"));
           archivo.showOpenDialog(this);
           File ABRIR=archivo.getSelectedFile();

           if(ABRIR != null){
                txtArea.setText("");
                FileReader FICHERO = new FileReader(ABRIR);
                try (BufferedReader LEER = new BufferedReader(FICHERO)) {
                    while((TEXTO = LEER.readLine()) != null) {
                       txtArea.append(TEXTO+ "\n");
                    }
                }
            }
        }catch(HeadlessException | IOException exp) {
                JOptionPane.showMessageDialog(null, "El archivo no existe o no se encuentra en esta carpeta.","Error", JOptionPane.WARNING_MESSAGE);
        }
    }
}
    
   
