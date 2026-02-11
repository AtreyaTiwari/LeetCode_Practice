class Solution {
    
    //bfs approach - kahn's
    public boolean canFinish(int n,int[][] pre){
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int[] indg=new int[n];
        for(int i=0;i<pre.length;i++){
            adj.get(pre[i][1]).add(pre[i][0]);
            indg[pre[i][0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indg[i]==0){
                q.add(i);
            }
        }
        int count=0;
        // boolean[] vis=new boolean[n];
        while(!q.isEmpty()){
            int node=q.poll();
            count++;
            // vis[node]=true;

            for(int ad:adj.get(node)){
                // if(!vis[ad]){
                    indg[ad]--;
                    if(indg[ad]==0) q.add(ad);
                // }
            }    
        }
        return count==n;
        
    }


    // dfs method - cycle detection
    // public boolean canFinish(int n, int[][] prerequisites) {
    //     ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    //     for(int i=0;i<n;i++) adj.add(new ArrayList<>());

    //     for(int i=0;i<prerequisites.length;i++){
    //         adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
    //     }
    //     boolean[] vis=new boolean[n];
    //     boolean[] pathVis=new boolean[n];
        
    //     for(int start=0;start<n;start++){
    //         if(!vis[start]){
    //             if(topo(start,adj,vis,pathVis)) return false;
    //         }
    //     }
    //     return true;
    // }
    // private static boolean topo(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis,boolean[] pathVis){
    //     vis[node]=true;
    //     pathVis[node]=true;

    //     for(int ad:adj.get(node)){
    //         if(!vis[ad]){
    //             if(topo(ad,adj,vis,pathVis)) return true;
    //         }else if(pathVis[ad]){
    //             return true;
    //         }
    //     }
    //     pathVis[node]=false;
    //     return false;
    // }
    
}