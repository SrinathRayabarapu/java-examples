package com.dsalgo.trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * given a binary tree, print top view from left most node to right
 */
public class PrintTopViewOfBinaryTreeMain {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.create6NodesTree();
        root.leftChild.leftChild.leftChild = new TreeNode(5, "five");

        printTopView(root);
    }

    private static void printTopView(TreeNode root) {

        if(root == null){
            return;
        }

        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        queue.offer(new Pair(root, 0));

        while (! queue.isEmpty()){
            Pair pair = queue.poll();

            // add only if there is NO node present at that level
            if(map.get(pair.level) == null){
                map.put(pair.level, pair.node.data);
            }

            // traverse left and decrement level number
            if(pair.node.leftChild != null){
                queue.offer(new Pair(pair.node.leftChild, pair.level-1));
            }

            // traverse right and increment level number
            if(pair.node.rightChild != null){
                queue.offer(new Pair(pair.node.rightChild, pair.level+1));
            }
        }

        // sort the keys(levels) and fetch their values
        map.keySet().stream().sorted().forEach(i -> System.out.print(map.get(i) + " "));
    }

}

class Pair {
    int level;
    TreeNode node;

    public Pair(TreeNode node, int level) {
        this.level = level;
        this.node = node;
    }
}
