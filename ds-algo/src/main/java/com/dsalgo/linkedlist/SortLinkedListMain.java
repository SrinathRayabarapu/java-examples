package com.dsalgo.linkedlist;

/**
 * TODO -
 * 1. given a linked list, check whether it's sorted or not
 * 2. given a linked list, sort it
 */
public class SortLinkedListMain {

    public static void main(String[] args) {

        Node head = new Node(40);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(10);

        head.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);

        boolean isSorted = isLinkedlistSorted(head);
        System.out.println("Linked list is sorted : " + isSorted);

    }

    private static boolean isLinkedlistSorted(Node head) {

        if(head == null){
            return false;
        }

        boolean isSorted = false;
        while (head.getNext() != null){
            if((int)head.getData() < (int)head.getNext().getData()){
                head = head.getNext();
                isSorted = true;
            } else {
                break;
            }
        }

        return isSorted;
    }

}
