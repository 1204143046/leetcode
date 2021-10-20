package com.ls.basic.search;

import java.util.Arrays;

import com.ls.common.ArrayUtils;

/**
 * 局部最小值
 * @author l20095
 *
 */
public class FindOneLessValueIndex {

	
	public static void main(String[] args) {
//		int[] arr = ArrayUtils.buildRandomArr(5, 10);
		int[] arr = {1,6,6,6,7};
		ArrayUtils.printArr(arr);
		System.out.println(find(arr));
	}
	
	public static int find(int[] arr){
		if(arr == null || arr.length == 1){
			return -1;
		}
		int len = arr.length;
		if(arr[len - 1] < arr[len - 2]){
			return len - 1;
		}
		int left = 1;
		int right = len - 2;
		while(left < right){
			int mid = left + ((right - left)>>1);
			if(arr[mid] > arr[mid -1]){
				right = mid - 1;
			}else if(arr[mid] > arr[mid + 1]){
				left = mid + 1;
			}else{
				return mid;
			}
		}
		
		return left;
	}
}
