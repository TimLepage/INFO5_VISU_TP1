package tp1;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		FileWriter fichier;
		FileWriter fifi;
		fifi = new FileWriter("dada.csv");
		fichier = new FileWriter("data.csv");

		boolean debug = false;
		double epsilon = 0.6;
		Algo algo1 = new Algo();
		// algo1.decomposition(algo1.arr1, algo1.arr2, 2);
		// for(int i = 0; i < algo1.arr2.length; i ++){
		// System.out.println(algo1.arr2[i]);
		// }
		// System.out.println("\n\n");
		// algo1.recomposition(algo1.arr2, algo1.arr1, 2);
		// for(int i = 0; i < algo1.arr1.length; i ++){
		// System.out.println(algo1.arr1[i]);
		// }

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
