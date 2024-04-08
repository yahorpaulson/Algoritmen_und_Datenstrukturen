package ab1.impl.Nachnamen;

import ab1.Ab1;

public class Ab1Impl implements Ab1 {

	@Override
	public int binarySearch(int[] data, int element) {
		return binaryRecursive(data, element, 0, data.length - 1);
	}
	private int binaryRecursive(int[] data, int element, int left, int right){
		if (left <= right) {
			int mid = left + (right - left) / 2;
			if(data[mid]==element){
				return mid;
			} else if (data[mid]>element) {
				return binaryRecursive(data, element, left, mid-1);
			} else if (data[mid]< element){
				return binaryRecursive(data, element, mid+1, data.length-1);
			} else {
				System.err.println("Element not found!");
			}
		}
		return -1;
	}

	@Override
	public void shellSort(Integer[] data) {

		int n = data.length;

		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i++) {
				int key = data[i]; //500
				int j = i;	//500
				while (j >= gap && data[j - gap] > key) {
					data[j] = data[j - gap];
					j -= gap;
				}
				data[j] = key;
			}
		}
	}


	@Override
	public void quickSortStable(Integer[] data) {

	}

	@Override
	public int[][] mult(int[][] m1, int[][] m2) {
		return new int[0][];
	}
}
