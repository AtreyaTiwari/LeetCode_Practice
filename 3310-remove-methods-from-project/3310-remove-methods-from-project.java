class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] inv) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] arr:inv){
            adj.get(arr[0]).add(arr[1]);
        }
        boolean[] vis=new boolean[n];
        dfs(k,adj,vis);
        // System.out.println(Arrays.toString(vis));
        List<Integer> ans=new ArrayList<>();
        boolean possi=false;
        for(int[] arr:inv){
            if(!vis[arr[0]] && vis[arr[1]]){
                possi=true;
                break;
            }
        }
        if(possi){
            for(int i=0;i<n;i++) ans.add(i);
        }else{
            for(int i=0;i<n;i++){
                if(!vis[i]) ans.add(i);
            }
        }
        return ans;
    }
    
    private static void dfs(int node,List<List<Integer>> adj,boolean[] vis){
        vis[node]=true;
        for(int nd:adj.get(node)){
            if(!vis[nd]){
                dfs(nd,adj,vis);
            }
        }
    }
}