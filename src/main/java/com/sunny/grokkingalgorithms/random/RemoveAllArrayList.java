package com.sunny.grokkingalgorithms.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by sundas on 5/18/2018.
 */
public class RemoveAllArrayList {

  /**
   *
   * @param input
   * @param indices
   */
  public static void removeAll(List input,Integer[] indices){
    if(input != null && indices != null){
      Comparator integerComparator = (o1, o2) -> {if ((Integer) o1 > (Integer) o2) {
        return -1;
      }else if((Integer) o1 < (Integer) o2){
        return 1;
      }
      else{
        return 1;
      }
      };
      Arrays.sort(indices,integerComparator);
      for(int index : indices){
        input.remove(index);
      }
    }
  }

  public static void main(String[] args) {
    List<Integer> input = new ArrayList<>();
    input.add(1);
    input.add(2);
    input.add(3);
    input.add(4);
    input.add(5);
    input.add(6);
    input.add(7);
    input.add(8);
    System.out.println(input);
    Integer[] indices = new Integer[4];
    indices[0] = new Integer(1);
    indices[1] = new Integer(3);
    indices[2] = new Integer(7);
    indices[3] = new Integer(4);
    removeAll(input,indices);
    System.out.println(input);
  }

}
