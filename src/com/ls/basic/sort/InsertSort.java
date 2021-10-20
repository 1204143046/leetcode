package com.ls.basic.sort;

import com.ls.common.ArrayUtils;

public class InsertSort {

	public static void main(String[] args) {
		int[] arr = ArrayUtils.buildRandomArr(5,10);
		ArrayUtils.printArr(arr);
		insertSort(arr);
		ArrayUtils.printArr(arr);
	}
	
	public static void  insertSort(int[] arr){
		if(arr == null || arr.length < 2){
			return;
		}
		
		for(int i = 1; i < arr.length; i++){
//			int tmp = arr[i];
			for(int j = i; j > 0; j--){
				if(arr[j] < arr[j - 1]){
					swap(arr, j, j - 1);
				}
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		if(i != j){
			//i j是一个位置的话，是有问题的
			arr[i] = arr[i] ^ arr[j];
			arr[j] = arr[i] ^ arr[j];
			arr[i] = arr[i] ^ arr[j];
		}
		// TODO Auto-generated method stub
		
	}
}
