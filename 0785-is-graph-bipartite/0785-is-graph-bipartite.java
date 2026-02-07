class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] vis=new int[graph.length];
        Arrays.fill(vis,-1);
        
        for(int i=0;i<graph.length;i++){
            if(vis[i]!=-1) continue;
            vis[i]=0;
            if(dfs(i,graph,vis)==false) return false;
        }
        return true;
    }
    private static boolean dfs(int node,int[][] graph,int[] vis){
        for(int ad:graph[node]){
            if(vis[ad]==-1){
                vis[ad]=1-vis[node];
                if(dfs(ad,graph,vis)==false) return false;
            }else{
                if(vis[ad]==vis[node]) return false;
                // else continue;
            }
        }
        return true;
    }
}