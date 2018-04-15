package com.sunny.grokkingalgorithms.gfg.vmw;

/**
 * Created by sundas on 4/15/2018.
 */
public class SieveOfErastosthenis {

  /*
  Following is the algorithm to find all the prime numbers less than or equal to a given integer n by Eratosthenes’ method:

Create a list of consecutive integers from 2 to n: (2, 3, 4, …, n).
Initially, let p equal 2, the first prime number.
Starting from p, count up in increments of p and mark each of these numbers greater than p itself in the list. These numbers will be 2p, 3p, 4p, etc.; note that some of them may have already been marked.
Find the first number greater than p in the list that is not marked. If there was no such number, stop. Otherwise, let p now equal this number (which is the next prime), and repeat from step 3.
   */

  /**
   *
   */
  public static void sieveOfEratosthenis(int n){
    boolean[] sieve = new boolean[n+1];
    for(int i = 0 ; i < sieve.length ; i++ ){
      sieve[i] = true;
    }
    for(int i = 2 ; i <= Math.sqrt(n) ; i++){
      if(sieve[i]){
        for(int j = 2*i ; j <= n ; j += i){
          sieve[j] = false;
        }
      }
    }
    for(int i = 2; i <= n ; i++){
      if(sieve[i]) {
        System.out.print(i + " ");
      }
    }
    System.out.println();
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    sieveOfEratosthenis(100);
  }

}
