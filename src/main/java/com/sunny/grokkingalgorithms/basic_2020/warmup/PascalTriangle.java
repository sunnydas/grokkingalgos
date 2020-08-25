package com.sunny.grokkingalgorithms.basic_2020.warmup;

public class PascalTriangle {
	
	/*
	 * 1  
1 1 
1 2 1 
1 3 3 1 
1 4 6 4 1 
1 5 10 10 5 1 
	 */
	
	public static void pascaltriangle(int n) {
		int[][] p = new int[n][n];
		for(int i=0; i <p.length;i++) {
			p[i][0]=1;
		}
		for(int i = 1; i < p.length ; i++) {
			for(int j = 1; j < p.length ; j++) {
				p[i][j] = p[i-1][j-1] + p[i-1][j];				
			}
		}
		for(int i = 0 ; i < p.length ; i++) {
			for(int j = 0; j < p[i].length ; j++) {
				System.out.print(p[i][j] + " ");				
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pascaltriangle(6);
	}

}
