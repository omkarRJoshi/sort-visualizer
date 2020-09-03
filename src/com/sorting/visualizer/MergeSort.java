package com.sorting.visualizer;

public class MergeSort implements Runnable{
	
	SortArray sortArray;
//	@Override
	public MergeSort(SortArray sortArray) {
		this.sortArray = sortArray;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		mergeSort(0, sortArray.arr.length - 1, sortArray.arr);
		for(int i = 0; i < sortArray.NUM_BARS; i++) {
			sortArray.constantColor(i, 100, 3);
		}
	}
	
	public void mergeSort(int l, int r, int[] arr) {
		if(l < r) {
			int mid = (l + r) / 2;
			mergeSort(l, mid, arr);
			mergeSort(mid + 1, r, arr);
			merge(l, mid, r, arr);
		}
	}
	
	
	public void merge(int l, int mid, int r, int arr[]) {
		int n1 = mid - l + 1;
		int n2 = r - mid;
		
		int[] first = new int[n1];
		int[] sec = new int[n2];
		
		int a = 0, b = 0;
		
		while(a < n1 || b < n2) {
			if(a < n1) {
				sortArray.changeSingleColor(l + a, 128, 255, l);
				a++;
			}
			if(b < n2) {
				sortArray.changeSingleColor(mid + 1 + b, 128, 255, mid + 1);
				b++;
			}
			
			sortArray.repaint();
			sortArray.sleepFor(10);
			if(a <= n1) {
				sortArray.changeSingleColor(l + a - 1, 0, 0, l);
			}
			if(b <= n2) {
				sortArray.changeSingleColor(mid + b, 0, 0, mid + 1);
			}
			sortArray.repaint();
		}
		
//		sortArray.sleepFor(50);
		
		for(int i = 0; i < n1; i++) {
			first[i] = arr[l + i];
		}
		for(int j = 0; j < n2; j++) {
			sec[j] = arr[mid + 1 + j];
		}
		
		int i = 0, j = 0, k = l;
		while(i < n1 && j < n2) {
			if(first[i] <= sec[j]) {
				arr[k] = first[i];
				sortArray.constantColor(k, 0, 6);
				i++;
			}
			else {
				arr[k] = sec[j];
				sortArray.constantColor(k, 0, 6);
				j++;
			}
			k++;
		}
		
		while(i < n1) {
			arr[k] = first[i];
			sortArray.constantColor(k, 0, 6);
			i++;
			k++;
		}
		
		while(j < n2) {
			
			arr[k] = sec[j];
			sortArray.constantColor(k, 0, 6);
			j++;
			k++;
		}
	}

}
