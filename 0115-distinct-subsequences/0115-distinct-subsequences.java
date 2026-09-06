class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[][] dp=new int[n][m];
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        }
        return spaceOpt(s,t,n,m);
        // return space(s,t,n,m);
        // return tabu(s,t,n,m);
        // return memo(n-1,m-1,s,t,dp);
        // return rec(n-1,m-1,s,t);
    }
    // private static int rec(int i,int j,String s,String t){
    //     if(j<0) return 1;
    //     if(i<0) return 0;

    //     if(s.charAt(i)==t.charAt(j)){
    //         return rec(i-1,j-1,s,t)+rec(i-1,j,s,t);
    //     }else{
    //         return rec(i-1,j,s,t);
    //     }
    // }

    // private static int memo(int i,int j,String s,String t,int[][] dp){
    //     if(j<0) return 1;
    //     if(i<0) return 0;

    //     if(dp[i][j]!=-1) return dp[i][j];
        
    //     if(s.charAt(i)==t.charAt(j)){
    //         return dp[i][j]=memo(i-1,j-1,s,t,dp)+memo(i-1,j,s,t,dp);
    //     }else{
    //         return dp[i][j]=memo(i-1,j,s,t,dp);
    //     }
    // }
    // private static int tabu(String s,String t,int n, int m){
    //     int[][] dp=new int[n+1][m+1];
    //     for(int i=0;i<=n;i++){
    //         dp[i][0]=1;
    //     }
    //     for(int j=1;j<=m;j++){
    //         dp[0][j]=0;
    //     }
    //     for(int i=1;i<=n;i++){
    //         for(int j=1;j<=m;j++){
    //             if(s.charAt(i-1)==t.charAt(j-1)){
    //                 dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
    //             }else{
    //                 dp[i][j] = dp[i-1][j];
    //             }
    //         }
    //     }
    //     return dp[n][m];
    // }
    // private static int space(String s,String t,int n, int m){
    //     int[] prev=new int[m+1];
    //     int[] curr=new int[m+1];
    //     prev[0]=curr[0]=1;

    //     for(int i=1;i<=n;i++){
    //         for(int j=1;j<=m;j++){
    //             if(s.charAt(i-1)==t.charAt(j-1)){
    //                 curr[j] = prev[j-1] + prev[j];
    //             }else{
    //                 curr[j] = prev[j];
    //             }
    //         }
    //         for(int k=0;k<=m;k++){
    //             prev[k]=curr[k];
    //         }
    //     }
    //     return prev[m];
    // }
    private static int spaceOpt(String s,String t,int n, int m){
        int[] prev=new int[m+1];
        
        prev[0]=1;

        for(int i=1;i<=n;i++){
            for(int j=m;j>=1;j--){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    prev[j] = prev[j-1] + prev[j];
                }
            }
        }
        return prev[m];
    }
}