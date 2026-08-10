class Solution {
    public boolean winnerSquareGame(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return check(n,dp)==1;
        // return tabu(n);
    }
    private static boolean tabu(int n){
        boolean[] dp=new boolean[n+1];
        dp[0]=false;
        for(int i=1;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                if(!dp[i-(j*j)]){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }
    private static int check(int n,int[] dp){
        if(n<=0) return 0;
        if(dp[n]!=-1) return dp[n];
        for(int i=1;i*i<=n;i++){
            if(check(n-(i*i),dp)==0) return dp[n]=1;
        }
        return dp[n]=0;
    }
}