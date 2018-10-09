package tp2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Polygon {

	private Point[] pointList= new Point[512];

	public Point[] getPointList() {
		return this.pointList;
	}
	public Polygon() {
		
		LectureFichier();
	}

	public void LectureFichier() {
		try {
			InputStream flux = new FileInputStream("crocodile.txt");
			InputStreamReader lecture = new InputStreamReader(flux);
			BufferedReader buff = new BufferedReader(lecture);
			String ligne;
			String[] s;
			int i=0;
			while ((ligne = buff.readLine()) != null) {
				System.out.println(ligne);
				s= ligne.toString().split(" ");
				System.out.println(s.toString());
				pointList[i] = new Point(Float.valueOf(s[0]),Float.valueOf(s[1]));
				i++;
			}
			buff.close();
		} catch (Exception e) {

			System.out.println(e.toString());
		}
	}

	public static void main(String[] args) {
		Polygon p = new Polygon();
		Draw d = new Draw(p);
	}

}
