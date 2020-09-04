package com.sorting.visualizer;

public class SelectionSort implements Runnable {
	
	SortArray sortArray;
	public SelectionSort(SortArray sortArray) {
		this.sortArray = sortArray;
	}
	
	@Override
	public void run() {
		selectionSort();
		for(int i = 0; i < sortArray.NUM_BARS; i++) {
			sortArray.constantColor(i, 100, 3);
		}
	}
	
	private void selectionSort() {
		int n = sortArray.NUM_BARS;
		int minIndex = 0;
		int min = sortArray.arr[0];
		for(int i = 0; i < n; i++) {
			min = sortArray.arr[i];
			minIndex = i;
			
			for(int j = i; j < n; j++) {
				if(sortArray.arr[j] < min) {
					min = sortArray.arr[j];
					minIndex = j;
				}
				sortArray.changeColor(i, j, 128, 255, 1);
			}
			swap(i, minIndex, sortArray);
			
			sortArray.sleepFor(sortArray.SLEEP_TIME);
		}
	}
	
	public void swap(int i, int j, SortArray sortArray) {
		int temp = sortArray.arr[i];
		sortArray.arr[i] = sortArray.arr[j];
		sortArray.arr[j] = temp;
		
		sortArray.changeColor(i, j, 255, 255, 0);
	}

}
