class Solution {
    public boolean hasValidPath(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if(grid[0][0]==')' || grid[n-1][m-1]=='(') return false;
        if((n+m)%2==0) return false; 

        byte[][][] dp=new byte[n][m][n+m];
        
        for(byte[][] arr:dp){
            for(byte[] ar:arr) Arrays.fill(ar,(byte)-1);
        }
        return dfs(0,0,grid,0,dp);
    }
    private static boolean dfs(int i,int j,char[][] grid,int score,byte[][][] dp){
        int n=grid.length;
        int m=grid[0].length;

        if(i>=n || j>=m) return false;
        
        if(grid[i][j]=='(') score++;
        else score--;
        if(score<0) return false;

        if(score>(n-1-i)+(m-1-j)) return false;
        
        if(i==n-1 && j==m-1){
            return score==0;
        }
        
        if(dp[i][j][score]!=-1){
            return dp[i][j][score]==1;
        }
        
        boolean ans=dfs(i+1,j,grid,score,dp)||dfs(i,j+1,grid,score,dp);

        dp[i][j][score]=ans?(byte)1:(byte)0;
        return ans;
    }
}