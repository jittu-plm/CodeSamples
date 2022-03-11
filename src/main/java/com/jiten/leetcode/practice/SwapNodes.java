package com.jiten.leetcode.practice;

/**
 * Problem -
 * 24. Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * Example 2:
 *
 * Input: head = []
 * Output: []
 * Example 3:
 *
 * Input: head = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 */
public class SwapNodes {


    public ListNode swapPairs(ListNode head) {
        ListNode temp = head;
        int tempVal = 0;

        while(temp != null) {
            tempVal = temp.val;
            // System.out.println(tempVal);
            if(temp.next != null){
                temp.val = temp.next.val;
                temp.next.val = tempVal;
                // System.out.println(temp.val +":" +  temp.next.val);
                temp = temp.next.next;
            }
            else
                break;
        }
        return head;

    }
}

/* Definition for singly-linked list.*/
   class ListNode {
      int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }