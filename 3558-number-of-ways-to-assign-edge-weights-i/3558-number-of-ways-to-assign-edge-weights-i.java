class Solution {
    static int gmax;
    public int assignEdgeWeights(int[][] edges) {
        gmax=0;
        int n=edges.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr:edges){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
        boolean[] vis=new boolean[n+2];
        vis[1]=true;
        dfs(1,adj,vis,0);
        // System.out.println(gmax);
        return (int)(pow(2,gmax-1)%1000000007);
    }
    private static long pow(long base,long exp){
        long ans=1;
        long mod=1000000007L;
        while(exp>0){
            if((exp&1)==1){
                ans=(ans*base)%mod;
            }
            base=(base*base)%mod;
            exp>>=1;
        }
        return ans;
    }
    private static void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis,int count){
        gmax=Math.max(gmax,count);
        for(int nd:adj.get(node)){
            if(!vis[nd]){
                vis[nd]=true;
                dfs(nd,adj,vis,count+1);
                vis[nd]=false;
            }
        }
    }
}