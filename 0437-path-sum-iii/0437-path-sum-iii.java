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
    int count=0;
    public int pathSum(TreeNode root, long targetSum) {
        if(root==null){
            return 0;
        }
        helper(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        return count;
    }

    void helper(TreeNode node, long target){
        if(node==null){
            return ;
        }

        if(node.val==target){
           count++;
        } 

        helper(node.left, target-node.val);
        helper(node.right, target-node.val);
    }
}