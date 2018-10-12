package tp2;

public class Algorithm {
	public Algorithm() {

	}

	public int mod(int a, int b) {
		return ((a % b) + b) % b;
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
			restab[i] = new Point(
					0.25 * (tab[mod(2 * i - 2, 2 * size)].getX() - 3 * tab[mod(2 * i - 1, 2 * size)].getX()
							+ 3 * tab[mod(2 * i, 2 * size)].getX() - tab[mod(2 * i + 1, 2 * size)].getX()),
					0.25 * (-tab[mod(2 * i - 2, 2 * size)].getY() + 3 * tab[mod(2 * i - 1, 2 * size)].getY()
							+ 3 * tab[mod(2 * i, 2 * size)].getY() - tab[mod(2 * i + 1, 2 * size)].getY())); // Detail

		}

		for (int i = 2 * size; i < 512; i++) {
			restab[i] = tab[i];
		}

		return restab;
	}

	public Point[] recomposition(Point[] tab, int size) { // TODO a débug
		Point[] restab = new Point[512];
		for (int i = 0; i < size; i++) {
			if(i + 1 + size == 2*size) {
				System.out.println("ee");
				restab[2 * i] = new Point(
						0.75 * (tab[i % (size)].getX() + tab[(i + size) % (2 * size)].getX())
								+ 0.25 * (tab[(i + 1) % (size)].getX() - tab[(i + 1 + size) % (2 * size)+size].getX()),
						0.75 * (tab[i % (size)].getY() + tab[(i + size) % (2 * size)].getY())
								+ 0.25 * (tab[(i + 1) % (size)].getY() - tab[(i + 1 + size) % (2 * size)+size].getY())); // Valeur
				restab[2 * i + 1] = new Point(
						0.25 * (tab[i % (size)].getX() + tab[(i + size) % (2 * size)].getX())
								+ 0.75 * (tab[(i + 1) % (size)].getX() - tab[(i + 1 + size) % (2 * size)+size].getX()),
						0.25 * (tab[i % (size)].getY() + tab[(i + size) % (2 * size)].getY())
								+ 0.75 * (tab[(i + 1) % (size)].getY() - tab[(i + 1 + size) % (2 * size)+size].getY())); // Valeur
			}else {

				restab[2 * i] = new Point(
						0.75 * (tab[i % (size)].getX() + tab[(i + size) % (2 * size)].getX())
								+ 0.25 * (tab[(i + 1) % (size)].getX() - tab[(i + 1 + size) % (2 * size)].getX()),
						0.75 * (tab[i % (size)].getY() + tab[(i + size) % (2 * size)].getY())
								+ 0.25 * (tab[(i + 1) % (size)].getY() - tab[(i + 1 + size) % (2 * size)].getY())); // Valeur
				restab[2 * i + 1] = new Point(
						0.25 * (tab[i % (size)].getX() + tab[(i + size) % (2 * size)].getX())
								+ 0.75 * (tab[(i + 1) % (size)].getX() - tab[(i + 1 + size) % (2 * size)].getX()),
						0.25 * (tab[i % (size)].getY() + tab[(i + size) % (2 * size)].getY())
								+ 0.75 * (tab[(i + 1) % (size)].getY() - tab[(i + 1 + size) % (2 * size)].getY())); // Valeur
			}

		}

		for (int i = 2 * size + 1; i < 512; i++) {
			restab[i] = tab[i];
		}

		return restab;
	}

}
