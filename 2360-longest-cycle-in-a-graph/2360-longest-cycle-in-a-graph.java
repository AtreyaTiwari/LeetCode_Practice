class Solution {
    public int longestCycle(int[] edges) {
        int n=edges.length;
        boolean[] vis=new boolean[n];
        boolean[] pathVis=new boolean[n];
        int[] depth=new int[n];
        int max=-1;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                max=Math.max(dfs(i,edges,vis,pathVis,depth,0),max);
            }
        }
        return max;
    }
    private static int dfs(int node,int[] edges,boolean[] vis,boolean[] pathVis,int[] depth,int len){
        vis[node]=true;
        pathVis[node]=true;
        depth[node]=len;
        if(edges[node]==-1){
            pathVis[node]=false;
            return -1;
        }
        
        if(vis[edges[node]] && pathVis[edges[node]]){
            pathVis[node]=false;
            return len-depth[edges[node]]+1;
        }
        if(vis[edges[node]]){
            pathVis[node]=false;
            return -1;
        }
        int ans=dfs(edges[node],edges,vis,pathVis,depth,len+1);
        pathVis[node]=false;
        return ans;
    }
}