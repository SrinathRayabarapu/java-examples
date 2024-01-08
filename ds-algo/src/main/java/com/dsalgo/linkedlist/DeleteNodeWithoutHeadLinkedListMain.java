package com.dsalgo.linkedlist;

/**
 * delete a node in linked list without head node.
 *
 * @author Srinath.Rayabarapu
 */
public class DeleteNodeWithoutHeadLinkedListMain {

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

        System.out.println("Original List: ");
        printList(n1);

        System.out.println("\nDeleting Node " + n4.getData());
        deleteNode(n4);

        System.out.println("Printing list after node deletion: ");
        printList(n1);

    }

    /**
     * not exactly deleting node but we set next element data and reference to it.
     *
     * @param node
     */
    private static void deleteNode(Node node) {
        node.setData(node.getNext().getData());
        node.setNext(node.getNext().getNext());
    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head + " ");
            head = head.getNext();
        }
    }

}
