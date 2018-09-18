package tp1;

public class Main {
	public static void main(String[] args) {
		float epsilon = (float) 1.5;
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

		float[] res = algo1.decomplete(algo1.arr1, algo1.arraySize);
		System.out.println("Tableau décomposé\n");
		for (int i = 0; i < algo1.arr1.length; i++) {
			System.out.println(res[i]);
		}
		
		float[] compressed = algo1.compression(res, epsilon);
		System.out.println("\nTableau compressé\n");
		for (int i = 0; i < algo1.arr1.length; i++) {
			System.out.println(compressed[i]);
		}
		
		float[] res2 = algo1.recomplete(compressed, 1);
		System.out.println("\nResultat recomposition\n");
		for (int i = 0; i < algo1.arr1.length; i++) {
			System.out.println(res2[i]);
		}
		
		System.out.println("\nDistance entre les tableaux "+ algo1.distance(res2, algo1.arrbase));
		
	}
}
