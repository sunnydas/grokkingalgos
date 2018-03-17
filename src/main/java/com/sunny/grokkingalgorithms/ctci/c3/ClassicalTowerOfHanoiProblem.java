package com.sunny.grokkingalgorithms.ctci.c3;

import java.util.Stack;

class Tower{

  private Stack<Integer> disks;

  private String name;

  public Tower(String name){
    this.name = name;
    this.disks = new Stack<>();
  }

  /**
   *
   * @param data
   */
  public void add(int data){
    if(!disks.isEmpty() && data > disks.peek()){
      throw new IllegalArgumentException("Constraint violation");
    }
    else{
      disks.push(data);
    }
  }

  /**
   *
   * @param t
   */
  public void moveTopDiskToTower(Tower t){
    if(!disks.isEmpty() && t != null){
      System.out.println("Moving top of " + this.name + " to tower " + t.name);
      t.add(disks.pop());
    }
  }

  @Override
  public String toString() {
    return "Tower{" +
        "disks=" + disks +
        ", name='" + name + '\'' +
        '}';
  }

  /**
   *
   * @param n
   * @param buffer
   * @param target
   */
  public void moveDisks(int n,Tower buffer,Tower target){
    if(n > 0){
      System.out.println("Move n-1 disks from current " + this.name + " to "+ buffer.name + " using " + target.name + " as buffer");
      moveDisks(n - 1, target, buffer);
      moveTopDiskToTower(target);
      System.out.println("Move n-1 disks from " + buffer.name + " to " + target.name + " using " + this.name + " as buffer");
      buffer.moveDisks(n - 1, this, target);
    }
  }


}
/**
 * Created by sundas on 3/17/2018.
 */
public class ClassicalTowerOfHanoiProblem {

  //Solve the classical tower of hano problem for N stacks and three towers.

  /**
   *
   * @param n
   */
  public  void towerOfHanoi(int n){
    Tower towerA = new Tower("A");
    Tower towerB = new Tower("B");
    Tower towerC = new Tower("C");
    /*
    The ide ais to move all disks from towerA to towerC
     */
    for(int i = n ; i >= 1 ;i--){
      towerA.add(i);
    }
    towerA.moveDisks(n,towerB,towerC);
    System.out.println(towerC);
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    ClassicalTowerOfHanoiProblem towerOfHanoiProblem = new ClassicalTowerOfHanoiProblem();
    towerOfHanoiProblem.towerOfHanoi(1);
    System.out.println("next");
    towerOfHanoiProblem.towerOfHanoi(2);
    System.out.println("next");
    towerOfHanoiProblem.towerOfHanoi(3);
    System.out.println("next");
    towerOfHanoiProblem.towerOfHanoi(4);
    System.out.println("next");
    towerOfHanoiProblem.towerOfHanoi(5);
  }

}
