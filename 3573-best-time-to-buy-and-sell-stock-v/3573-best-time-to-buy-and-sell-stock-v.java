class Solution {
    static final long NEG_INF = (long)-1e18;
    public long maximumProfit(int[] prices, int k) {
        int n=prices.length;
        long[][][] dp=new long[n][k+1][3];
        for(long[][] arr:dp){
            for(long[] ar:arr){
                Arrays.fill(ar,-1);
            }
        }
        return memo(0,k,0,prices,n,dp);
        // return rec(0,k,0,prices,n);
    }
    // private static long rec(int i,int k,int state,int[] prices,int n){
    //     if(i==n){
    //         return state==0?0:NEG_INF;
    //     }
    //     // if(k==0 && state!=0) return NEG_INF;
    //     long ans=NEG_INF;
    //     int price=prices[i];
    //     if(state==0){
    //         ans = rec(i + 1, k, 0, prices, n);

    //         // open long (only if k > 0)
    //         if (k > 0) {
    //             ans = Math.max(ans,
    //                     -price + rec(i + 1, k - 1, 1, prices, n));
    //         }

    //         // open short (only if k > 0)
    //         if (k > 0) {
    //             ans = Math.max(ans,
    //                      price + rec(i + 1, k - 1, 2, prices, n));
    //         }
    //     }else if(state==1){
    //         ans=Math.max(rec(i+1,k,1,prices,n),prices[i]+rec(i+1,k,0,prices,n));
    //     }else{
    //         ans=Math.max(rec(i+1,k,2,prices,n),-prices[i]+rec(i+1,k,0,prices,n));
    //     }

    //     return ans;
    // }   
    private static long memo(int i,int k,int state,int[] prices,int n,long[][][] dp){
        if(i==n){
            return state==0?0:NEG_INF;
        }
        if(dp[i][k][state]!=-1) return dp[i][k][state];
        // if(k==0 && state!=0) return NEG_INF;
        long ans=NEG_INF;
        int price=prices[i];
        if(state==0){
            ans = memo(i + 1, k, 0, prices, n,dp);

            // open long (only if k > 0)
            if (k > 0) {
                ans = Math.max(ans,
                        -price + memo(i + 1, k - 1, 1, prices, n,dp));
            }

            // open short (only if k > 0)
            if (k > 0) {
                ans = Math.max(ans,
                         price + memo(i + 1, k - 1, 2, prices, n,dp));
            }
        }else if(state==1){
            ans=Math.max(memo(i+1,k,1,prices,n,dp),prices[i]+memo(i+1,k,0,prices,n,dp));
        }else{
            ans=Math.max(memo(i+1,k,2,prices,n,dp),-prices[i]+memo(i+1,k,0,prices,n,dp));
        }

        return dp[i][k][state]=ans;
    }   
}