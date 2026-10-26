class Solution {
    public int countIslands(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;

        boolean[][] vis=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]!=0){
                    if(dfs(i,j,grid,vis,n,m)%k==0) count++;
                }
            }
        }
        return count;
    }
    private static long dfs(int i,int j,int[][] grid,boolean[][] vis,int n,int m){
        if(i<0 || i==n || j<0 || j==m) return 0;
        if(vis[i][j] || grid[i][j]==0) return 0;

        vis[i][j]=true;

        long left=dfs(i,j-1,grid,vis,n,m);
        long right=dfs(i,j+1,grid,vis,n,m);
        long up=dfs(i-1,j,grid,vis,n,m);
        long down=dfs(i+1,j,grid,vis,n,m);

        return grid[i][j]+left+right+up+down;
    } 
}