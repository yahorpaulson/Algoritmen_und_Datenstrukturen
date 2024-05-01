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
		IndexedValue[] indexedArray = new IndexedValue[data.length];
		for (int i = 0; i < data.length; i++) {
			indexedArray[i] = new IndexedValue(data[i], i);
		}

		quickSort(indexedArray, 0, indexedArray.length - 1);

		for (int i = 0; i < indexedArray.length; i++) {
			data[i] = indexedArray[i].value;
		}
	}

	@Override
	public int[][] mult(int[][] m1, int[][] m2) {
		return new int[0][];
	}
	private int partition(IndexedValue[] data, int low, int high) {
		IndexedValue pivot = data[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (data[j].compareTo(pivot) <= 0) {
				i++;
				IndexedValue temp = data[i];
				data[i] = data[j];
				data[j] = temp;
			}
		}
		IndexedValue temp = data[i + 1];
		data[i + 1] = data[high];
		data[high] = temp;
		return i + 1;
	}
	private void quickSort(IndexedValue[] data, int low, int high) {
		if (low < high) {
			int pivotIndex = partition(data, low, high);
			quickSort(data, low, pivotIndex - 1);
			quickSort(data, pivotIndex + 1, high);
		}
	}
}

class IndexedValue implements Comparable<IndexedValue> {
	Integer value;
	int index;

	IndexedValue(Integer value, int index) {
		this.value = value;
		this.index = index;
	}

	@Override
	public int compareTo(IndexedValue other) {
		int valueCompare = this.value.compareTo(other.value);
		if (valueCompare != 0) return valueCompare;
		return Integer.compare(this.index, other.index);
	}
}
