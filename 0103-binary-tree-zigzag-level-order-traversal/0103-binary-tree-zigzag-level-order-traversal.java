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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean lr=true;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                list.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            if(!lr) Collections.reverse(list); 
            ans.add(list);
            lr=!lr;
        }
        return ans;
    }
    // public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    //    List<List<Integer>> result =new ArrayList<>();
    //     Deque<TreeNode> queue=new LinkedList<>();
    //     if(root==null){
    //         return result;
    //     }
        
    //     boolean reverse=false;
    //     queue.addFirst(root);
    //     while (!queue.isEmpty()) {
    //         List<Integer> currentLevel=new ArrayList<>();
    //         int level=queue.size();
    //         for (int i = 0; i < level; i++) {
    //             if(!reverse){
    //                 TreeNode node=queue.pollFirst();
    //                 currentLevel.add(node.val);
    //                 if(node.left!=null){
    //                     queue.addLast(node.left);
    //                 }
    //                 if(node.right!=null){
    //                     queue.addLast(node.right);
    //                 }
    //             }else{
    //                 TreeNode node=queue.pollLast();
    //                 currentLevel.add(node.val);
    //                 if(node.right!=null){
    //                     queue.addFirst(node.right);
    //                 }                    
    //                 if(node.left!=null){
    //                     queue.addFirst(node.left);
    //                 }
    //             }
    //         }
    //         reverse=!reverse;
    //         result.add(currentLevel);
    //     }
    //     return result; 
    // }
}