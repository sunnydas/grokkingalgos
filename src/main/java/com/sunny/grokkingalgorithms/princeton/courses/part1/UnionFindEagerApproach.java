package com.sunny.grokkingalgorithms.princeton.courses.part1;

import java.util.Scanner;

/**
 * Created by sundas on 2/3/2018.
 */
public class UnionFindEagerApproach {

  /*
  Goal. Design efficient data structure for union-find.
?Number of objects N can be huge.
?Number of operations M can be huge.
?Find queries and union commands may be intermixed.
Union-find data type (API)
public class UF
UF(int N)
initialize union-find data structure with
N objects (0 to N – 1)
void union(int p, int q) add connection between p and q
boolean connected(int p, int q) are p and q in the same component?
int find(int p) component identifier for p (0 to N – 1)
int count() number of components
   */

  public UnionFindEagerApproach(int numberOfObjects) {
    idArray = new int[numberOfObjects];
    populateIdArray();
  }

  /**
   * Initial seeding
   *
   */
  private void populateIdArray(){
    /*
    Initial population the value at each index is equal to the index which is its id
    for example:
    [0,1,2,3,4,5]
     */
    for(int i = 0 ; i < idArray.length ; i++){
      idArray[i] = i;
    }
  }

  private int[] idArray;

  /**
   * In this implementation we update every id of q eith p
   *
   *
   * @param p
   * @param q
   */
   public void union(int p,int q){
     if(p < idArray.length && q < idArray.length) {
       for (int i = 0; i < idArray.length; i++) {
         // Update id of q to p to represent connection
         if (idArray[i] == idArray[q]) {
           idArray[i] = idArray[p];
         }
       }
     }
   }

  /**
   * This is to check if there is a connection from p to q, which essentially means to check if id reprsented at
   * index p is equal id represented at index q
   *
   * @param p
   * @param q
   * @return
   */
   public boolean isConnected(int p,int q){
     boolean connected = false;
     if(p < idArray.length && q < idArray.length) {
       if (idArray[p] == idArray[q]) {
         connected = true;
       }
     }
     return connected;
   }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    /*
    Client driver program
     */
    Scanner scanner = new Scanner(System.in);
    int numberOfObjects = scanner.nextInt();
    UnionFindEagerApproach uf = new UnionFindEagerApproach(numberOfObjects);
    int numberOfUnionOperations = scanner.nextInt();
    for(int i = 0 ; i < numberOfUnionOperations ; i++){
      int p = scanner.nextInt();
      int q = scanner.nextInt();
      uf.union(p,q);
      System.out.println(uf.isConnected(p,q));
    }
    int numberOfFindOperations = scanner.nextInt();
    for(int i = 0 ; i < numberOfFindOperations ; i++){
      int p = scanner.nextInt();
      int q = scanner.nextInt();
      System.out.println("Is p = " + p + " connected to q = " + q);
      System.out.println(uf.isConnected(p,q));
    }
  }


}
