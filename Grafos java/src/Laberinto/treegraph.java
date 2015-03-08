
package Laberinto;

import arbolbinario.ArbolBinario;
import arbolbinario.Nodo;
import java.awt.*;
import javax.swing.*;

public class treegraph extends JFrame
{

    public int XDIM, YDIM;
    public Graphics display;

    public void paint(Graphics g) {} // override method

    // constructor sets window dimensions
    public treegraph(int x, int y)
    {
	XDIM = x;  YDIM = y;
	this.setBounds(0,0,XDIM,YDIM);
	this.setVisible(true); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	display = this.getGraphics();
	// draw static background as a black rectangle
	display.setColor(Color.black);
	display.fillRect(0,0,x,y);
        display.setColor(Color.red);
	
    }  // drawingwindow


    public static int depth(Nodo N)  // find max depth of tree
    {
	if (N==null) return 0;
        int l = depth(N.getHizq());
        int r = depth(N.getHder());
        if (l>r) return l+1; else return r+1;
    }

    // internal vars used by drawtree routines:
    private int bheight = 50; // branch height
    private int yoff = 30;  // static y-offset

    // l is level, lb,rb are the bounds (position of left and right child)
    private void drawnode(Nodo N,int l, int lb, int rb)
    {
	if (N==null) return;
        display.setColor(Color.green);
	display.fillOval(((lb+rb)/2)-10,yoff+(l*bheight),20,20);
	display.setColor(Color.red);
	display.drawString(N.getValor()+"",((lb+rb)/2)-5,yoff+15+(l*bheight));
	display.setColor(Color.blue); // draw branches
        if (N.getHizq()!=null)
	    {
   	       display.drawLine((lb+rb)/2,yoff+10+(l*bheight),
			((3*lb+rb)/4),yoff+(l*bheight+bheight));
               drawnode(N.getHizq(),l+1,lb,(lb+rb)/2);
	    }
        if (N.getHder()!=null)
	    {
               display.drawLine((lb+rb)/2,yoff+10+(l*bheight),
			((3*rb+lb)/4),yoff+(l*bheight+bheight));
               drawnode(N.getHder(),l+1,(lb+rb)/2,rb);
	    }
    } // drawnode

    public void drawtree(Nodo T)
    {
        if (T==null) return;
	int d = depth(T);
	bheight = (YDIM/d);
	display.setColor(Color.white);
	display.fillRect(0,0,XDIM,YDIM);  // clear background
        drawnode(T,0,0,XDIM);
    }

     
    public static void main(String[] args)
    {
      treegraph W = new treegraph(1024,768);
      Nodo raiz = new Nodo(10, null);
      ArbolBinario arbol = new ArbolBinario(10);
        arbol.insertar(5);
        arbol.insertar(20);
        arbol.insertar(2);
        arbol.insertar(7);
        arbol.insertar(15);
        arbol.insertar(25);
        arbol.insertar(1);
        arbol.insertar(3);
        arbol.insertar(6);
        arbol.insertar(8);
        arbol.insertar(21);
      
      W.drawtree(raiz);
    }  // main
  

} // treegraph
