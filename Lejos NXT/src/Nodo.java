/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Nodo {

    private Nodo f;
    private Nodo r;
    private Nodo l;
    private Nodo b;
    private int x;
    private int y;
    private boolean visitado = false;
    private int direc = 2;

    public Nodo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void agregarHijos(Nodo reco) {
        f = new Nodo(reco.getY() + 1, reco.getX());
        r = new Nodo(reco.getY(), reco.getX() + 1);
        b = new Nodo(reco.getY() - 1, reco.getX()); //l = b
        l = new Nodo(reco.getY(), reco.getX() - 1);
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public Nodo getF() {
        return f;
    }

    public void setF(Nodo f) {
        this.f = f;
    }

    public Nodo getR() {
        return r;
    }

    public void setR(Nodo r) {
        this.r = r;
    }

    public Nodo getL() {
        return l;
    }

    public void setL(Nodo l) {
        this.l = l;
    }

    public Nodo getB() {
        return b;
    }

    public void setB(Nodo b) {
        this.b = b;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

	public void setDirec(int direc) {
		this.direc = direc;
	}

	public int getDirec() {
		return direc;
	}
}
