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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode tempH=head;
        ListNode prev=null;
        int pos=0;
        int curr=pos;
        int first=-1;
        int minDis=100000;
        while(tempH.next!=null){
            if(prev!=null){
                if((tempH.val>prev.val && tempH.val>tempH.next.val) || (tempH.val<prev.val && tempH.val<tempH.next.val)){
                    if(first==-1){
                        first=pos;
                        curr=pos;
                    }
                    else if(curr!=pos){
                        minDis=Math.min(minDis,(pos-curr));
                        curr=pos;
                    }
                }
            }
            prev=tempH;
            tempH=tempH.next;
            pos++;
        }
        if(first==-1 || first==curr) return new int[]{-1,-1};
        int maxDis=curr-first;
        return new int[]{minDis,maxDis};
    }
}