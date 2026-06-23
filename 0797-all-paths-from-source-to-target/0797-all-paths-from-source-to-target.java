class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> list=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        boolean[] vis=new boolean[graph.length];
        solve(0,graph,vis,list,ans);
        return ans;
    }
    private static void solve(int node,int[][] graph,boolean[] vis,List<Integer> list,List<List<Integer>> ans){
        list.add(node);
        if(node==graph.length-1){
            ans.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        vis[node]=true;
        for(int nd:graph[node]){
            if(!vis[nd]){
                solve(nd,graph,vis,list,ans);
            }
        }
        vis[node]=false;
        list.remove(list.size()-1);
    }
}