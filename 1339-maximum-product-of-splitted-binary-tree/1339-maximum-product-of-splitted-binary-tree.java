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
class Solution {
    static final int MOD = 1_000_000_007;
     long maxProd=0;

    public int maxProduct(TreeNode root) {
        long totSum=sum(root);
        solve(root,totSum);
        return (int)(maxProd % MOD);
    }
    private  long solve(TreeNode node,long totSum){
        if(node==null) return 0;

        long left=solve(node.left,totSum);
        long right=solve(node.right,totSum);

        long subTreeSum=left+right+node.val;
        
        //agrr yahi cut kre to?
        long prod= subTreeSum*(totSum-subTreeSum);
        maxProd=Math.max(prod,maxProd);

        return subTreeSum;
    }
    private  long sum(TreeNode root){
        if(root==null){
            return 0;
        }
        return sum(root.left)+sum(root.right)+root.val;
    }
}