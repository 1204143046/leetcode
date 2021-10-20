package com.ls.basic.search;

import java.util.Arrays;

import com.ls.common.ArrayUtils;

public class BSSearch {

	public static void main(String[] args) {
		int[] arr = ArrayUtils.buildRandomArr(10, 10);
//		int[] arr = {0,	0,	1,	1,	3,	3,	4,	7,	9,	10};
		Arrays.sort(arr);
		ArrayUtils.printArr(arr);
		System.out.println(bsSearch(arr, arr[2], 0, arr.length -1));
		System.out.println(bsSearch1(arr, arr[2]));
	}
	
	
	
	public static int bsSearch1(int[] arr, int num){
		
		if(arr == null || arr.length < 1){
			return -1;
		}
		int left = 0;
		int right = arr.length - 1;
		while(left < right){
			int mid = left + ((right - left)>>1);
			
			if(arr[mid] == num){
				return mid;
			}else if(arr[mid] > num){
				right = mid -1;
				
			}else{
				left = mid + 1;
			}
		}
		return -1;
	}
	
	public static int  bsSearch(int[] arr, int num, int low, int high){
		
		if(arr == null || arr.length < 1 || low == high){
			return -1;
		}
		
		int mid = (low + high) / 2  + 1;
		if(arr[mid] > num){
			
			high = mid;
		}else if(arr[mid] == num){
			return mid;
		}else{
			low = mid;
		}
		
		return bsSearch(arr, num, low, high);
		
	}
}
