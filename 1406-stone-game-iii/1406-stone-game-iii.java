class Solution {
    public String stoneGameIII(int[] stoneValue) {
        // int n=stoneValue.length;
        // int[] dp=new int[n];
        // Arrays.fill(dp,Integer.MIN_VALUE);
        // int value=solve(stoneValue,0,dp);
        int value=tabu(stoneValue);
        if(value>0) return "Alice";
        else if(value<0) return "Bob";
        else return "Tie";
    }
    private static int tabu(int[] stone){
        int n=stone.length;
        int[] dp=new int[n+1];
        for(int i=n-1;i>=0;i--){
            int one=stone[i]-dp[i+1];

            int two=Integer.MIN_VALUE;
            if(i+1<n) two=stone[i]+stone[i+1] -dp[i+2];

            int three=Integer.MIN_VALUE;
            if(i+2<n) three=stone[i]+stone[i+1]+stone[i+2]-dp[i+3];

            dp[i]=Math.max(one,Math.max(two,three));
        }
        return dp[0];
    }
    // private static int solve(int[] stone,int i,int[] dp){
    //     int n=stone.length;
    //     if(n<=i) return 0;
    //     if(dp[i]!=Integer.MIN_VALUE) return dp[i];
    //     int one=stone[i]- solve(stone,i+1,dp);

    //     int two=Integer.MIN_VALUE;
    //     if(i+1<n) two=stone[i]+stone[i+1] -solve(stone,i+2,dp);

    //     int three=Integer.MIN_VALUE;
    //     if(i+2<n) three=stone[i]+stone[i+1]+stone[i+2]-solve(stone,i+3,dp);

    //     return dp[i]=Math.max(one,Math.max(two,three));
    // }
}