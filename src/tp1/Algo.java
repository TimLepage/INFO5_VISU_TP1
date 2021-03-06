package tp1;

public class Algo {
	public double bornesup = 0.5;
	public int arraySize = 1024; // @require doit etre puissance de 2
	public double[] arr1;
	public double[] arr2;
	public double[] arrbase;
	boolean debug = false;

	public Algo() {
		arr1 = new double[arraySize];
		for (int j = 0; j < arraySize; j++) {
			arr1[j] = Math.sin(bornesup);

		}

		arrbase = arr1;
		if (debug) {
			System.out.println("Tableau initial\n");
			for (int i = 0; i < arr1.length; i++) {
				System.out.println(arr1[i]);
			}
			System.out.println("\n");
		}
		arr2 = new double[arraySize];
	}

	public double[] decomposition(double[] arr1, int size) {
		double[] arr2 = new double[arraySize];
		int j = 0;
		for (int i = 0; i < 2 * size; i += 2) {
			arr2[j] = (arr1[i] + arr1[i + 1]) / 2;
			arr2[j + size] = arr2[j] - arr1[i];
			j++;
		}
		if (size != arraySize / 2) {
			for (int k = 2 * size; k < arraySize; k++) {
				arr2[k] = arr1[k];
			}
		}
		return arr2;
	}

	public double[] recomposition(double[] arr1, int size) {
		double[] arr2 = new double[arraySize];
		int j = 0;
		for (int i = 0; i < size; i += 1) {
			arr2[j] = arr1[i] - arr1[i + size];
			arr2[j + 1] = arr1[i] + arr1[i + size];
			j += 2;
		}

		for (int k = 2 * size; k < arraySize; k++) {
			arr2[k] = arr1[k];
		}
		return arr2;
	}

	public double[] decomplete(double[] arr1, int size) {
		while (size > 1) {
			size = size / 2;
			arr1 = decomposition(arr1, size);
		}
		return arr1;
	}

	public double[] recomplete(double[] arr1, int size) {
		while (size < arraySize) {
			// for (int i = 0; i < arr1.length; i++) {
			// System.out.println(arr1[i]);
			// }
			// System.out.println("\n");
			arr1 = recomposition(arr1, size);
			size = size * 2;
		}
		return arr1;
	}

	public double[] compression(double[] arr, double epsilon) {
		System.out.println(epsilon
				);
		for (int i = 0; i < arr.length; i++) {
			if (Math.abs(arr[i]) < epsilon) {
				arr[i] = 0;
			}
		}
		return arr;
	}

	/**
	 * @require origin.lenght == end.lenght
	 * @param origin
	 * @param end
	 * @return
	 */
	public double distance(double[] origin, double[] end) {
		float sum = 0;
		for (int i = 0; i < origin.length; i++) {
			sum += Math.pow(origin[i] - end[i], 2);
		}
		return Math.sqrt(sum);
	}

}
