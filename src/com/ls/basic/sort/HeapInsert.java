package com.ls.basic.sort;

import com.ls.common.ArrayUtils;

public class HeapInsert {

	public static void main(String[] args) {
//		int[] arr = ArrayUtils.buildRandomArr(7, 10);
		int[] arr = {4,	8,	8,	5,	10,	7,	5};
		ArrayUtils.printArr(arr);
		sort(arr, 0);
		ArrayUtils.printArr(arr);
		System.out.println(heapify(arr, 1));
		ArrayUtils.printArr(arr);
	}

	private static void copyArr(int[] arr, int[] arr2) {
		for(int i = 0; i < arr.length; i++){
			arr2[i] = arr[i];
		}
	}

	private static void sort(int[] arr, int i) {
		if(arr == null || arr.length < 2){
			return;
		}
		for(; i < arr.length; i++){
			heapInsert1(arr, i);
		}
		
	}

	private static void heapInsert1(int[] arr, int i) {
		while(arr[i] > arr[( i - 1) / 2]){
			swap(arr, i , ( i - 1) / 2);
			i = ( i - 1) / 2;
		}
	}

	private static void heapInsert(int[] arr, int i) {

		if(i == 0){
			arr[i] = arr[0];
		}
		if(i > 0){
			if(arr[i] > arr[(i - 1) / 2]){
				swap(arr, i, (i - 1) / 2);
			}
			heapInsert(arr, (i - 1) / 2);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	private static int heapify(int[] arr, int num){
		if(arr != null){
			int max = arr[0];
			arr[0] = num;
			int i = 0;
			int max_left = getMax(arr, i, i * 2 + 1);
			int max_right = getMax(arr, i, i * 2 + 2);
			while(i != Math.max(max_left, max_right)){
				swap(arr, i, Math.max(max_left, max_right));
				i = Math.max(max_left, max_right);
				max_left = getMax(arr, i, i * 2 + 1);
				max_right = getMax(arr, i, i * 2 + 2);
			}
						
			return max;
		}
		return -1;
	}
	private static int getMax(int[] arr, int i, int j) {
		if(i < arr.length && j < arr.length){
			if(arr[i] > arr[j]){
				return i;
			}else{
				return j;
			}
		}else if(i < arr.length){
			return i;
		}else if(j < arr.length){
			return j;
		}
		return -1;
	}

}
