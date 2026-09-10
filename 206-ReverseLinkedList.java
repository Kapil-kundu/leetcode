/** 
    =========================== LOGIC ===========================

    okay, so we have to reverse the singly linked list 
    basically the initial linked list look like this 

    1 -> 2 -> 3 -> null

    we have to reverse the connection

    null <- 1 <- 2 <- 3 

    basically the final connections look like this 


    So the Approach is, we take three pointers or references
    (prev, curr, next) then assign prev and next pointing to 
    null and curr pointing to the head of the linked list

    Then, we start reversing the connections, like first we 
    point next to the next of the curr node, then we assign 
    next of curr node to prev. Okay now the connection is 
    reverted, Now we have to move ahead and at first we 
    assign prev as curr node and then curr node as next(
    same as we do in swapping the variables), now we have to 
    repeat the process until our curr not pointing to the null.
    and in the last we must return our prev, because when the 
    curr is null, the prev reference is referencing the head 
    of the reverted linked list..

    ============================ -_- ============================


**/




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
    public ListNode reverseList(ListNode head) {
        

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}