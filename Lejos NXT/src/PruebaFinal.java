import java.util.ArrayList;
import java.util.Stack;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;

public class PruebaFinal {

	private Nodo raiz;
	private Stack<Nodo> pila = new Stack<Nodo>();
	private ArrayList<Nodo> trayectoria = new ArrayList<Nodo>();
	private ArrayList<Integer> arbol = new ArrayList<Integer>();
	LightSensor luz = new LightSensor(SensorPort.S1);
	UltrasonicSensor sony = new UltrasonicSensor(SensorPort.S2);
	DifferentialPilot pilot = new DifferentialPilot(2.15f, 5.5f, Motor.A,
			Motor.C);

	public PruebaFinal() {
		// TODO Auto-generated constructor stub
		trayectoria.add(null);
		this.raiz = new Nodo(12, 15);
		raiz.agregarHijos(raiz);
		pila.push(raiz);
		while (true) {
			try {
				if (luz.readValue() > 75) {
					break;
				} else {
					raiz.setVisitado(true);
					raiz = Avanzar(raiz);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	/**
	 * Verifica por Donde puede Avanzar
	 * @param reco
	 * @return
	 */
	private Nodo Avanzar(Nodo reco) {
		reco.agregarHijos(reco);
		trayectoria.add(reco);
		reco = Analizar(reco);

		return reco;
	}

	/**
	 * Se encarga de imprimir el árbol a medida que este se va formando
	 */
	public void imprimir() {
		try {
			switch (raiz.getDirec()) {
			case 2:
				LCD.drawString("(" + "F" + ")" + "L " + "R " + "F " + "B", 0, 0);
				Thread.sleep(3000);
				LCD.clear();
				break;

			case 3:
				LCD.drawString("(" + "R" + ")" + "L " + "R " + "F " + "B", 0, 0);
				Thread.sleep(3000);
				LCD.clear();
				break;

			case 4:
				LCD.drawString("(" + "L" + ")" + "L " + "R " + "F " + "B", 0, 0);
				Thread.sleep(3000);
				LCD.clear();
				break;

			case 5:
				LCD.drawString("(" + "B" + ")" + "L " + "R " + "F " + "B", 0, 0);
				Thread.sleep(3000);
				LCD.clear();
				break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Se encarga de detener el robot antes de que choque, o si encuetra la luz
	 */
	public void detenerse() {
		while (pilot.isMoving()) {
			if (sony.getDistance() < 20) {
				pilot.stop();
			} else if (luz.readValue() > 75) {
				pilot.stop();
				System.exit(0);
			}
		}
	}

	/**
	 * Revisa los lados del robot para saber si puede avanzar
	 * @param raiz
	 * @return
	 */
	public Nodo Analizar(Nodo raiz) {
		Nodo cam;
		int back = 0;
		int i = 0;
		int mover = 0;
		Nodo aux = null;
		try {
			// verifica hijo izquierda
			Motor.B.rotate(-90, true);
			Thread.sleep(2000);
			aux = raiz.getL();// GETL
			for (int j = 1; j < trayectoria.size(); j++) {
				cam = trayectoria.get(j);
				if (cam.getX() == aux.getX() && cam.getY() == aux.getY()) {
					back++;
					break;
				}
			}
			if (back < 2) {
				if (trayectoria.get(trayectoria.size() - 2) != null) {
					if (trayectoria.get(trayectoria.size() - 2).getX() == aux
							.getX()
							&& trayectoria.get(trayectoria.size() - 2).getY() == aux
									.getY()) {
						aux.setVisitado(true);
					}
				}
				if (sony.getDistance() > 30 && !aux.isVisitado()) {
					i++;
					mover = 4;
				}
			}

			// verifica hijo derecha
			Motor.B.rotate(180, true);
			Thread.sleep(2000);
			aux = raiz.getR();
			for (int j = 1; j < trayectoria.size(); j++) {
				cam = trayectoria.get(j);
				if (cam.getX() == aux.getX() && cam.getY() == aux.getY()) {
					back++;
					break;
				}
			}
			if (back < 2) {
				if (trayectoria.get(trayectoria.size() - 2) != null) {
					if (trayectoria.get(trayectoria.size() - 2).getX() == aux
							.getX()
							&& trayectoria.get(trayectoria.size() - 2).getY() == aux
									.getY()) {
						aux.setVisitado(true);
					}
				}
				if (sony.getDistance() > 30 && !aux.isVisitado()) {
					i++;
					mover = 3;
				}
			}

			// asigna hijo frente
			Motor.B.rotate(-90, true);
			Thread.sleep(2000);
			aux = raiz.getF();
			for (int j = 1; j < trayectoria.size(); j++) {
				cam = trayectoria.get(j);
				if (cam.getX() == aux.getX() && cam.getY() == aux.getY()) {
					back++;
					break;
				}
			}
			if (back < 2) {
				if (trayectoria.get(trayectoria.size() - 2) != null) {
					if (trayectoria.get(trayectoria.size() - 2).getX() == aux
							.getX()
							&& trayectoria.get(trayectoria.size() - 2).getY() == aux
									.getY()) {
						aux.setVisitado(true);
					}
				}
				if (sony.getDistance() > 20 && !aux.isVisitado()) {
					i++;
					mover = 2;
				}
			}

			if (i >= 2) {

				pila.push(raiz);
				if (mover == 2) {
					pilot.travel(20, true);
					raiz.setDirec(raiz.getDirec());
					detenerse();
					Thread.sleep(2000);
					arbol.add(2);
					imprimir();
					aux.setY(aux.getY() + 1);
				}
				if (mover == 3) {
					pilot.rotate(95, true);
					Thread.sleep(2000);
					pilot.travel(20, true);
					detenerse();
					Thread.sleep(2000);
					arbol.add(3);
					if (raiz.getDirec() == 2) {
						raiz.setDirec(3);
					} else if (raiz.getDirec() == 3) {
						raiz.setDirec(5);
					} else if (raiz.getDirec() == 5) {
						raiz.setDirec(4);
					} else if (raiz.getDirec() == 4) {
						raiz.setDirec(2);
					}
					imprimir();
					aux.setX(aux.getX() + 1);

				}
				if (mover == 4) {
					pilot.rotate(-95, true);
					Thread.sleep(2000);
					pilot.travel(20, true);
					detenerse();
					Thread.sleep(2000);
					arbol.add(4);
					if (raiz.getDirec() == 2) {
						raiz.setDirec(4);
					} else if (raiz.getDirec() == 3) {
						raiz.setDirec(2);
					} else if (raiz.getDirec() == 5) {
						raiz.setDirec(3);
					} else if (raiz.getDirec() == 4) {
						raiz.setDirec(5);
					}
					imprimir();
					aux.setX(aux.getX() - 1);

				}
			} else if (i < 2 && i > 0) {

				if (mover == 2) {
					pilot.travel(20, true);
					detenerse();
					Thread.sleep(2000);
					arbol.add(2);
					aux.setY(aux.getY() + 1);
				}
				if (mover == 3) {
					pilot.rotate(95, true);
					Thread.sleep(2000);
					pilot.travel(20, true);
					detenerse();
					Thread.sleep(2000);
					arbol.add(3);
					if (raiz.getDirec() == 2) {
						raiz.setDirec(3);
					} else if (raiz.getDirec() == 3) {
						raiz.setDirec(5);
					} else if (raiz.getDirec() == 5) {
						raiz.setDirec(4);
					} else if (raiz.getDirec() == 4) {
						raiz.setDirec(2);
					}
					imprimir();
					aux.setX(aux.getX() + 1);
				}

				if (mover == 4) {
					pilot.rotate(-95, true);
					Thread.sleep(2000);
					pilot.travel(20, true);
					detenerse();
					Thread.sleep(2000);
					arbol.add(4);
					if (raiz.getDirec() == 2) {
						raiz.setDirec(4);
					} else if (raiz.getDirec() == 3) {
						raiz.setDirec(2);
					} else if (raiz.getDirec() == 5) {
						raiz.setDirec(3);
					} else if (raiz.getDirec() == 4) {
						raiz.setDirec(5);
					}
					imprimir();
					aux.setX(aux.getX() - 1);
				}

			} else if (i == 0) {
				Nodo backing = (Nodo) pila.pop();
				aux = Regresar(backing, raiz);// Algoritmo para devolver
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return aux;
	}

	/**
	 * Se encarga de realizar el Backtracking si no encuentra salida
	 * @param back
	 * @param raiz
	 * @return
	 */
	public Nodo Regresar(Nodo back, Nodo raiz) {

		try {
			trayectoria.remove(trayectoria.size() - 1);
			pilot.rotate(180, true);
			Thread.sleep(2000);
			pilot.travel(20, true);
			detenerse();
			Thread.sleep(2000);
			int tamaño;
			int tamaño2;
			if (raiz.getDirec() == 2) {
				raiz.setDirec(5);
			} else if (raiz.getDirec() == 3) {
				raiz.setDirec(4);
			} else if (raiz.getDirec() == 5) {
				raiz.setDirec(2);
			} else if (raiz.getDirec() == 4) {
				raiz.setDirec(3);
			}
			imprimir();
			raiz.setY(raiz.getY() - 1);
			
			while (back.getX() != raiz.getX() && back.getY() != raiz.getY()) {
				LCD.clear();
				LCD.drawString("Entre al While", 3, 4);
				LCD.clear();
				tamaño = arbol.size() - 1;
				if (arbol.get(tamaño) == 2) {
					pilot.travel(20, true);
					detenerse();
					Thread.sleep(2000);
				}
				if (arbol.get(tamaño) == 3) {
					pilot.rotate(-95, true);
					Thread.sleep(2000);
					pilot.travel(20, true);
					if (raiz.getDirec() == 2) {
						raiz.setDirec(4);
					} else if (raiz.getDirec() == 3) {
						raiz.setDirec(2);
					} else if (raiz.getDirec() == 5) {
						raiz.setDirec(3);
					} else if (raiz.getDirec() == 4) {
						raiz.setDirec(5);
					}
					detenerse();
				}
				Thread.sleep(2000);
				if (arbol.get(tamaño) == 4) {
					pilot.rotate(95, true);
					Thread.sleep(2000);
					pilot.travel(20, true);
					if (raiz.getDirec() == 2) {
						raiz.setDirec(3);
					} else if (raiz.getDirec() == 3) {
						raiz.setDirec(5);
					} else if (raiz.getDirec() == 5) {
						raiz.setDirec(4);
					} else if (raiz.getDirec() == 4) {
						raiz.setDirec(2);
					}
					detenerse();
				}
				Thread.sleep(2000);
				arbol.remove(tamaño);

				tamaño2 = trayectoria.size() - 1;
				raiz = trayectoria.get(tamaño2);
				trayectoria.remove(tamaño2);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return back;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		// TODO code application logic here
		PruebaFinal l = new PruebaFinal();

	}

}
