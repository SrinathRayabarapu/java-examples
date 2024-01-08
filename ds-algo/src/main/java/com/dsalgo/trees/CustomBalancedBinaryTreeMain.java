package com.dsalgo.trees;

/**
 * given a sorted array, create a balanced binary search tree.
 * <p>
 * logic:
 * get middle element - create it as root
 * get left sub array middle element and assign it to root left child
 * get right sub array middle element and assign it to root right child
 * do these steps recursively
 *
 * @author Srinath.Rayabarapu
 */
public class CustomBalancedBinaryTreeMain {

    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 100};

    public static void main(String[] args) {

        // array based
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 100};
        TreeNode binarySearchTreeNode = createBalancedBinaryTree(array, 0, array.length - 1);
        boolean isBst = IsBinarySearchTreeRecursiveMain.isBST(binarySearchTreeNode);
        System.out.println("Binary Tree is balanced - " + isBst);

        // node based
        CustomBinaryTree bTree = new CustomBinaryTree();
        bTree.addNode(10, "one");
        bTree.addNode(20, "two");
        bTree.addNode(30, "three");
        bTree.addNode(40, "four");
        bTree.addNode(50, "five");
        bTree.addNode(60, "six");
        bTree.addNode(70, "seven");

        createBalancedBinaryTreeNodeBased(bTree);
    }

    /**
     * node based
     *
     * @param root
     */
    private static void createBalancedBinaryTreeNodeBased(CustomBinaryTree root) {

        // TODO -


    }

    /**
     * Note: this only works if array is sorted!!
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static TreeNode createBalancedBinaryTree(int[] array, int start, int end) {

        if (start > end)
            return null;

        // finding mid - correct way!
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(array[mid], "");

        node.leftChild = createBalancedBinaryTree(array, start, mid - 1);
        node.rightChild = createBalancedBinaryTree(array, mid + 1, end);

        return node;
    }

}