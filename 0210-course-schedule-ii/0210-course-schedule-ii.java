class Solution {
    public int[] findOrder(int n, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        // int[] indg=new int[n];
        for(int i=0;i<pre.length;i++){
            adj.get(pre[i][1]).add(pre[i][0]);
        }
        boolean[] vis=new boolean[n];
        boolean[] pathVis=new boolean[n];
        Stack<Integer> st=new Stack<>();
        for(int start=0;start<n;start++){
            if(!vis[start]){
                if(topo(start,adj,vis,st,pathVis)){
                    return new int[0]; 
                }
            }
        }
        int[] ans=new int[st.size()];
        int m=0;
        while(!st.isEmpty()){
            ans[m++]=st.pop();
        }
        return ans;
    }
    private static boolean topo(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis,Stack<Integer> st,boolean[] pathVis){

        vis[node]=true;
        pathVis[node]=true;
        for(int ad:adj.get(node)){
            if(!vis[ad]){
                if(topo(ad,adj,vis,st,pathVis)) return true;
            }else if(pathVis[ad]) return true;
        }
        pathVis[node]=false;
        st.push(node);
        return false;
    }
}