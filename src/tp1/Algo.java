package tp1;

public class Algo {
	public int arraySize = 8;
	public float[] arr1;
	public float[] arr2;
	public float[] arrbase;

	public Algo() {
		arr1 = new float[] { 1, 8, 5, 8, 4, 2, 1, 7 };
		arrbase = arr1;
		System.out.println("Tableau initial\n");
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		System.out.println("\n");
		arr2 = new float[arraySize];
	}

	public float[] decomposition(float[] arr1, int size) {
		float[] arr2 = new float[arraySize];
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

	public float[] recomposition(float[] arr1, int size) {
		float[] arr2 = new float[arraySize];
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

	public float[] decomplete(float[] arr1, int size) {
		while (size > 1) {
			size = size / 2;
			arr1 = decomposition(arr1, size);
		}
		return arr1;
	}

	public float[] recomplete(float[] arr1, int size) {
		while (size < arraySize) {
//			for (int i = 0; i < arr1.length; i++) {
//				System.out.println(arr1[i]);
//			}
//			System.out.println("\n");
			arr1 = recomposition(arr1, size);
			size = size * 2;
		}
		return arr1;
	}

	public float[] compression(float[] arr, float epsilon){
		for(int i = 0; i < arr.length; i++){
			if(Math.abs(arr[i]) < epsilon){
				arr[i] = 0;
			}
		}
		return arr;
	}
	
	
	/**
	 * @require origin.lenght = end.lenght
	 * @param origin
	 * @param end
	 * @return
	 */
	public double distance(float[] origin, float[] end) {
		float sum = 0;
		for (int i = 0; i < origin.length; i++) {
			sum += Math.pow(origin[i] - end[i], 2);
		}
		return Math.sqrt(sum);
	}

}
