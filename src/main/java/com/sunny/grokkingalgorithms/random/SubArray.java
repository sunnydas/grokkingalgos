package com.sunny.grokkingalgorithms.random;

/**
 * Created by sundas on 3/1/2018.
 */
public class SubArray {

  /*
  Find starting position of sub array in the main array
   */

  public static int findArray(int[] array, int[] subArray) {
    int startPos = -1;
    if(array != null && subArray != null){
      for(int i = 0 ; i < array.length ; i++){
        int curIndex = i;
        if(isSubArrayContainedIn(curIndex,array,subArray)){
          startPos = i;
          break;
        }
      }
    }
    return startPos;
  }

  public static boolean isSubArrayContainedIn(int start,int[] searchArr,int[] subArray){
    boolean contained = false;
    int index = start;
    int subIndex = 0;
    while(index < (searchArr.length - 1) && subIndex < subArray.length - 1){
      if(searchArr[index] != subArray[subIndex]){
        break;
      }
      index++;
      subIndex++;
    }
    if(subIndex == (subArray.length - 1)){
      contained = true;
    }
    return contained;
  }


  public static void main(String[] args) {
    final int[] array = {4, 9, 3, 7, 8};
    final int[] subArray = {3, 7};

    //when
    System.out.println(findArray(array,subArray));

  }

}
