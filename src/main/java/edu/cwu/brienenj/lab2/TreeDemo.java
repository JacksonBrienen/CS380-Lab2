package edu.cwu.brienenj.lab2;

import java.util.Arrays;

public class TreeDemo {
    public static void main(String[] args){
        BinarySearchTree t1  = new BinarySearchTree();
        t1.insert(24);
        t1.insert(80);
        t1.insert(18);
        t1.insert(9);
        t1.insert(90);
        t1.insert(22);
         
        System.out.printf("%-12s: %s\n", "in-order", Arrays.toString(t1.inOrderTraversal())); 
        System.out.printf("%-12s: %s\n", "pre-order", Arrays.toString(t1.preOrderTraversal()));
        System.out.printf("%-12s: %s\n", "post-order", Arrays.toString(t1.postOrderTraversal()));

        System.out.printf("%-12s: %b\n", String.format("contains %d", 96), t1.find(96));
        System.out.printf("%-12s: %b\n", String.format("contains %d", 4), t1.find(4));
        System.out.printf("%-12s: %b\n", String.format("contains %d", 19), t1.find(19));
        System.out.printf("%-12s: %b\n", String.format("contains %d", 22), t1.find(22));
    }
}
