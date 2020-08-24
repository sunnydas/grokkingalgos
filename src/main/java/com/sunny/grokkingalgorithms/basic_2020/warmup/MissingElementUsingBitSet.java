package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.BitSet;

public class MissingElementUsingBitSet {
	
	public static void findMissingElement(int[] input,int count) {
		BitSet bitSet = new BitSet(count);	
		int missingCount = count - input.length;
		for(int i = 0 ; i < input.length ; i++) {
			bitSet.set(input[i] - 1);			
		}
		int index = 0;
		for(int i = 0 ; i < missingCount ; i++) {
			int lastIndex = bitSet.nextClearBit(index);
			System.out.println(++lastIndex);
			lastIndex++;
			index = lastIndex;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] input = new int[] {1,2,3,4,6,7,8,10};
        findMissingElement(input, 10);
	}

}
