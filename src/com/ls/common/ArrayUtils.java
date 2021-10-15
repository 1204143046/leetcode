package com.ls.common;

public class ArrayUtils {

	public static int[] buildAscArr(int size){
		int [] arr = new int[size];
		for(int i = 0; i < size; i++){
			arr[i] = i + 1;
		}
		return arr;
	}
	
	public static int[] buildRandomArr(int size, int max){
		int [] arr = new int[size];
		for(int i = 0; i < size; i++){
			arr[i] = (int)Math.round((max * Math.random()));
		}
		
		return arr;
	}
	
	public static void printArr(int []arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int [] arr = buildRandomArr(10, 10);
		printArr(arr);
	}
}
