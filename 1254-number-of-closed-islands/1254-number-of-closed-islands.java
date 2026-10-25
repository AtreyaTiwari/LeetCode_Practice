class Solution {
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int count=0;
        boolean[][] vis=new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0 && !vis[i][j]){
                    boolean ans=dfs(i,j,grid,vis,n,m);
                    if(ans) count++;
                }
            }
        }
        return count;
    }
    private static boolean dfs(int i,int j,int[][] grid,boolean[][] vis,int n,int m){
        if(i==0 || i==n-1 || j==0 || j==m-1) return grid[i][j]==1;
        
        if(grid[i][j]==1){
            return true;
        }
        if(vis[i][j]) return true;
        vis[i][j]=true;

        
        boolean left=dfs(i,j-1,grid,vis,n,m);
        boolean up=dfs(i-1,j,grid,vis,n,m);
        boolean right=dfs(i,j+1,grid,vis,n,m);
        boolean down=dfs(i+1,j,grid,vis,n,m);

        return left && right && up && down;
    }
}