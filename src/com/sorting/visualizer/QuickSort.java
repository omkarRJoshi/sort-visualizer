package com.sorting.visualizer;

public class QuickSort implements Runnable {
	
	SortArray sortArray;
	public QuickSort(SortArray sortArray) {
		this.sortArray = sortArray;
	}
	
	@Override
	public void run() {
		quickSort(sortArray.arr, 0, sortArray.NUM_BARS);
		for(int i = 0; i < sortArray.NUM_BARS; i++) {
			sortArray.constantColor(i, 100, 3);
		}
	}
	
	public void quickSort(int arr[], int l, int h) {
		if(l < h) {
			int j = partition(arr, l, h);
			quickSort(arr, l, j);
			quickSort(arr, j + 1, h);
		}
	}
	
	private int partition(int arr[], int l, int h) {
		int pivot = arr[l];
		int i = l, j = h;
		while(i < j) {
			do
				i++;
			while(i < arr.length && arr[i] <= pivot);
			do
				j--;
			while(j >= 0 && arr[j] > pivot);
			if(i < j)
				swap(i, j, arr, 128, 128, 5);
		}
		swap(l, j, arr, 255, 255, 40);
		return j;
	}
	
	private void swap(int i, int j, int[] arr, int c1, int c2, int sleepInMilli) {
		sortArray.changeColor(i, j, c1, c2, 40);
//		sortArray.sleepFor(sleepInMilli);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
