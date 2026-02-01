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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans =new ArrayList<>();
        Stack<TreeNode> s=new Stack<>();
        if(root==null) return ans;
        s.push(root);
        while(!s.isEmpty()){
            int lev=s.size();
            for(int i=0;i<lev;i++){
                TreeNode temp=s.pop();
                if(temp.right!=null) s.push(temp.right);
                if(temp.left!=null) s.push(temp.left);
                ans.add(temp.val);
            }
        }
        return ans;
    }

    // List<Integer> ans =new ArrayList<>();
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     if(root==null){
    //         return ans;
    //     }
    //     ans.add(root.val);
    //     preorderTraversal(root.left);
    //     preorderTraversal(root.right);
    //     return ans;
    // }
}