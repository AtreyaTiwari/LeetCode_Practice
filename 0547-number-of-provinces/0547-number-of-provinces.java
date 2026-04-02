class Solution {
   public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] visited=new boolean[n];
        int prov=0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                prov++;
                dfs(i,isConnected,visited);
            }
        }
        return prov;
    }
    private static void dfs(int node,int[][] isConnected,boolean[] visited){
        visited[node]=true;
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[node][j]==1 && !visited[j]){
                dfs(j,isConnected,visited);
            }
        }
    }
}
// public int findCircleNum(int[][] isConnected) {
//         int n=isConnected.length;
//         boolean[] visited=new boolean[n];
//         int province=0;

//         for(int i=0;i<n;i++){
//             if(!visited[i]){
//                 province++;
//                 dfs(isConnected, visited, i);
//             }
//         }
//         return province;
//     }
//     private void dfs(int[][] arr,boolean[] visited, int i){
//         visited[i]=true;
//         for(int j=0;j<arr.length;j++){
//             if(arr[i][j]==1 && !visited[j]){
//                 dfs(arr, visited, j);
//             }
//         }
//     }
    