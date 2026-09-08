class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length;
        int n=dungeon[0].length;
        return tabu(dungeon,m,n);
        // int[][] dp=new int[m][n];
        // for(int[] ar:dp) Arrays.fill(ar,-1);
        // return memo(0,0,dungeon,m,n,dp);
        // return rec(0,0,dungeon,m,n);
    }
    private static int tabu(int[][] dungeon,int m,int n){
        int[][] dp=new int[m][n];
        dp[m-1][n-1]=Math.max(1,1-dungeon[m-1][n-1]);

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1) continue;
                int down=Integer.MAX_VALUE;
                int right=Integer.MAX_VALUE;
                if(i+1<m) down=dp[i+1][j];
                if(j+1<n) right=dp[i][j+1];
                int next=Math.min(down,right);
                dp[i][j]=Math.max(1,next-dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
    private static int memo(int i,int j,int[][] dungeon,int m,int n,int[][] dp){
        if(i>=m || j>=n) return Integer.MAX_VALUE;
        
        if(i==m-1 && j==n-1) return Math.max(1,1-dungeon[i][j]);
        if(dp[i][j]!=-1) return dp[i][j];

        int down=memo(i+1,j,dungeon,m,n,dp);
        int right=memo(i,j+1,dungeon,m,n,dp);
        int next=Math.min(down,right);

        return dp[i][j]=Math.max(1,next-dungeon[i][j]);
    }
    private static int rec(int i,int j,int[][] dungeon,int m,int n){
        if(i>=m || j>=n) return Integer.MAX_VALUE;

        if(i==m-1 && j==n-1) return Math.max(1,1-dungeon[i][j]);

        int down=rec(i+1,j,dungeon,m,n);
        int right=rec(i,j+1,dungeon,m,n);
        int next=Math.min(down,right);

        return Math.max(1,next-dungeon[i][j]);
    }
}