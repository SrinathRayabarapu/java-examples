package com.dsalgo.linkedlist;

/**
 * given a linked list, find Nth node from last node.
 *
 * Efficient approach: Single scan
 * 1. Have two pointers slow and fast.
 * 2. Move fast pointer to n places forward
 * 3. Move slow and fast now one place at a time till fast reaches end
 * 3. slow is at nth position!
 *
 * @author srinath.rayabarapu
 */
public class FindNthNodeFromLastLinkedListMain {

    public static void main(String[] args) {

        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(50);
        Node n6 = new Node(60);
        Node n7 = new Node(70);
        Node n8 = new Node(80);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n8);

        findNthNodeFromLast(n1, 2);

//        Object nthNodeFromLastRecursive = findNthNodeFromLastRecursive(n1, 2);
//        System.out.println("Recursive: Found node: " + nthNodeFromLastRecursive);

    }

    static int count = 0;

    private static Object findNthNodeFromLastRecursive(Node n1, int i) {
        if (n1 == null) {
            return -1;
        }

        //Recurse till last.
        Object data = findNthNodeFromLastRecursive(n1.getNext(), i);

        //count is static, so it will preserve state across recursive calls.
        //Note: we started incrementing count after all recursive call,
        //because we need Nth node from last, otherwise we would have increment count before recursive call for Nth node from start.
        count++;

        //when count value matched the nodeFromLast, we will return node value and from this point onwards,
        //returned value is same across all up recursive calls.
        if (count == i) {
            return n1.getData();
        }
        return data;
    }

    /**
     * TC: O(n)
     * SC: O(1)
     *
     * @param n1
     * @param n
     */
    private static void findNthNodeFromLast(Node n1, int n) {
        int nPos = n;

        Node slow = n1;
        Node fast = n1;

        // moving fast pointer to n places forward
        while (fast != null && fast.getNext() != null && 0 < n) {
            fast = fast.getNext();
            n--;
        }

        while (fast != null) {
            slow = slow.getNext();
            fast = fast.getNext();
        }

        System.out.println(nPos + " position node is : " + slow);
    }

}
