
package Laberinto;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Laberinto extends JFrame implements ActionListener{
	
    static final int MAX = 100;						//máximo número de filas y columnas del laberinto
    static JLabel ady[][] = new JLabel[MAX ][ MAX ];	//laberinto
    JButton b1;  
    JButton b2;
    int h , w , x = 0 , y = 0;

    Laberinto(int h, int w){
        this.h = h;
        this.w = w;
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        for(int f=0;f<h;f++) {
            for(int c=0;c<w;c++) {
                ady[f][c]=new JLabel();
                ady[f][c].setBounds(45+c*20,50+f*20,20,20);
                add(ady[f][c]);
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
        crearAleatorio();
    }

//        void crear(){
//                Scanner sc = new Scanner( System.in );
//		System.out.println("Ingrese el laberinto, con un solo valor inicial I, valor final sera S: ");
//		String line = sc.nextLine();			//funciona igual que getline o gets de c++
//		for (int i = 0; i < h ; ++i ) {
//			line = sc.nextLine();
//			for( int j = 0 ; j < w ; ++j ){
//                            Character c = line.charAt(j);
//                            ady[i][j].setForeground(Color.black);
//                            ady[i][j].setText(c.toString());
//			    if(ady[ i ][ j ].getText().equals("I")){		 //obtengo coordenada de valor inicial
//			    	x = i; y = j;
//			    }
//			}
//		}
//		
//        }
        
    void crearAleatorio(){
        for (int i = 0; i < h ; ++i ) {
            for( int j = 0 ; j < w ; ++j ){
                int a=(int)(Math.random()*4);
                ady[i][j].setForeground(Color.black);
                if(a == 0){
                    ady[i][j].setText("#");
                }else{
                    ady[i][j].setText("0");
                }
                if(ady[ i ][ j ].getText().equals("I")){		 //obtengo coordenada de valor inicial
                    x = i; y = j;
                }
            }
        }

        int f = (int)(Math.random()*10);
        int c = (int)(Math.random()*10);
        ady[f][c].setText("S");
      //  ady[1][1].setText("S");
        ady[0][0].setText("0");
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == b1){
            int min = BFS( x , y , h , w );
            if( min == -1 ) setTitle("No se pudo llegar al destino");
            else setTitle("Menor numero de pasos: " + min );
        }else{
            crearAleatorio();
        }    
    }

    public static int BFS( int x , int y , int h , int w ){ //coordenadas de inicial "I" y dimensiones de laberinto

        boolean visitado[][] = new boolean[ MAX ][ MAX ];	//arreglo de estados visitados
        Queue<Estado> Q = new LinkedList<>();			//Cola de todos los posibles Estados por los que se pase para llegar al destino
        Q.add( new Estado( x , y , 0 ) );					//Insertamos el estado inicial en la Cola con distnacia 0.

        int dx[] = { 0 ,  0 , 1 , -1 };		//incremento en coordenada x
        int dy[] = { 1 , -1 , 0 ,  0 };		//incremento en coordenada y
        int nx , ny;

        while(!Q.isEmpty()){							//Mientras cola no este vacia
            Estado actual = Q.remove();					//Obtengo de la cola el estado actual, en un comienzo será el inicial
            if( ady[ actual.x ][ actual.y ].getText().equals("S")){	//Si se llego al destino (punto final)
                    return actual.d;						//Retornamos distancia recorrida hasta ese momento
            }
            
            visitado[ actual.x ][ actual.y ] = true;	//Marco como visitado dicho estado para no volver a recorrerlo
            ady[ actual.x ][ actual.y ].setForeground(Color.red);
            

            for( int i = 0 ; i < 4 ; ++i ){				//Recorremos hasta 4 porque tenemos 4 posibles adyacentes
                nx = dx[ i ] + actual.x;				//nx y ny tendran la coordenada adyacente
                ny = dy[ i ] + actual.y;				//ejemplo en i=0 y actual (3,4) -> 3+dx[0]=3+0=3, 4+dy[0]=4+1=5, nueva coordenada (3,5)
        //aqui comprobamos que la coordenada adyacente no sobrepase las dimensiones del laberinto
        //ademas comprobamos que no sea pared "#" y no este visitado
                if( nx >= 0 && nx < h && ny >= 0 && ny < w && !visitado[ nx ][ ny ] && !ady[ nx ][ ny ].getText().equals("#")){
                        Q.add( new Estado( nx , ny , actual.d + 1 ) ); //agregamos estado adyacente aumento en 1 la distancia recorrida
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int h , w , x = 0 , y = 0;
        Scanner sc = new Scanner( System.in );
        System.out.println( "Ingrese altura del laberinto: " );
        h = sc.nextInt(); 
        System.out.println( "Ingrese ancho del laberinto: " );
        w = sc.nextInt();
        Laberinto lab = new Laberinto(h, w);
        lab.setBounds(0,0,400,400);
        lab.setVisible(true);
        //System.out.println("Ingrese el laberinto, con un solo valor inicial I, valor final sera S: ");

    }

}
