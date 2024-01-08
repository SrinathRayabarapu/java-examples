package com.dsalgo.linkedlist;

/**
 * given a singly linkedlist, check whether it is palindrome or not.
 * <p>
 * Example:
 * 1 -> 2 -> 3 -> 3 -> 2 -> 1 : is a palindrome
 * 1 -> 2 -> 3 -> 4 -> 1 : is NOT a palindrome
 * <p>
 * Approach:
 * 1. using slow and fast pointers, find the middle of the linkedlist
 * 2. reverse the second half of the linkedlist
 * 3. compare transformed linkedlist from head and slow pointer
 * <p>
 * Expected::
 * TC: O(n)
 * SC: O(1)
 */
public class CheckLinkedListIsPalindromeMain {

    public static boolean isLinkedListPalindrome(Node head) {

        Node slow = head, fast = head;
        Node prev, temp;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        Node slow1 = slow;
        LinkedListUtil.printLinkedList(slow1);

        prev = slow;
        slow = slow.getNext();
        prev.setNext(null);

        while (slow != null) {
            // get next to use below
            temp = slow.getNext();
            // assignment
            slow.setNext(prev);
            // required to move forward
            prev = slow;
            slow = temp;
        }

        Node prev1 = prev;
        LinkedListUtil.printLinkedList(prev1);

        Node tmp1 = head;
        LinkedListUtil.printLinkedList(tmp1);


        System.out.println("head = " + head + ", prev = " + prev);

        fast = head;
        slow = prev;

        while (slow != null){
            if(! fast.getData().equals(slow.getData())){
                return false;
            }
            slow = slow.getNext();
            fast = fast.getNext();
        }

        return true;
    }

}
