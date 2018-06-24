package com.sunny.grokkingalgorithms.fasttrack.week2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sundas on 6/24/2018.
 */
public class KNumbersInAnArrayThatAddToC {

  /*
  K numbers in array that sum to C
  In general, when k is even, we have the following algorithm:

Compute a set S that stores all the sums of all the k/2-element tuples of the original array
Look at every k/2 tuple of elements in the original array, and compute its sum s. If C?s?S, we found a solution
This is O(nk2)

When k is odd, we have the following algorithm:

Compute a set S that stores all the sums of all the (k?1)/2-element tuples of the original array.
Look at every (k+1)/2-element tuple in the original array, and compute its sum s. If C?s, we found a solution.
This is O(nk+12)

We have VMs of sizes 6, 9, 20. How do we determine whether we can provide VM's clients requirement.
Ex 35 (20+9+6) or 18
(6+6+6 or 9+9)

   */

  /**
   *
   * @return
   */
  public static Set<Set<Integer>> getPlacement(int[] vms,int k){
    Set<Set<Integer>> placements = new HashSet<>();
    Set<Integer> holder = new HashSet<>();
    for(int i = 0 ; i < vms.length ; i++){
      holder.add(vms[i]);
    }
    for(int i = 0 ; i < vms.length ; i++){
      for(int j = i ; j < vms.length ;j++){
        int s = vms[i] + vms[j];
        if(holder.contains(k - s)){
          Set<Integer> placement = new HashSet<>();
          placement.add(vms[i]);
          placement.add(vms[j]);
          placement.add(k - s);
          placements.add(placement);
        }
      }
    }
    return placements;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] vms = new int[]{6,9,20};
    System.out.println(getPlacement(vms,35));
    System.out.println(getPlacement(vms,18));
  }

}
