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
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> tree=new ArrayList<>();
        if(root==null) return null;
        inorder(root,tree);
        root=build(tree,0,tree.size()-1);
        return root;
    }
    private static TreeNode build(List<TreeNode> tree,int left,int right){
        if(left>right) return null;

        int mid=left+(right-left)/2;
        TreeNode root=new TreeNode(tree.get(mid).val);

        root.left=build(tree,left,mid-1);
        root.right=build(tree,mid+1,right);

        return root;
    }
    private static void inorder(TreeNode root,List<TreeNode> tree){
        if(root==null) return;
        inorder(root.left,tree);
        tree.add(root);
        inorder(root.right,tree);
    }
}