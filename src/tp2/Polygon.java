package tp2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

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
				s= ligne.toString().split(" ");
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
		Algorithm a = new Algorithm();
		Point[] res = a.decomposition(p.getPointList(), 256);
		Point[] res2 = a.recomposition(res, 256);
		Point[] res3 = a.decomposition(res, 128);
		Draw d = new Draw(Arrays.copyOfRange(res, 0, 256));
		Draw d1 = new Draw(Arrays.copyOfRange(res2, 0, 512));
		//Draw d2 = new Draw(Arrays.copyOfRange(res3, 0, 128));
		Draw original = new Draw(p.pointList);//original
	}

}