package com.sunny.grokkingalgorithms.gfg.az.util;

/**
 * Created by sundas on 4/7/2017.
 */
public class BinaryNode {

  private BinaryNode right;

  private BinaryNode left;

  private int data;

  public BinaryNode getRight() {
    return right;
  }

  @Override
  public String toString() {
    return "BinaryNode{" +
        "right=" + right +
        ", left=" + left +
        ", data=" + data +
        '}';
  }

  public void setRight(BinaryNode right) {
    this.right = right;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    BinaryNode that = (BinaryNode) o;

    if (getData() != that.getData()) return false;
    if (getRight() != null ? !getRight().equals(that.getRight()) : that.getRight() != null) return false;
    return !(getLeft() != null ? !getLeft().equals(that.getLeft()) : that.getLeft() != null);

  }

  @Override
  public int hashCode() {
    int result = getRight() != null ? getRight().hashCode() : 0;
    result = 31 * result + (getLeft() != null ? getLeft().hashCode() : 0);
    result = 31 * result + getData();
    return result;
  }

  public BinaryNode getLeft() {
    return left;
  }

  public void setLeft(BinaryNode left) {
    this.left = left;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }
}
