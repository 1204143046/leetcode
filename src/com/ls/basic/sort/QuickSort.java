package com.ls.basic.sort;

import com.ls.common.ArrayUtils;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = ArrayUtils.buildRandomArr(5, 10);
//		int[] arr = {9	,1,	4,	2,	6};
		ArrayUtils.printArr(arr);
		sort(arr, 0, arr.length - 1);
//		System.out.println(index);
		ArrayUtils.printArr(arr);
	}
	
	public static void sort(int[] arr, int low, int high){
		int index = getIndex(arr, low, high);
		if(low < high){
			
			sort(arr, low, index - 1);
			sort(arr, index+1 , high);
		}
	}
	
	public static int getIndex(int[] arr, int low, int high){
		
		if(arr != null && arr.length > 0){
			while(low < high){
				int pivot = arr[low];
				while(low < high && arr[high]>=pivot){
					high--;
				}
				if(low < high){
					swap(arr, low,high);
				}
				
				while(low < high && arr[low] <= pivot){
					low++;
				}
				if(low<high){
					swap(arr, low,high);
				}
			}
		}
		return low;
	}


	public static void swap(int[] arr, int low, int high){
		int tmp = arr[high];
		arr[high] = arr[low];
		arr[low] = tmp;
	}
}
