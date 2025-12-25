class Solution {
    public int checkRecord(int n) {
        
        int[][][] dp=new int[n+1][3][2];
        for(int[][] arr:dp){
            for(int[] ar:arr) Arrays.fill(ar,-1);
        }
        return rec(n,0,0,dp);

    }
    static final int mod=1000000007;
    private static int rec(int n,int L,int A,int[][][] dp){
        if(n==0) return 1;
        if(dp[n][L][A]!=-1) return dp[n][L][A];
        int ans=0;
        ans=(ans+(int)rec(n-1,0,A,dp))%mod;
        if(A==0){
            ans=(ans+(int)rec(n-1,0,1,dp))%mod;
        }
        if(L<2){
            ans=(ans+(int)rec(n-1,L+1,A,dp))%mod;
        }

        return dp[n][L][A]=ans%mod;
    }
}