package com.dsalgo.sort;

/**
 * different approach for merge sort - Divide and Conquer
 * 
 * @author srayabar
 */
public class MergeSortDemoVogella {
	
	private int[] inputIntArray;
	private int[] tempIntArray;
	
	public void sort(int[] values) {
		this.inputIntArray = values;
		int inputArrayLength = values.length;
		this.tempIntArray = new int[inputArrayLength];
		mergeSort(0, inputArrayLength-1);
	}

	private void mergeSort(int low, int high) {
		// check if low is smaller then high, if not then the array is sorted
		if(low < high){
			// Get the index of the element which is in the middle
			int middle = low + (high - low)/2;
			// Sort the left side of the array
			mergeSort(low, middle);
			// Sort the right side of the array
			mergeSort(middle+1, high);
			// Combine them both
			merge(low, middle, high);
		}
	}

	private void merge(int low, int middle, int high) {
		
		// Copy both parts into the helper array
		for(int i=low; i<= high; i++){
			this.tempIntArray[i] = this.inputIntArray[i];
		}
		
		int i = low;
		int j = middle + 1;
		int k = low;
		
		// Copy the smallest values from either the left or the right side back to the original array
		while(i <= middle && j <= high){
			if(this.tempIntArray[i] <= this.tempIntArray[j]){
				this.inputIntArray[k] = this.tempIntArray[i];
				i++;
			} else {
				this.inputIntArray[k] = this.tempIntArray[j];
				j++;
			}
			k++;
		} //while ends
		
		// Copy the rest of the left side of the array into the target array
		while(i <= middle){
			this.inputIntArray[k] = this.tempIntArray[i];
			i++;
			k++;
		}
	}
}