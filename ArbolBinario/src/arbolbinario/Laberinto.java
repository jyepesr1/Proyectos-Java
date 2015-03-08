
package arbolbinario;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;
class Laberinto extends JFrame implements ActionListener {
    JLabel[][] l;
    JButton b1;  
    JButton b2;
    boolean salida;
    Stack pila = new Stack();
    
    Laberinto(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        l=new JLabel[10][10];
        for(int f=0;f<10;f++) {
            for(int c=0;c<10;c++) {
                l[f][c]=new JLabel();
                l[f][c].setBounds(45+c*20,50+f*20,20,20);
                add(l[f][c]);
            }
        }
        b1=new JButton("Recorrer");
        b1.setBounds(40,300,100,25);
        add(b1);
        b1.addActionListener(this);
        b2=new JButton("Crear");
        b2.setBounds(150,300,100,25);
        add(b2);
        b2.addActionListener(this);    
        crear();
    }
  
    public void crear()
    {
        for(int f=0;f<10;f++) {
            for(int c=0;c<10;c++) {
                int a=(int)(Math.random()*4);
                l[f][c].setForeground(Color.black);
                if (a==0)
                    l[f][c].setText("1");
                else
                    l[f][c].setText("0");  
            }
        }
        int f = (int)(Math.random()*10);
        int c = (int)(Math.random()*10);
        l[f][c].setText("M");
        l[f][c].setForeground(Color.red);
        l[0][0].setText("0");

        
    }
  
    public void recorrer(int fil,int col)
    {
        if (fil>=0 && fil<l.length && col>=0 && col<l.length && salida==false) {
            if(l[1][0].getText().equals("s")) salida = true;
            if (l[fil][col].getText().equals("s")) 
                salida=true;
            else
                if (l[fil][col].getText().equals("0")) {
                    l[fil][col].setText("■");
                    l[fil][col].setForeground(Color.red);
                    recorrer(fil,col+1);
                    recorrer(fil+1,col);
                    recorrer(fil-1,col);
                    recorrer(fil,col-1);
                }          
        }
    }
  
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==b1) {
            salida=false;
            recorrer(0,0);
            if (salida)
                setTitle("Tiene salida");
            else
                setTitle("No tiene salida");  
        }
        if (e.getSource()==b2)
            crear();
    }
  
    public static void main(String[] ar)
    {
        Laberinto l=new Laberinto();
        l.setBounds(0,0,300,400);
        l.setVisible(true);
    }
}