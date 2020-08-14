package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FrogRiverOne {
	
	/*
	 * A small frog wants to get to the other side of a river. The frog is initially located on one bank of the river (position 0) and wants to get to the opposite bank (position X+1). Leaves fall from a tree onto the surface of the river.

You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in seconds.

The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river from 1 to X (that is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves). You may assume that the speed of the current in the river is negligibly small, i.e. the leaves do not change their positions once they fall in the river.

For example, you are given integer X = 5 and array A such that:

  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.

Write a function:

class Solution { public int solution(int X, int[] A); }

that, given a non-empty array A consisting of N integers and integer X, returns the earliest time when the frog can jump to the other side of the river.

If the frog is never able to jump to the other side of the river, the function should return −1.

For example, given X = 5 and array A such that:

  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
the function should return 6, as explained above.

Write an efficient algorithm for the following assumptions:

N and X are integers within the range [1..100,000];
each element of array A is an integer within the range [1..X].
	 */
	
	/*
	 * A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
  
  
  
  
  1 - [0,2]
  2 - [4]
  3 - [1,5]
  4 - [3,7]
  5 - [6]
        
  [0,1,2,3,4,5]
  
  [6]   
	 */
	
	public static int solution(int X,int[] A) {
		int earliestTime = -1;
		Map<Integer,LinkedList<Integer>> trackerMap = new HashMap<Integer,
				LinkedList<Integer>>();
		for(int i = 0; i < A.length ; i++) {
			int currentPosition = A[i];
			int currentTime = i;
			if(trackerMap.containsKey(currentPosition)) {
				trackerMap.get(currentPosition).add(i);				
			}else {
				LinkedList<Integer> list = new LinkedList<Integer>();
				list.add(i);
				trackerMap.put(currentPosition, list);
			}
		}
		//System.out.println(trackerMap);
		for(int i = 1; i <= X ; i++) {
			if(trackerMap.containsKey(i)) {
				earliestTime = Math.max(earliestTime, trackerMap.get(i).poll());
			}else {
				earliestTime = -1;
				break;
			}
		}
		return earliestTime;
	}
	
	public static int solutionAlt(int X, int[] A) {
		int earliestTime = -1;
		List<Integer> xsInSchedule = findXsInSchedule(X, A);
		if(!xsInSchedule.isEmpty()) {
			int i = 0;
			for(int index :xsInSchedule) {
				Set<Integer> leafPositionTracker = new LinkedHashSet<Integer>();
				while(i <= index) {
					leafPositionTracker.add(A[i]);
					i++;
				}
				if(validate(X, leafPositionTracker)) {
					earliestTime = index;
					break;
				}
			}
		}
		return earliestTime;
	}
	
	private static boolean validate(int X,Set<Integer> tracker) {
		boolean validated = true;
		if(!tracker.isEmpty()) {
			for(int i = 1; i <= X; i++) {
				if(!tracker.contains(i)) {
					validated = false;
					break;
				}
			}
		}else {
			validated = false;
		}
	    return validated;		
	}
	
    private static List<Integer> findXsInSchedule(int X,int[] A){
    	List<Integer> xsInschedule = new ArrayList<Integer>();
    	for(int i = 0 ; i < A.length ; i++) {
    		if(A[i] == X) {
    			xsInschedule.add(i);    			
    		}
    	}
    	return xsInschedule;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
		 */
		int[] input = new int[] {1,3,1,4,2,3,5,4};
		// 1 - [0,2]
		// 2 - [4]
		// 3 - [1,5]
		// 4 - [3,7]
		// 5 - [6] - 0,4,1,3,6  
		System.out.println(solution(5, input));
		input = new int[] {2,2,2,2,2};
		System.out.println(solution(2, input));	
		/*
		 * For example, for the input (3, [1, 3, 1, 3, 2, 1, 3]) 
		 * the solution returned a wrong answer (got 6 expected 4).
		 */
		/*
		 * 1 - [0,2,5]
		 * 2 - [4]
		 * 3 - [1,3,6]
		 */
		input = new int[] {1,3,1,3,2,1,3};
		System.out.println(solution(3,input));
	}

}
