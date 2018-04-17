package com.sunny.grokkingalgorithms.design_patterns.iterator;

import com.sunny.grokkingalgorithms.ctc.c2.util.LinkedListUtil;
import com.sunny.grokkingalgorithms.ctc.c2.util.Node;
import com.sunny.grokkingalgorithms.design_patterns.iterator.impl.ArrayIterator;
import com.sunny.grokkingalgorithms.design_patterns.iterator.impl.LinkedListIterator;

/**
 * Created by sundas on 4/17/2018.
 */
public class IteratorPattern {

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Integer[] array = new Integer[]{1,2,3,4,5};
    int[] input = new int[]{7,8,9,10};
    Node node = LinkedListUtil.createLinkedList(input);
    CustomIterator<Integer> customIterator = new ArrayIterator<>(array);
    CustomIterator<Node> nodeCustomIterator = new LinkedListIterator<>(node);
    while(customIterator.hasNext()){
      System.out.println(customIterator.next());
    }
    System.out.println("linked list");
   while(nodeCustomIterator.hasNext()){
      System.out.println(nodeCustomIterator.next().data);
    }
  }

}
