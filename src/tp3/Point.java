package tp3;

public class Point {
	private double x;
	private double y;
	private double valeur;

	public Point(double x, double y, double valeur) {
		this.x = x;
		this.y = y;
		this.valeur = valeur;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getValeur() {
		return valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public String toString() {
		return x + " " + y + " " + valeur + "\n";
	}

}
