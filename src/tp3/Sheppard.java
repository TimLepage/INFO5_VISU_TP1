package tp3;

import java.io.FileWriter;
import java.io.IOException;

public class Sheppard {
	public double mui = 2;
	public int SIZE = 100;
	public int rSIZE = (int) Math.sqrt(SIZE);
	public Point[] tab = new Point[SIZE];

	public void init() {
		int i = 0;
		for (int x = 0; x < rSIZE; x++) {
			for (int y = 0; y < rSIZE; y++) {
				tab[i] = new Point((double) x / rSIZE, (double) y / rSIZE, x*y);
				i++;
			}
		}
	}

	public void ecrireFichier(String fichier, Point[] tab) throws IOException {
		FileWriter fifi = new FileWriter(fichier);
		for (int i = 0; i < SIZE; i++) {
			fifi.write(tab[i].toString());
			if ((i+1) % rSIZE == 0) {
				fifi.write("\n");
			}
		}
		fifi.close();
	}

	public double distance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
	}

	public double ponderation(Point X, int indice) {
		double numerateur = 1;
		for (int i = 0; i < SIZE; i++) {
			if (indice != i) {
				numerateur *= Math.pow(distance(X, tab[i]), mui);
			}
		}

		double sum = 0;
		double mult = 1;
		for (int k = 0; k < SIZE; k++) {
			for (int j = 0; j < SIZE; j++) {
				if (j != k) {
					mult *= Math.pow(distance(X, tab[j]), mui);
				}
			}
			sum += mult;
			mult = 1;
		}
		return numerateur / sum;
	}

	public Point[] algoSheppard() {
		System.out.println("Entrée Sheppard");
		Point[] res = new Point[SIZE];
		double sum = 0;
		for (int x = 0; x < SIZE; x++) {
			for (int i = 0; i < SIZE; i++) {
				sum += ponderation(tab[i], i) * tab[i].getValeur();
			}
			res[x] = new Point(tab[x].getX(), tab[x].getY(), sum);
			sum = 0;
			System.out.println("Point ajouté " + res[x].toString());
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		Sheppard s = new Sheppard();
		s.init();
		Point[] res = s.algoSheppard();
		s.ecrireFichier("res.txt", s.getTab());
	}

	public Point[] getTab() {
		return tab;
	}

	public void setTab(Point[] tab) {
		this.tab = tab;
	}

}
