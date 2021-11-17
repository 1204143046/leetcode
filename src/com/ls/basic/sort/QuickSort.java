package com.ls.basic.sort;

import com.ls.common.ArrayUtils;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = ArrayUtils.buildRandomArr(5, 10);
//		int[] arr = {3, 3	,1,	4,	2,	6};
//		int[] arr = {10,	8,	10,	7,	6};
		ArrayUtils.printArr(arr);
		sort3(arr, 0, arr.length - 1);
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
	
	/**
	 * 把小于等于的都移到左侧，大于的移动到右侧
	 * @param arr
	 * @param low
	 * @param high
	 */
	public static void sort1(int[] arr, int low, int high){
		if(low < high){
			int index = partation(arr, low, high);
			sort1(arr, low, index - 1);
			sort1(arr, index + 1, high);
		}
	}

	private static int partation(int[] arr, int low, int high) {
		int i = low;
		int min_i = low - 1;
		int num = arr[low];
		for(; i <= high; i++){
			if(arr[i] <= num){
				swap(arr, min_i + 1, i);
				min_i++;
			}
		}
		swap(arr, min_i, low);
		return min_i;
	}
	
	/**
	 * 三色国旗，把小于的移动到左边，等于的放到中间，大于的放到右边
	 * @param arr
	 * @param low
	 * @param high
	 */
	public static void sort3(int[] arr, int low, int high){
		
		if(low < high){
			int[] range = partation3(arr, low, high);
			sort3(arr, low, range[0] - 1);
			sort3(arr, range[1] + 1, high);
		}
	}

	private static int[] partation3(int[] arr, int low, int high) {
		int i = low;
		
		int min_i = low - 1;
		int equal_i = min_i;
		int [] res = new int[2];
		int num = arr[low];
		for(;i <= high; i++){
			if(arr[i] <= num){
				swap(arr, equal_i + 1, i);
				if(arr[equal_i + 1] < num){
					min_i++;
					swap(arr, equal_i + 1, min_i);
				}

				equal_i++;
			}
		}
//		swap(arr, equal_i, low);
		res[0] = min_i + 1;
		res[1] = equal_i;
		return res;
	}
}
