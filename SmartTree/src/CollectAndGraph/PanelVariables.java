
package CollectAndGraph;

import SmartTree.Menu;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;

/**
 * This Class allows to see the Variables Panel.
 * @author Johan Yepes
 */
public class PanelVariables extends JPanel{
     
    private final JButton btnReset;
    private final JButton btnPause;
    private final JButton btnStart;
    private final JButton btnStop;
    private final JButton btnValores;
    private final JButton btngraficar;
    private final JButton btnBack; 
    private final JButton btnReturn;
    private final JLabel count;
    private final JLabel resultado;
    private final JSlider slider;
    private final Timer timer;
    private int min, seg;
    private int valor;
    private String valorFinal;
    private final JLabel infoCoordinates;
    private final JTextField latitude;
    private final JLabel lblLatitude;
    private final JLabel lblLength;
    private final JLabel lblTimer;
    private final JLabel lblVariable;
    private final JTextField length;
    private final JRadioButton rbtnHumedad;
    private final JRadioButton rbtnRuido;
    private final JRadioButton rbtnTemperatura;
    private final ButtonGroup grupoBotones;
    private String tipoVariable;
    private int ultimoValor;
    private double latitud;
    private double longitud;
    private final FrameVariables frame;
    private Paquete datos;
    
    /**
     * Constructor of PanelVariables().
     * @param frame
     */
    public PanelVariables(FrameVariables frame){

        btnReset = new JButton("Reset");
        btnPause = new JButton("Pause");
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");
        btngraficar = new JButton("Generate Plot");
        btnValores = new JButton("Save Values");
        btnBack = new JButton("See variables");
        btnReturn = new JButton("Return");
        count = new JLabel("00:00");
        resultado = new JLabel("0");
        slider = new JSlider();
        timer = new Timer(1000, accionesContador);  
        rbtnTemperatura = new JRadioButton("Temperature");
        rbtnRuido = new JRadioButton("Moisture");
        rbtnHumedad = new JRadioButton("Noise");
        latitude = new JTextField("6.201513");    
        length = new JTextField("-75.578451");
        infoCoordinates = new JLabel("Please, Type the Coordinates of the Site");
        lblLatitude = new JLabel("Latitude:");
        lblLength = new JLabel("Length:");
        lblTimer = new JLabel("Timer:");
        lblVariable = new JLabel("Variable:");
        grupoBotones = new ButtonGroup();
        this.frame = frame;
        
        setPreferredSize(new Dimension(500, 400));
        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);
        
          
        grupoBotones.add(rbtnTemperatura);
        grupoBotones.add(rbtnHumedad);
        grupoBotones.add(rbtnRuido);
        
        rbtnTemperatura.setSelected(true);
        rbtnTemperatura.setBounds(90, 10, 100, 30);
        rbtnTemperatura.setBackground(new java.awt.Color(255, 255, 255));
        add(rbtnTemperatura);
        
        rbtnHumedad.setBounds(220, 10, 100, 30);
        rbtnHumedad.setBackground(new java.awt.Color(255, 255, 255));
        add(rbtnHumedad);
        
        rbtnRuido.setBounds(320, 10, 100, 30);
        rbtnRuido.setBackground(new java.awt.Color(255, 255, 255));
        add(rbtnRuido);
        
        slider.setBackground(new java.awt.Color(255, 255, 255));
        slider.setBounds(10, 50, 470, 40);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(2);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setValue(10);
        slider.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(slider);
        
        btnStart.setFont(new Font("Futura Md ", 1, 14));
        btnStart.setBounds(10, 110, 160, 25);
        btnStart.setBackground(new java.awt.Color(255, 255, 255));
        btnStart.setForeground(new java.awt.Color(56, 124, 53));
        btnStart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 124, 53)));
        add(btnStart);
        
        btnPause.setEnabled(false);
        btnPause.setFont(new Font("Futura Md", 1, 14));
        btnPause.setBounds(10, 145, 160, 25);
        btnPause.setBackground(new java.awt.Color(255, 255, 255));
        btnPause.setForeground(new java.awt.Color(56, 124, 53));
        btnPause.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 124, 53)));
        add(btnPause);
          
        btnStop.setEnabled(false);
        btnStop.setFont(new Font("Futura Md", 1, 14));
        btnStop.setBounds(10, 180, 160, 25);
        btnStop.setBackground(new java.awt.Color(255, 255, 255));
        btnStop.setForeground(new java.awt.Color(56, 124, 53));
        btnStop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 124, 53)));
        add(btnStop);
        
        btnReset.setFont(new Font("Futura Md", 1, 14));
        btnReset.setBounds(10, 215, 160, 25);
        btnReset.setBackground(new java.awt.Color(255, 255, 255));
        btnReset.setForeground(new java.awt.Color(56, 124, 53));
        btnReset.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 124, 53)));
        add(btnReset);
            
        btnValores.setFont(new Font("Futura Md Bt", 1, 14));
        btnValores.setBounds(10, 250, 160, 25);
        btnValores.setBackground(new java.awt.Color(255, 255, 255));
        btnValores.setForeground(new java.awt.Color(56, 124, 53));
        btnValores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 124, 53)));
        add(btnValores);
        
        btnBack.setFont(new Font("Futura Md Bt", 1, 14));
        btnBack.setBounds(10, 285, 160, 25);
        btnBack.setEnabled(false);
        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setForeground(new java.awt.Color(56, 124, 53));
        btnValores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 124, 53)));
        add(btnBack);
        
        infoCoordinates.setFont(new Font("Futura Md ", 1, 14));
        infoCoordinates.setBounds(190, 100, 300, 40);
        add(infoCoordinates);
        
        lblLatitude.setFont(new Font("Futura Md ", 1, 14));
        lblLatitude.setBounds(220, 145, 300, 30);
        add(lblLatitude);
        
        latitude.setFont(new Font("Futura Md ", 1, 14));
        latitude.setBounds(220, 180, 100, 30);
        add(latitude);
        
        lblLength.setFont(new Font("Futura Mdt", 1, 14));
        lblLength.setBounds(360, 145, 100, 30);
        add(lblLength);
        
        length.setFont(new Font("Futura Md ", 1, 14));
        length.setBounds(360, 180, 100, 30);
        add(length);
        
        lblTimer.setFont(new Font("Futura Md ", 1, 14));
        lblTimer.setBounds(220, 225, 300, 30);
        add(lblTimer);
        
        count.setHorizontalAlignment(SwingConstants.CENTER);
        count.setFont(new Font("Futura Md Bt", 1, 18)); 
        count.setBounds(200, 255, 100, 40);
        add(count);
        
        lblVariable.setFont(new Font("Futura Md Bt", 1, 14));
        lblVariable.setBounds(360, 225, 300, 30);
        add(lblVariable);
        
        resultado.setHorizontalAlignment(SwingConstants.CENTER);
        resultado.setFont(new Font("Futura Md Bt", 1, 18));
        resultado.setBounds(350, 255, 100, 40);
        add(resultado);
        
        btnReturn.setFont(new Font("Futura Md Bt", 1, 14));
        btnReturn.setBounds(10,325,160,30);
        btnReturn.setBackground(new java.awt.Color(56, 124, 53));
        btnReturn.setForeground(new java.awt.Color(255, 255, 255));
        add(btnReturn);
        
        
        btngraficar.setFont(new Font("Futura Md Bt", 1, 14));
        btngraficar.setEnabled(false);
        btngraficar.setBounds(270,325,140,30);
        btngraficar.setBackground(new java.awt.Color(56, 124, 53));
        btngraficar.setForeground(new java.awt.Color(255, 255, 255));
        add(btngraficar);
            
                           
        TitledBorder border = BorderFactory.createTitledBorder("Variables");
        setBorder(border);
        // </editor-fold> 


        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        btnPause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        btnValores.addActionListener(new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnValoresActionPerformed(evt);
            }         
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btngraficar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            btngraficarActionPerformed(evt);
        }
        });
        
        btnReturn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            btnReturnActionPerformed(evt);
        }
        });
        
        btnBack.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            btnBackActionPerformed(evt);
        }
        });

    }

    /**
     * This Method allows start the Timer.
     * @param evt 
     */
    public void btnStartActionPerformed(ActionEvent evt) {                                         
        timer.start();
        btnStart.setEnabled(false);
        btnPause.setEnabled(true);
        btnStop.setEnabled(true);
        btngraficar.setEnabled(true);
    }
    
    /**
     * This Method Pause the Timer if its is running.
     * @param evt 
     */
    public void btnPauseActionPerformed(ActionEvent evt) {                                         
        timer.stop();
        btnStart.setText("Continue");
        btnStart.setEnabled(true);
        btnPause.setEnabled(false);
    }

/**
 * This Method allows stop the Timer if its is paused.
 * @param evt
 */
    public void btnStopActionPerformed(ActionEvent evt) {                                        
       if(timer.isRunning()){
           JOptionPane.showMessageDialog(null, "Please, pause the Count First ");
       }else{
        btnStart.setText("Start");
        btnPause.setEnabled(false);
        btnStop.setEnabled(false);
        min=0;
        seg=0;
        actualizarLabel();
       }
    }                                       

    /**
     * This Method allows to save the Variables in a file.
     * @param evt
     */
    public void btnValoresActionPerformed(ActionEvent evt) {
        if (GuardarVariables.sizeOfColeccion()==-1) {
            JOptionPane.showMessageDialog(null, "You Don't Have Any Value to Save", "Alert", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                datosPaquete();
                datos = new Paquete(tipoVariable, ultimoValor, latitud, longitud);
                btnValores.setEnabled(false);    
                FileOutputStream out = new FileOutputStream("Objetos.obj");
                try (ObjectOutputStream objeto = new ObjectOutputStream(out)) {
                    objeto.writeObject(datos);
                }
            JOptionPane.showMessageDialog(null, "File Saved");
            } catch (IOException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, "The File could not be Saved"); 
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "You Don't Have Any Value to Save", "Alert", JOptionPane.WARNING_MESSAGE); 
            }
        }
        btnBack.setEnabled(true);
    } 

    /**
     * This Method allows to clean all options of Panel.
     * @param evt
     */
    public void btnClearActionPerformed(ActionEvent evt) {                                         
        GuardarVariables.clearColeccion();
        btnValores.setEnabled(true);
        slider.setValue(0);
        resultado.setText("0");
        latitude.setText("");
        length.setText("");
    }  
    
    /**
     * This Method allows to return to Menu.
     * @param evt
     */
    public void btnReturnActionPerformed(ActionEvent evt) {                                         
        Menu m = new Menu();
        m.setVisible(true);
        frame.dispose();
    }

    /**
     * This Method allows to create a Plot if you have some values storage.
     * @param evt
     */
    public void btngraficarActionPerformed(ActionEvent evt){
        if(GuardarVariables.sizeOfColeccion()==-1){
            JOptionPane.showMessageDialog(null, "You Don't Have Any Value to Graph", "Alert", JOptionPane.WARNING_MESSAGE);
        }else{
            FrameGrafica grafica = new FrameGrafica();
        }    
    }

    /**
     * This Method allows to read the information storaged of the variables.
     * @param evt
     */
     public void btnBackActionPerformed(ActionEvent evt){
        try{
            try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("Objetos.obj"))) {
                Paquete dato = (Paquete) entrada.readObject();
                JOptionPane.showMessageDialog(null, dato);
            }
        }catch(IOException | ClassNotFoundException | HeadlessException e){
            JOptionPane.showMessageDialog(null, "The File could not be Read", "Error", JOptionPane.ERROR_MESSAGE);
        }     
     }

    /**
     * This Method sets the value of timer.
     */
    public void actualizarLabel(){
        String tiempo = (min<=9?"0":"")+min+":"+(seg<=9?"0":"")+seg;
        count.setText(tiempo);
    }
    
    /**
     * This Method allows to save the information of variables.
     * @throws java.lang.Exception
     */
    public void datosPaquete() throws Exception{
        String lati;
        String longi;
        if(rbtnTemperatura.isSelected()){
            tipoVariable = rbtnTemperatura.getText();
        }else if(rbtnHumedad.isSelected()){
            tipoVariable = rbtnHumedad.getText();
        }else{
            tipoVariable = rbtnRuido.getText();
        }
        
       
        ultimoValor = GuardarVariables.getColeccionOfIndex(GuardarVariables.sizeOfColeccion()-1);
     
        
        lati = latitude.getText();
        latitud = Double.parseDouble(lati);
        
        longi = length.getText();
        longitud = Double.parseDouble(longi);
        
    }
    
    public String coordenadas(){
        return datos.getCoordenadas();
    }

    public final ActionListener accionesContador = new ActionListener() {
        @Override
        /**
         * This Method allows that the timer change its value each second.
         */
        public void actionPerformed(ActionEvent ae) {
            seg++;
            if(seg==60){
                seg=0;
                min++;
            }
            if(min==60){
                min=0;
            }
            actualizarLabel();
            valor = slider.getValue();
            valorFinal = Integer.toString(valor);
            resultado.setText(valorFinal);
            GuardarVariables.addToColeccion(valor);
            GuardarVariables.addToTiempo(seg);
        }
    };
};
    
