class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        boolean[] vis=new boolean[n];
        boolean[] pathVis=new boolean[n];
        
        for(int start=0;start<n;start++){
            if(!vis[start]){
                if(topo(start,adj,vis,pathVis)) return false;
            }
        }
        return true;
    }
    private static boolean topo(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis,boolean[] pathVis){
        vis[node]=true;
        pathVis[node]=true;

        for(int ad:adj.get(node)){
            if(!vis[ad]){
                if(topo(ad,adj,vis,pathVis)) return true;
            }else if(pathVis[ad]){
                return true;
            }
        }
        pathVis[node]=false;
        return false;
    }
    
}