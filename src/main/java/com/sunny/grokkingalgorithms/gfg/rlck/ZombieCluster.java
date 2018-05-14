package com.sunny.grokkingalgorithms.gfg.rlck;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by sundas on 5/13/2018.
 */
public class ZombieCluster {


  /**
   *
   * @param zombies
   * @return
   */
  public static int zombieCluster(String[] zombies){
    int zombieClusters = 0;
    Set<Set<Integer>> consideredIndexes = new HashSet<>();
    for(int i = 0 ; i < zombies.length ; i++) {
      Set<Integer> currentCluster = new HashSet<>();
      populateZombieCluster(currentCluster, zombies, i,consideredIndexes);
      if(currentCluster.size() > 0){
        consideredIndexes.add(currentCluster);
      }
    }
    System.out.println(consideredIndexes);
    zombieClusters = consideredIndexes.size();
    return zombieClusters;
  }

  /**
   *
   * @param currentCluster
   * @param zombies
   * @param index
   * @param consideredIndexes
   */
  public static void populateZombieCluster(Set<Integer> currentCluster,String[] zombies,int index
  ,Set<Set<Integer>> consideredIndexes){
    if(index > zombies.length){
      return;
    }
    String currentZombie = zombies[index];
    if(currentZombie.charAt(index) == '1' && !alreadyConsideredIndex(consideredIndexes,index)){
      currentCluster.add(index);
    }
    for(int i = index+1; i < currentZombie.length() ;i++){
      if(currentZombie.charAt(i) == '1') {
        populateZombieCluster(currentCluster, zombies, i, consideredIndexes);
      }
    }
  }


  /**
   *
   * @param consideredIndexes
   * @param index
   * @return
   */
  public static boolean alreadyConsideredIndex(Set<Set<Integer>> consideredIndexes,int index){
    boolean considered = false;
    Iterator<Set<Integer>> iterator = consideredIndexes.iterator();
    while(iterator.hasNext()){
      Set<Integer> cluster = iterator.next();
      if(cluster.contains(index)){
        considered = true;
        break;
      }
    }
    return considered;
  }



  public static void main(String[] args) {
      String[] zombies = new String[]{
          "1100",
          "1110",
          "0110",
          "0001"
      };
    System.out.println(zombieCluster(zombies));
    System.out.println("#########");
    zombies = new String[]{
        "1000",
        "010",
        "0010",
        "0001"
    };
    System.out.println(zombieCluster(zombies));
    System.out.println("#####################");
    zombies = new String[]{
        "1001",
        "010",
        "0010",
        "1001"
    };
    System.out.println(zombieCluster(zombies));
    System.out.println("#######################");
  }

}
