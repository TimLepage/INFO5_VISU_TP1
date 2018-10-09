package tp1;

public class Main {

	public static void main(String[] args) {
		boolean debug = false;
		double epsilon = 0.02;
		Algo algo1 = new Algo();

		double[] res = algo1.decomplete(algo1.arr1, algo1.arraySize);
		if (debug) {
			System.out.println("Tableau décomposé\n");
			for (int i = 0; i < algo1.arr1.length; i++) {
				System.out.println(res[i]);
			}
		}

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
			}
		}

		double[] res2 = algo1.recomplete(compressed, 1);
		if (debug) {
			System.out.println("\nResultat recomposition\n");
			for (int i = 0; i < algo1.arr1.length; i++) {
				System.out.println(res2[i]);
			}
		}
		System.out.println("\nDistance entre les tableaux avec epsilon = " + epsilon + " est de "
				+ algo1.distance(res2, algo1.arrbase));

	}
}
