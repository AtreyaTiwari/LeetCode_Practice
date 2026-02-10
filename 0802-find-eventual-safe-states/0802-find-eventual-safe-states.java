class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
        
        boolean[] vis=new boolean[V];
        boolean[] pathVis=new boolean[V];
        boolean[] check=new boolean[V];

        for(int start=0;start<V;start++){
            if(!vis[start]){
                dfs(start,graph,vis,pathVis,check);
            }
        }
        List<Integer> ans=new ArrayList<>();      
        for(int i=0;i<V;i++){
            if(!check[i]){
                ans.add(i);
            }
        }
        return ans;
    }
    private static boolean dfs(int node,int[][] graph,boolean[] vis,boolean[] pathVis,boolean[] check){
        vis[node]=true;
        pathVis[node]=true;
        check[node]=false;

        for(int ad:graph[node]){
            if(!vis[ad]){
                if(dfs(ad,graph,vis,pathVis,check)){
                    check[node]=true;
                    return true;
                }
            }else if(pathVis[ad]){
                check[node]=true;
                return true;
            }
        }
        pathVis[node]=false;
        check[node]=false;
        return false;
    }
}