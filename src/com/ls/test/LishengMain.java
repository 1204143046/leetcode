package com.ls.test;

public class LishengMain {
	public static void main(String[] args) {
		int[][] relation= {{2,1},{0,2},{0,4},{3,4},{2,3},{1,4},
				{2,0}};
		System.out.println(fromKTo(4, relation,3));
	}
	
	
	
	public static int fromKTo(int n, int[][]relation, int k){
		int[][] dp = new int[k + 1][n + 1];
		
		dp[0][0] = 1;
		for(int i = 0; i < k ; i++){
			for(int[] edge: relation){
				int src = edge[0];
				int dest = edge[1];
				dp[i + 1][dest] += dp[i][src];
			}
		}
		
		return dp[k][n];
	}
}
