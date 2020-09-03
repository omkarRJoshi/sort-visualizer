package com.sorting.visualizer;

public class BubbleSort implements Runnable{
	
	SortArray sortArray;
	
	public BubbleSort(SortArray sortArray) {
		this.sortArray = sortArray;
	}
	
	@Override
	public void run() {
		bubbleSort();
		for(int i = 0; i < sortArray.NUM_BARS; i++) {
			sortArray.constantColor(i, 100, 3);
		}
	}
	
	private void bubbleSort() {
		int n = sortArray.arr.length;
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n - i - 1; j++) {
				swap(j, j + 1, sortArray);
				sortArray.repaint();
				
			}
		}
	}
	
	public void swap(int i, int j, SortArray sortArray) {
		if(sortArray.arr[i] > sortArray.arr[j]) {
			int temp = sortArray.arr[i];
			sortArray.arr[i] = sortArray.arr[j];
			sortArray.arr[j] = temp;
			
			sortArray.changeColor(i, j, 255, 255, 1);
		}
		else {
			sortArray.changeColor(i, j, 128, 128, 1);
		}
		
	}

}
