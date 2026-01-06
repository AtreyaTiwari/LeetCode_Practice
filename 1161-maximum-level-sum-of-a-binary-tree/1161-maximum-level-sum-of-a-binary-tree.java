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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        int level=1;
        int res=0;
        int maxSum=Integer.MIN_VALUE;

        q.add(root);

        while(!q.isEmpty()){
            int sum=0;
            int n=q.size();

            while(n>0){
                TreeNode node=q.poll();
                sum+=node.val;

                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }

                n-=1;
            }
            if(sum>maxSum){
                maxSum=sum;
                res=level;
            }
            level+=1;
        }
        return res;
    }
}