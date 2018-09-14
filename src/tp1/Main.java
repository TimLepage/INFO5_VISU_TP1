package tp1;

public class Main {
	public static void main(String[] args) {
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
		for (int i = 0; i < algo1.arr1.length; i++) {
			System.out.println(res[i]);
		}
		float[] res2 = algo1.recomplete(res, 1);
		System.out.println("\nResultat recomposition\n");
		for (int i = 0; i < algo1.arr1.length; i++) {
			System.out.println(res2[i]);
		}
	}
}
