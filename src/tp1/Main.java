package tp1;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

<<<<<<< HEAD
	public static void main(String[] args) throws IOException {
		FileWriter fichier;
		FileWriter fifi;
		fifi = new FileWriter("dada.csv");
		fichier = new FileWriter("data.csv");

		boolean debug = false;
		double epsilon = 0.6;
=======
	public static void main(String[] args) {
		boolean debug = false;
		double epsilon = 0.02;
>>>>>>> e446593ed527df409cb304f61f33a6e4f5e8adf6
		Algo algo1 = new Algo();

		double[] res = algo1.decomplete(algo1.arr1, algo1.arraySize);
		if (debug) {
			System.out.println("Tableau décomposé\n");
			for (int i = 0; i < algo1.arr1.length; i++) {
				System.out.println(res[i]);
			}
		}
		

		try {
			for(int ii=0; ii<algo1.arraySize;ii++) {
				fifi.write(algo1.arrbase[ii] + " ; "+ res[ii]+"\n");

<<<<<<< HEAD
=======
		//double[] hist = algo1.histo(res);

//		System.out.println("\nHistogramme\n");
//		for (int i = 0; i < 10; i++) {
//			System.out.println(hist[i]);
//		}

		double[] compressed = algo1.compression(res, epsilon);
		if (debug) {
			System.out.println("\nTableau compressé\n");
			for (int i = 0; i < algo1.arr1.length; i++) {
				System.out.println(compressed[i]);
>>>>>>> e446593ed527df409cb304f61f33a6e4f5e8adf6
			}
		} catch (IOException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
		
		double[] compressed;
		double[] res2 ;
		//for (int ii = 0; ii < 100; ii++) {

			compressed = algo1.compression(res,epsilon);
			if (debug) {
				System.out.println("\nTableau compressé\n");
				for (int i = 0; i < algo1.arr1.length; i++) {
					System.out.println(compressed[i]);
				}
			}
<<<<<<< HEAD
=======
		}
		System.out.println("\nDistance entre les tableaux avec epsilon = " + epsilon + " est de "
				+ algo1.distance(res2, algo1.arrbase));
>>>>>>> e446593ed527df409cb304f61f33a6e4f5e8adf6

			res2 = algo1.recomplete(compressed, 1);
			if (debug) {
				System.out.println("\nResultat recomposition\n");
				for (int i = 0; i < algo1.arr1.length; i++) {
					System.out.println(res2[i]);
				}
			}
			System.out.println("\nDistance entre les tableaux " + algo1.distance(res2, algo1.arrbase));
			


		
		try {
			fichier.close();
			fifi.close();
		} catch (IOException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
	}
}
