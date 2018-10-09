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
					0.25 * (-tab[mod(2 * i - 2, 512)].getX() + 3 * tab[mod(2 * i - 1, 512)].getX()
							+ 3 * tab[mod(2 * i, 512)].getX() - tab[mod(2 * i + 1, 512)].getX()),
					0.25 * (-tab[mod(2 * i - 2, 512)].getY() + 3 * tab[mod(2 * i - 1, 512)].getY()
							+ 3 * tab[mod(2 * i, 512)].getY() - tab[mod(2 * i + 1, 512)].getY())); // Valeur

		}
		for (int i = size; i < 2 * size; i++) {
			restab[i] = new Point(
					0.25 * (tab[mod(2 * i - 2, 512)].getX() - 3 * tab[mod(2 * i - 1, 512)].getX()
							+ 3 * tab[mod(2 * i, 512)].getX() - tab[mod(2 * i + 1, 512)].getX()),
					0.25 * (-tab[mod(2 * i - 2, 512)].getY() + 3 * tab[mod(2 * i - 1, 512)].getY()
							+ 3 * tab[mod(2 * i, 512)].getY() - tab[mod(2 * i + 1, 512)].getY())); // Detail

		}

		for (int i = 2 * size; i < 512; i++) {
			restab[i] = tab[i];
		}

		return restab;
	}

	public Point[] recomposition(Point[] tab, int size) { //TODO a débug
		Point[] restab = new Point[512];
		for (int i = 0; i < size; i+=2) {
			restab[2 * i] = new Point(
					0.75 * (tab[i % 512].getX() + tab[(i + size) % 512].getX())
							+ 0.25 * (tab[(i + 1) % 512].getX() - tab[(i + 1 + size) % 512].getX()),
					0.75 * (tab[i % 512].getY() + tab[(i + size) % 512].getY())
							+ 0.25 * (tab[(i + 1) % 512].getY() - tab[(i + 1 + size) % 512].getY())); // Valeur
			restab[2 * i + 1] = new Point(
					0.25 * (tab[i % 512].getX() + tab[(i + size) % 512].getX())
							+ 0.75 * (tab[(i + 1) % 512].getX() - tab[(i + 1 + size) % 512].getX()),
					0.25 * (tab[i % 512].getY() + tab[(i + size) % 512].getY())
							+ 0.75 * (tab[(i + 1) % 512].getY() - tab[(i + 1 + size) % 512].getY())); // Valeur

		}

		for (int i = 2 * size; i < 512; i++) {
			restab[i] = tab[i];
		}

		return restab;
	}

}
