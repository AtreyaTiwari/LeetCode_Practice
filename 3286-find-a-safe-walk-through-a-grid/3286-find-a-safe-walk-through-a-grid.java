class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n=grid.size();
        int m=grid.get(0).size();
        boolean[][] vis=new boolean[n][m];
        Boolean[][][] dp=new Boolean[n][m][health+1];
        return solve(0,0,grid,health,vis,dp);
    }
    private static boolean solve(int i,int j,List<List<Integer>> grid, int health,boolean[][] vis,Boolean[][][] dp){
        if(health<=0) return false;
        if(i==grid.size()-1 && j==grid.get(0).size()-1){
            if(grid.get(i).get(j)==1) return health>1;
            else return health>0;
        }
        if(dp[i][j][health]!=null) return dp[i][j][health];

        vis[i][j]=true;
        int[] dx={-1,0,+1,0};
        int[] dy={0,+1,0,-1};
        

        for(int t=0;t<4;t++){
            int ni=i+dx[t];
            int nj=j+dy[t];

            if(ni<grid.size() && ni>=0 && nj<grid.get(0).size() && nj>=0){
                if(!vis[ni][nj] && grid.get(i).get(j)==1){
                    if(solve(ni,nj,grid,health-1,vis,dp)) return dp[i][j][health-1]=true;
                }else if(!vis[ni][nj] && grid.get(i).get(j)==0){
                    if(solve(ni,nj,grid,health,vis,dp)) return dp[i][j][health]=true;
                }
            }
        }
        vis[i][j]=false;
        return dp[i][j][health]=false;
    }
}