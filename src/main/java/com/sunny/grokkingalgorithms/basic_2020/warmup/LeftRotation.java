package com.sunny.grokkingalgorithms.basic_2020.warmup;

public class LeftRotation {

	/*
	 * A left rotation operation on an array shifts each of the array's elements  unit to the left. For example, 
	 * if  left rotations are performed on array , then the array would become .
	 */
	/*
	 * 1,2,3,4,5 => 3,4,5,1,2
	 */
	public static int[] leftRotate(int[] input,int d) {
		int[] rotated = new int[input.length];
		for(int i = 0; i < input.length ; i++) {
			int next = Math.floorMod(i - d, input.length);
			rotated[next] = input[i];
		}
		return rotated;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] input = new int[] {1,2,3,4,5};
        int[] rotated = leftRotate(input,2);
        for(int i : rotated) {
        	System.out.println(i);
        }
	}

}
