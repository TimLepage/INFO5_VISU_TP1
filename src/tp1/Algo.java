package tp1;

public class Algo {
	public int arraySize = 4;
	public float[] arr1;
	public float[] arr2;

	public Algo() {
		arr1 = new float[] { 1, 2, 3, 4};
		arr2 = new float[arraySize];
	}

	public float[] decomposition(float[] arr1, float[] arr2, int size) {
		int j = 0;
		for (int i = 0; i < 2 * size; i += 2) {
			arr2[j] = (arr1[i] + arr1[i + 1]) / 2;
			arr2[j + size] = arr2[j] - arr1[i];
			j++;
		}
		return arr2;
	}

	public float[] recomposition(float[] arr1, float[] arr2, int size) {
		int j = 0;
		for (int i = 0; i < size; i += 2) {
			arr2[j] = arr1[i] - arr1[i + size];
			arr2[j + 1] = arr1[i] + arr1[i + size];
			j += 2;
		}
		return arr2;
	}
	
	public float[] decomplete(float[] arr1, float[] arr2, int size){
		while(size > 1){
			size = size/2;
			arr1 = decomposition(arr1, arr2, size);
			for (int i = 0; i < arr1.length; i++) {
				System.out.println(arr1[i]);
			}
			System.out.println("\n");
		}
		return arr1;
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
