class Solution {
    static final int mod=1000000007;
    public int checkRecord(int n) {
        
        int[][][] dp=new int[n+1][3][2];
        for(int[][] arr:dp){
            for(int[] ar:arr) Arrays.fill(ar,-1);
        }
        return tabu(n);
        // return rec(n,0,0,dp);

    }
    
    // private static int rec(int n,int L,int A,int[][][] dp){
    //     if(n==0) return 1;
    //     if(dp[n][L][A]!=-1) return dp[n][L][A];
    //     int ans=0;
    //     ans=(ans+(int)rec(n-1,0,A,dp))%mod;
    //     if(A==0){
    //         ans=(ans+(int)rec(n-1,0,1,dp))%mod;
    //     }
    //     if(L<2){
    //         ans=(ans+(int)rec(n-1,L+1,A,dp))%mod;
    //     }

    //     return dp[n][L][A]=ans%mod;
    // }
    private static int tabu(int n){
        int[][][] dp=new int[n+1][3][2];
        
        for (int A = 0; A <= 1;A++) {
            for (int L = 0; L <= 2; L++) {
                dp[0][L][A] = 1;
            }
        }
        
        for(int i=1;i<=n;i++){
            for(int l=0;l<3;l++){
                for(int a=0;a<=1;a++){
                    int ans=0;
                    ans=(ans+(int)dp[i-1][0][a])%mod;
                    if(a==0){
                        ans=(ans+(int)dp[i-1][0][1])%mod;
                    }
                    if(l<2){
                        ans=(ans+(int)dp[i-1][l+1][a])%mod;
                    }
                    dp[i][l][a]=ans%mod;
                }
            }
        }

        return dp[n][0][0];        
     
    }
}