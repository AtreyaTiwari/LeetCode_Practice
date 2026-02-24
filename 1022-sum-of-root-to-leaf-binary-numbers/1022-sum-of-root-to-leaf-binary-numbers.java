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
    public int sumRootToLeaf(TreeNode root) {
        if(root==null) return 0;
        return sum(root,0);
    }
    private static int sum(TreeNode root,int curr){
        if(root==null) return 0;
        curr=(curr*2)+root.val;
        if(root.left==null && root.right==null) return curr;
        return sum(root.left,curr)+sum(root.right,curr);
    }

    // brute force
    // public int sumRootToLeaf(TreeNode root) {
    //     ArrayList<String> str=new ArrayList<>();
    //     StringBuilder temp=new StringBuilder();
    //     build(root,str,temp);
    //     int ans=sum(str);
    //     return ans;
    // }
    // private static int sum(ArrayList<String> str){
    //     int sum=0;
    //     for(String st:str){
    //         sum+=Integer.parseInt(st,2);
    //     }
    //     return sum;
    // }
    // private static void build(TreeNode root,ArrayList<String> str,StringBuilder temp){
    //     if(root==null) return ;
    //     temp.append(root.val);
    //     if(root.left==null && root.right==null){
    //         str.add(temp.toString());
    //     }else{
    //         build(root.left,str,temp);
    //         build(root.right,str,temp);
    //     }
    //     temp.deleteCharAt(temp.length()-1);
    // }
}