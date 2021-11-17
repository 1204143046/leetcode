package com.ls.basic.sort;

import com.ls.common.ArrayUtils;


/**
 * 18:47
 * @author l20095
 *
 */
public class MergeSort {

	
	public static void main(String[] args) {
		int[] arr = ArrayUtils.buildRandomArr(4, 11);
		ArrayUtils.printArr(arr);
		process(arr, 0, arr.length - 1);
		ArrayUtils.printArr(arr);
	}

	private static void process(int[] arr, int left, int right) {
		if(arr == null || arr.length == 1){
			return;
		}
		
		if(left < right){
			int mid = left + ((right - left)>>1);
			process(arr, left, mid);
			process(arr, mid + 1, right);
			mergeSort(arr, left, right, mid);
		}
		
	}

	private static void mergeSort(int[] arr, int left, int right, int mid) {
		int[] help = new int[right - left + 1];
		
		int k = 0;
		int i = left;
		int j = mid + 1;
		
		while(i <= mid && j <= right){
			help[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
		}
		
		while(i <= mid){
			help[k++] = arr[i++];
		}
		
		while(j <= right){
			help[k++] = arr[j++];
		}
		
		for(int m = 0; m < help.length; m++){
			arr[left + m] = help[m];
		}
	}
}
