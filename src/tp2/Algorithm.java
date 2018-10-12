package tp2;

public class Algorithm {
	double epsilon = 0.5;

	public Algorithm() {

	}

	public int mod(int a, int b) {
		return ((a % b) + b) % b;
	}

	public double norme(Point p) {
		return Math.sqrt(p.getX() * p.getX() + p.getY() * p.getY());
	}

	public double distance(Point[] tab1, Point[] tab2){
		double sum = 0;
		for(int i = 0; i < 512; i++){
			sum += Math.abs(tab1[i].getX() - tab2[i].getX() + tab1[i].getY() - tab2[i].getY());
		}
		return sum;
	}

	public Point[] decomposition(Point[] tab, int size) {
		Point[] restab = new Point[512];
		for (int i = 0; i < size; i++) {
			restab[i] = new Point(
					0.25 * (-tab[mod(2 * i - 2, 2 * size)].getX() + 3 * tab[mod(2 * i - 1, 2 * size)].getX()
							+ 3 * tab[mod(2 * i, 2 * size)].getX() - tab[mod(2 * i + 1, 2 * size)].getX()),
					0.25 * (-tab[mod(2 * i - 2, 2 * size)].getY() + 3 * tab[mod(2 * i - 1, 2 * size)].getY()
							+ 3 * tab[mod(2 * i, 2 * size)].getY() - tab[mod(2 * i + 1, 2 * size)].getY())); // Valeur

		}
		for (int i = size; i < 2 * size; i++) {
			Point incoming = new Point(
					0.25 * (tab[mod(2 * i - 2, 2 * size)].getX() - 3 * tab[mod(2 * i - 1, 2 * size)].getX()
							+ 3 * tab[mod(2 * i, 2 * size)].getX() - tab[mod(2 * i + 1, 2 * size)].getX()),
					0.25 * (tab[mod(2 * i - 2, 2 * size)].getY() - 3 * tab[mod(2 * i - 1, 2 * size)].getY()
							+ 3 * tab[mod(2 * i, 2 * size)].getY() - tab[mod(2 * i + 1, 2 * size)].getY())); // Detail
			if (norme(incoming) < epsilon) {
				restab[i] = new Point(0, 0);
			} else {
				restab[i] = incoming;
			}

		}

		for (int i = 2 * size; i < 512; i++) {
			restab[i] = tab[i];
		}

		return restab;
	}

	public Point[] recomposition(Point[] tab, int size) { // TODO a débug
		Point[] restab = new Point[512];
		for (int i = 0; i < size; i++) {
			if (i + 1 + size == 2 * size) {
				restab[2 * i] = new Point(
						0.75 * (tab[i % size].getX() + tab[(i + size) % (2 * size)].getX())
								+ 0.25 * (tab[(i + 1) % size].getX() - tab[(i + 1 + size) % (2 * size) + size].getX()),
						0.75 * (tab[i % size].getY() + tab[(i + size) % (2 * size)].getY())
								+ 0.25 * (tab[(i + 1) % size].getY() - tab[(i + 1 + size) % (2 * size) + size].getY())); // Valeur
				restab[2 * i + 1] = new Point(
						0.25 * (tab[i % size].getX() + tab[(i + size) % (2 * size)].getX())
								+ 0.75 * (tab[(i + 1) % size].getX() - tab[(i + 1 + size) % (2 * size) + size].getX()),
						0.25 * (tab[i % size].getY() + tab[(i + size) % (2 * size)].getY())
								+ 0.75 * (tab[(i + 1) % size].getY() - tab[(i + 1 + size) % (2 * size) + size].getY())); // Valeur
			} else {

				restab[2 * i] = new Point(
						0.75 * (tab[i % size].getX() + tab[(i + size) % (2 * size)].getX())
								+ 0.25 * (tab[(i + 1) % size].getX() - tab[(i + 1 + size) % (2 * size)].getX()),
						0.75 * (tab[i % size].getY() + tab[(i + size) % (2 * size)].getY())
								+ 0.25 * (tab[(i + 1) % size].getY() - tab[(i + 1 + size) % (2 * size)].getY())); // Valeur
				restab[2 * i + 1] = new Point(
						0.25 * (tab[i % size].getX() + tab[(i + size) % (2 * size)].getX())
								+ 0.75 * (tab[(i + 1) % size].getX() - tab[(i + 1 + size) % (2 * size)].getX()),
						0.25 * (tab[i % size].getY() + tab[(i + size) % (2 * size)].getY())
								+ 0.75 * (tab[(i + 1) % size].getY() - tab[(i + 1 + size) % (2 * size)].getY())); // Valeur
			}

		}

		for (int i = 2 * size; i < 512; i++) {
			restab[i] = tab[i];
		}

		return restab;
	}

	public Point[] decomplete(Point[] tab, int size) {
		while (size > 4) {
			size = size / 2;
			tab = decomposition(tab, size);
		}
		return tab;
	}

	public Point[] recomplete(Point[] tab, int size) {
		while (size < 512) {
			tab = recomposition(tab, size);
			size = 2 * size;
		}
		return tab;
	}
}
