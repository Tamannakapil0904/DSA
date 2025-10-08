/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        //edge case
        if(head == null || head.next == null) return head;

        //Step 1: Count the length
        int length = 1;
        ListNode tail = head;
        while(tail.next != null){
            tail = tail.next;
            length++;
        }

        //Step 2: Optimize k
        k = k % length;
        if(k==0) return head;

        //Step 3: Find new tail (n-k-1)
        int stepsToNewTail = length-k;
        ListNode newTail = head;
        for(int i = 1; i < stepsToNewTail; i++){
            newTail = newTail.next;
        }
//Step 4: Break and reconnect
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;
        }
    }
