package com.dsalgo.trees;

import java.util.ArrayList;
import java.util.List;

public class PrintLeftViewOfBTree {

    public static void main(String[] args) {

        TreeNode root = TreeUtil.create6NodesTree();
        root.rightChild.rightChild.leftChild = new TreeNode(5, "five");

        List<Integer> list = new ArrayList<>();

        printLeftView(root, list, 0);

        System.out.println(list);
    }

    /**
     * TC: O(n)
     * SC: O(h) where h is the height of the tree
     *
     * @param root
     * @param list
     * @param currLevel
     */
    private static void printLeftView(TreeNode root, List<Integer> list, int currLevel) {
        if(root == null){
            return;
        }

        if(list.size() == currLevel){
            list.add(root.data);
        }

        printLeftView(root.leftChild, list, currLevel + 1);
        printLeftView(root.rightChild, list, currLevel + 1);
    }

}
