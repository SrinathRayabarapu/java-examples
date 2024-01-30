package com.dsalgo.trees;

import java.util.*;

/**
 * given a root node of the tree, print the tree elements in level order
 */
public class LevelOrderTraversalsMain {

    public static void main(String[] args) {

        TreeNode root = TreeUtil.create6NodesTree();

        levelOrder(root);

        levelOrderSpiral(root);

    }

    /**
     * using two stacks
     *
     * @param root
     */
    private static void levelOrderSpiral(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);

        while (!s1.isEmpty() || !s2.isEmpty()){

            while (!s1.isEmpty()){
                TreeNode node = s1.pop();
                System.out.print(node.data + " ");

                if(node.leftChild != null){
                    s2.push(node.leftChild);
                }
                if(node.rightChild != null){
                    s2.push(node.rightChild);
                }
            }

            while (!s2.isEmpty()){
                TreeNode node = s2.pop();
                System.out.print(node.data + " ");

                if(node.rightChild != null){
                    s1.push(node.rightChild);
                }
                if(node.leftChild != null){
                    s1.push(node.leftChild);
                }
            }

        }

    }

    /**
     * Using single queue
     *
     * TC : O(n)
     * SC : O(n)
     *
     * @param root
     */
    private static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> listList = new ArrayList<>();

        queue.offer(root);

        while (!queue.isEmpty()){

            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i <size; i++) {
                if(queue.peek().leftChild != null){
                    queue.offer(queue.peek().leftChild);
                }
                if(queue.peek().rightChild != null){
                    queue.offer(queue.peek().rightChild);
                }
                list.add(queue.poll().data);
            }
            listList.add(list);
        }

        listList.forEach(l -> System.out.println(l));
    }

}
