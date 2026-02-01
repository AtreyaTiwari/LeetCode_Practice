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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode> s=new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode node=s.pop();
            if(node.left!=null){
                s.push(node.left);
            }
            if(node.right!=null){
                s.push(node.right);
            }
            ans.addFirst(node.val);
        }
        return ans;
    }

    // List<Integer> ans =new ArrayList<>();
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     if(root==null){
    //         return ans;
    //     }
    //     postorderTraversal(root.left);
    //     postorderTraversal(root.right);
    //     ans.add(root.val);
    //     return ans;
    // }
}