package com.dsalgo.trees;

/**
 * given a binary tree root, from node and to node, find shortest path between them.
 *
 * TODO -
 *
 * @author Srinath.Rayabarapu
 */
public class BinaryTreeShortestPathMain {

    public static void main(String[] args) {

    }
}

class BinaryTree{

    public void shortestPath(Node root, int from, int to){
        if(root == null){
            return;
        }

        if(root.value == from){
            System.out.println(from);
            calculateDistance(root, root.left, to, true);
            calculateDistance(root, root.right, to, false);
        } else if(root.value == to){
            System.out.println(to);
            calculateDistance(root, root.left, from, true);
            calculateDistance(root, root.right, from, false);
        } else {
            shortestPath(root.left, from, to);
            shortestPath(root.right, from, to);
        }
    }

    private void calculateDistance(Node parent, Node left, int to, boolean isLeft) {

        if(left == null){
            if(parent != null && parent.value != to && parent.parent != null && isLeft){
                calculateDistance(parent.parent.parent, parent.parent, to, false);
            }
            if(parent != null && parent.value != to && parent.parent != null && !isLeft){
                calculateDistance(parent.parent.parent, parent.parent, to, true);
            }
            return;
        }

        if(left.value == to){
            System.out.println(to);
        } else {
            calculateDistance(left, left.left, to, true);
            calculateDistance(left, left.right, to, false);
        }
    }

}

class Node{
    int value;
    Node left;
    Node right;
    Node parent;
}