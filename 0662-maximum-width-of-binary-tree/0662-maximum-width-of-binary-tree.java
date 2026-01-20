/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class IndPair{
    int ind;
    TreeNode node;
    IndPair(TreeNode node,int ind){
        this.node=node;
        this.ind=ind;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int ans=0;
        Queue<IndPair> q=new LinkedList<>();
        q.add(new IndPair(root,0));

        while(!q.isEmpty()){
            int size=q.size();
            int start=q.peek().ind;
            int end=start;
            for(int i=0;i<size;i++){
                IndPair p=q.poll();
                int index=p.ind-start;
                end=p.ind;
                TreeNode temp=p.node;
                
                if(temp.left!=null){
                    q.add(new IndPair(temp.left,(2*index)+1));
                }
                if(temp.right!=null){
                    q.add(new IndPair(temp.right,(2*index)+2));
                }
            }
            ans=Math.max(ans,end-start+1);
        }
        return ans;
    }
}