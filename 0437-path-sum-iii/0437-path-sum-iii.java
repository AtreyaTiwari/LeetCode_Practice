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
class Solution{
    public int pathSum(TreeNode root, long targetSum) {
        HashMap<Long,Integer> map=new HashMap<>();
        map.put(0L,1);
        return solve(root,0L,targetSum,map);
    }
    private int solve(TreeNode node,long curr,long target,HashMap<Long,Integer> map){
        if(node==null) return 0;

        int count=0;
        curr+=node.val;

        if(map.containsKey(curr-target)){
            count+=map.get(curr-target);
        }
        map.put(curr,map.getOrDefault(curr,0)+1);
        count+=solve(node.left,curr,target,map);
        count+=solve(node.right,curr,target,map);

        map.put(curr,map.get(curr)-1);
        return count;
    }
}

// class Solution {
//     int count=0;
//     public int pathSum(TreeNode root, long targetSum) {
//         if(root==null){
//             return 0;
//         }
//         helper(root, targetSum);
//         pathSum(root.left, targetSum);
//         pathSum(root.right, targetSum);

//         return count;
//     }

//     void helper(TreeNode node, long target){
//         if(node==null){
//             return ;
//         }

//         if(node.val==target){
//            count++;
//         } 

//         helper(node.left, target-node.val);
//         helper(node.right, target-node.val);
//     }
// }