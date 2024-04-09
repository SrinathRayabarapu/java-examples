package com.dsalgo.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.scaler.com/topics/right-view-of-a-binary-tree/
 *
 * TC: O(n)
 * SC: O(n)
 */
public class PrintRightViewOfBTree {

    public static void main(String[] args) {

        TreeNode root = TreeUtil.create6NodesTree();
        root.leftChild.leftChild.leftChild = new TreeNode(5, "five");

        List<Integer> list = new ArrayList<>();

        printRightView(root, list, 0);

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
    private static void printRightView(TreeNode root, List<Integer> list, int currLevel) {
        if(root == null)
            return;

        if(list.size() == currLevel){
            list.add(root.data);
        }

        printRightView(root.rightChild, list, currLevel + 1);
        printRightView(root.leftChild, list, currLevel + 1);
    }

}