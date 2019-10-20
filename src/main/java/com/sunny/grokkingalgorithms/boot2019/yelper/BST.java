package com.sunny.grokkingalgorithms.boot2019.yelper;
class Node{
    public Node left;
    public Node right;
    public int data;

    @Override
    public String toString() {
        return "Node{" +
                "left=" + left +
                ", right=" + right +
                ", data=" + data +
                '}';
    }
}
public class BST {


    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    public static Node insertIntoBST(int data, Node root){
        if(root == null){
            root = new Node();
            root.data = data;
            return root;
        }
        if(data < root.data){
            root.left = insertIntoBST(data,root.left);
        }
        else if(data > root.data){
            root.right = insertIntoBST(data,root.right);
        }
        return root;
    }

    public static boolean searchInBST(Node root,int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        if(key < root.data){
            return searchInBST(root.left,key);
        } else{
            return searchInBST(root.right,key);
        }
    }


    public static void main(String[] args) {
        int[] input = new int[]{8,4,12,3,10,5,2,20,1};
        Node root = null;
        for(int i = 0 ; i < input.length ; i++){
            root = insertIntoBST(input[i],root);
        }
        System.out.println(root);
        inOrder(root);
        System.out.println(searchInBST(root,5));
        System.out.println(searchInBST(root,1));
        System.out.println(searchInBST(root,8));
        System.out.println(searchInBST(root,3));
        System.out.println(searchInBST(root,100));
    }

}
