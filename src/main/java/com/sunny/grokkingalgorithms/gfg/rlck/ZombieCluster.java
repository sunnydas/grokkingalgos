package com.sunny.grokkingalgorithms.gfg.rlck;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sundas on 5/13/2018.
 */
public class ZombieCluster {


  public static int zombieCluster(String[] zombies){
    int zombieClusters = 0;
    Set<Set<Integer>> consideredIndexes = new HashSet<>();
    populateZomibieClusters(consideredIndexes,zombies,0);
    return zombieClusters;
  }

  public static void populateZomibieClusters(Set<Set<Integer>> consideredIndexes,String[] zombies,int index){
    if(index > zombies.length){
      return;
    }
    
  }


  public static boolean alreadyConsideredIndex(Set<Set<Integer>> consideredIndexes,int index){
    return false;
  }



  public static void main(String[] args) {
      String[] zombies = new String[]{
          "1100",
          "1110",
          "0110",
          "0001"
      };
    System.out.println(zombieCluster(zombies));
  }

}
