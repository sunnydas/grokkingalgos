package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Stack;

public class StoneWall {

	/*
	 * You are going to build a stone wall. The wall should be straight and N meters long, and its thickness should be constant; however, it should have different heights in different places. The height of the wall is specified by an array H of N positive integers. H[I] is the height of the wall from I to I+1 meters to the right of its left end. In particular, H[0] is the height of the wall's left end and H[N−1] is the height of the wall's right end.

The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular). Your task is to compute the minimum number of blocks needed to build the wall.

Write a function:

class Solution { public int solution(int[] H); }

that, given an array H of N positive integers specifying the height of the wall, returns the minimum number of blocks needed to build it.

For example, given array H containing N = 9 integers:

  H[0] = 8    H[1] = 8    H[2] = 5
  H[3] = 7    H[4] = 9    H[5] = 8
  H[6] = 7    H[7] = 4    H[8] = 8
the function should return 7. The figure shows one possible arrangement of seven blocks.



Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array H is an integer within the range [1..1,000,000,000].
	 */
	
	public static int solution(int[] H) {
		/*
		 * i.   set block count = 1 and start iterating from the 2nd element of the array

ii.  if the current depth is same as previous, keep going

iii. If the current depth is higher, push that in the stack and increase the count

iv.  If the current depth is lower, keep popping till the current depth >= peek. 
Afterward, if the stack size = 0 or higher, increase the block count by 1
		 */
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(H[0]);
		int count = 1;
		for(int i = 1; i < H.length ; i++) {
			int currentHeight = H[i];
			//System.out.println(stack);
			if(!stack.isEmpty() && currentHeight == stack.peek()) {
				continue;				
			}
			if(!stack.isEmpty() && currentHeight > stack.peek()) {
				stack.push(currentHeight);
				count++;
			}else if(!stack.isEmpty() 
					&& currentHeight < stack.peek()) {
				/*
				 * Essentially find a block or at least find a place 
				 * where the blokc might fit.
				 */
				while(!stack.isEmpty() 
						&& stack.peek() > currentHeight ) {
					stack.pop();
				}
				if (!stack.isEmpty() && H[i] == stack.peek()) {
	                    continue;
	             }
				stack.push(H[i]);
				count++;
			}
		}
		return count;		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] h = new int[] {8,8,5,7,9,8,7,4,8};
        System.out.println(solution(h));
	}

}
