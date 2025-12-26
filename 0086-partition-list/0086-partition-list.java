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
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null) return head;
        ListNode lessHead=null;
        ListNode less=null;
        ListNode greaterHead=null; 
        ListNode greater=null;

        ListNode temp=head;
        while(temp!=null){
            if(temp.val<x){
                if(less==null){
                    less=temp;
                    lessHead=less;
                }else{
                    less.next=temp;
                    less=less.next;
                }
            }else{
                if(greater==null){
                    greater=temp;
                    greaterHead=greater;
                }else{
                    greater.next=temp;
                    greater=greater.next;
                }
            }
            temp=temp.next;
        }

        if (greater != null) greater.next = null;

        if(less!=null){
            less.next=greaterHead;
            return lessHead;
        }else{
            return greaterHead;
        }
    }
}