package com.jiten.leetcode.practice;

/**
 * 82. Remove Duplicates from Sorted List II
 *
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 *
 *  Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 *
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates duplicates = new RemoveDuplicates();
//        duplicates.deleteDuplicates();
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head, temp1 = head;
        ListNode prev = head;
        int tempVal = head.val;

        while(temp.next != null){
            if (temp != null && (temp.val == temp.next.val || temp.val == tempVal)){
                // if (temp != null && temp.val == tempVal){
                // if(temp == head)
                //     head = temp;
                tempVal = temp.val;
                System.out.println("if - " + temp.val);
                // temp = temp.next;
                // previous = null;
                // previous = temp;
                // head = temp;
                // temp = temp.next;

                temp = temp.next;


            }
            else {
                System.out.println("else -" + temp.val);
                prev.next = temp;

                temp = temp.next;

            }
        }
        System.out.println("prev - " + prev.val);
        return prev;
    }
}

/*class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }*/
