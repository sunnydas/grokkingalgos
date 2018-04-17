package com.sunny.grokkingalgorithms.design_patterns.iterator.impl;


import com.sunny.grokkingalgorithms.ctc.c2.util.Node;
import com.sunny.grokkingalgorithms.design_patterns.iterator.CustomIterator;

/**
 * Created by sundas on 4/17/2018.
 */
public class LinkedListIterator<T> implements CustomIterator<T>{


  public LinkedListIterator(Node node) {
    this.node = node;
    this.head = node;
  }

  private Node node;

  private Node head;




  @Override
  public boolean hasNext() {
    if(node != null){
      return true;
    }
    return false;
  }

  @Override
  public T next() {
    Node cur = null;
    if(this.node != null){
      cur = node;
      this.node = this.node.next;
    }
    return (T) cur;
  }

  @Override
  public T first() {
    return (T) head;
  }
}
