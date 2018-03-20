package com.sunny.grokkingalgorithms.ctci.c4.util;

public class BinaryTreeNode{
  public BinaryTreeNode left;
  public BinaryTreeNode right;
  public int data;

  @Override
  public String toString() {
    return "BinaryTreeNode{" +
        "left=" + left +
        ", right=" + right +
        ", data=" + data +
        '}';
  }
}