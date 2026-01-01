package com.dsalgo.linkedlist;

import lombok.extern.slf4j.Slf4j;

import static com.dsalgo.linkedlist.LinkedListUtil.printLinkedList;
import static com.dsalgo.linkedlist.LinkedListUtil.printListInRecursive;

/**
 * Demonstrates reversing a singly linked list using iterative and recursive approaches.
 * 
 * <p>Reversing a linked list is a fundamental operation and a common interview question.
 * This class provides multiple approaches to solve the problem.</p>
 * 
 * <h3>Problem Statement:</h3>
 * <p>Given the head of a singly linked list, reverse the list and return the new head.</p>
 * 
 * <h3>Approaches Demonstrated:</h3>
 * <table border="1">
 *   <tr><th>Approach</th><th>Time</th><th>Space</th><th>Modifies List</th></tr>
 *   <tr><td>Iterative</td><td>O(n)</td><td>O(1)</td><td>Yes</td></tr>
 *   <tr><td>Print Reverse (Recursive)</td><td>O(n)</td><td>O(n)</td><td>No</td></tr>
 * </table>
 * 
 * <h3>Iterative Algorithm:</h3>
 * <pre>
 * 1. Initialize: previous = null, current = head
 * 2. While current is not null:
 *    a. Save next = current.next
 *    b. Reverse link: current.next = previous
 *    c. Move previous and current one step forward
 * 3. Return previous (new head)
 * </pre>
 * 
 * <h3>Visual Example:</h3>
 * <pre>
 * Original: 10 -> 20 -> 30 -> 40 -> null
 * Reversed: 40 -> 30 -> 20 -> 10 -> null
 * </pre>
 * 
 * <h3>LeetCode Reference:</h3>
 * <p>Problem #206 - Reverse Linked List</p>
 *
 * @author Srinath.Rayabarapu
 * @see Node
 * @see LinkedListUtil
 */
@Slf4j
public class ReverseLinkedListMain {

    /**
     * Main method demonstrating linked list reversal with various operations.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        Node head = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(50);
        Node n6 = new Node(60);
        Node n7 = new Node(70);
        Node n8 = new Node(80);

        head.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n8);

        log.info("Printing original linked list - loop way : ");
        // printing list in loop
        printLinkedList(head);

        log.info("Printing original linked list - recursive way : ");
        // printing list in recursive
        printListInRecursive(head);

        log.info("Printing in Reverse order - No change to list: ");
        //simply print in reverse order - don't change original list structure
        printListInReverseRecursive(head);

        // it will change the original list!
        Node node = reverseLinkedListIterative(head);

        log.info("Printing Reversed Linked list: ");
        printLinkedList(node);

    }

    /**
     * Prints the linked list in reverse order without modifying the original structure.
     * 
     * <p>Uses recursion to traverse to the end first, then prints while unwinding
     * the call stack. This results in O(n) space complexity due to recursion depth.</p>
     *
     * @param head the head of the linked list
     */
    private static void printListInReverseRecursive(Node head) {
        if(head == null){
            return;
        }
        printListInReverseRecursive(head.getNext());
        log.info(head+"");
    }

    /**
     * Reverses a linked list iteratively.
     * 
     * <p>This is the preferred approach for reversing a linked list due to
     * its O(1) space complexity. The algorithm uses three pointers:
     * previous, current, and next.</p>
     * 
     * <p><b>Note:</b> This method modifies the original linked list structure.</p>
     *
     * @param head the head of the linked list to reverse
     * @return the new head of the reversed list (was the tail)
     */
    private static Node reverseLinkedListIterative(Node head) {
        Node current = head;
        Node previous = null; // required to make this as last node

        while(current != null){
            Node next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next; // required to go to next element in loop
        }

        return previous;
    }

}