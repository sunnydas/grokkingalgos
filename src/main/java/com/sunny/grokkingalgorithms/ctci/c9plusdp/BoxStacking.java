package com.sunny.grokkingalgorithms.ctci.c9plusdp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sundas on 4/19/2018.
 */
class Box{
  int width;
  int height;

  @Override
  public String toString() {
    return "Box{" +
        "width=" + width +
        ", height=" + height +
        ", depth=" + depth +
        '}';
  }

  int depth;
}
public class BoxStacking {

  /*
  Stack boxes of given weight , height and depth such that height of stack is maximum with a constraint that
   width,height and depth of a bottom should always be larger than the width,height and depth of the box above it.
   */


  /**
   *
   * @param boxes
   * @param bottom
   * @return
   */
  public static List<Box> findMaxStack(Box[] boxes,Box bottom){
    int maxHeight = 0;
    List<Box> maxStack = null;
    for(int i = 0 ; i < boxes.length ;i++){
      if(canBeAbove(boxes[i],bottom)){
        List<Box> newStack = findMaxStack(boxes,boxes[i]);
        if(newStack != null && newStack.size() > maxHeight){
          maxHeight = newStack.size();
          maxStack = newStack;
        }
      }
    }
    if(maxStack == null){
      maxStack = new ArrayList<>();
    }
    if(bottom != null){
      maxStack.add(0,bottom);
    }
    return maxStack;
  }

  public static boolean canBeAbove(Box current,Box bottom){
    boolean possible = false;
    if(bottom == null){
      possible = true;
    }
    else if(current != bottom && current.height < bottom.height &&
        current.width < bottom.width && current.depth < bottom.depth){
      possible = true;
    }
    return possible;
  }




  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Box box = new Box();
    box.height = 2;
    box.width = 3;
    box.depth = 5;
    Box box1 = new Box();
    box1.height = 1;
    box1.width = 1;
    box1.depth = 1;
    Box box2 = new Box();
    box2.height = 7;
    box2.width = 8;
    box2.depth = 9;
    Box[] boxes = new Box[]{box1,box,box2};
    System.out.println(findMaxStack(boxes,null));
  }


}
