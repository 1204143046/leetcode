package com.ls.basic.sort;

import com.ls.common.ArrayUtils;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = ArrayUtils.buildRandomArr(5, 10);
//		int[] arr ={3};
		ArrayUtils.printArr(arr);
		sortAsc(arr);
		ArrayUtils.printArr(arr);
	}
	
	
	
	public static void sortAsc(int[] arr){
		if(arr != null && arr.length > 0){
			
			for(int i = 0; i < arr.length - 1; i++){
				for(int j = i + 1; j < arr.length; j++){
					if(arr[j] < arr[i]){
						int tmp = arr[j];
						arr[j] = arr[i];
						arr[i] = tmp;
					}
				}
				
			}
		}
	}
}
