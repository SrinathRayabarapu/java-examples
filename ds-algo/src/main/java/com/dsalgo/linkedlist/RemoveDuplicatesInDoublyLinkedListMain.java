package com.dsalgo.linkedlist;

/**
 * TODO - complete the solution
 *
 * https://www.geeksforgeeks.org/remove-duplicates-sorted-doubly-linked-list/?ref=lbp
 *
 * Input: DLL : 4 <-> 6 <-> 6 <-> 10 <-> 11 <-> 11 <-> 15 <-> 18
 * Output : 4 <-> 6 <-> 10 <-> 11 <-> 15 <-> 18 <->
 *
 *
 * then work on : https://www.geeksforgeeks.org/xor-linked-list-a-memory-efficient-doubly-linked-list-set-1/
 */
public class RemoveDuplicatesInDoublyLinkedListMain {

    public static void main(String[] args) {

        DoubleNode doubleNode = new DoubleNode(6);
        printList(doubleNode);
        removeDuplicates(doubleNode);

    }

    // return the head of the DoubleLinkedList
    private static DoubleNode removeDuplicates(DoubleNode doubleNode) {
        if (doubleNode == null)
            return null;

        while (doubleNode.next != null) {
            int curValue = doubleNode.value;
            if(curValue == doubleNode.next.value){
                // remove the next node
                doubleNode.next = doubleNode.next.next;
                doubleNode = doubleNode.next.next.before;
            }
        }

        return doubleNode;
    }

    private static void printList(DoubleNode doubleNode) {
        // TODO
    }

}

class DoubleNode {
    int value;
    public DoubleNode before;
    public DoubleNode next;

    public DoubleNode(int value) {
        this.value = value;
    }
}
