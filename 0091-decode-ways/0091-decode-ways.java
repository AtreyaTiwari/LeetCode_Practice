class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return s.length()==0?0:solve(0,s,dp);
    }
    private static int solve(int ind,String s,int[] dp){
        if(ind==s.length()) return 1;
        if(s.charAt(ind)=='0') return 0;
        if(dp[ind]!=-1) return dp[ind];
        int res=solve(ind+1,s,dp);
        if(ind<s.length()-1 && (s.charAt(ind)=='1' || s.charAt(ind)=='2' && s.charAt(ind+1)<'7'
        )){
            res+=solve(ind+2,s,dp);
        }
        return dp[ind]=res;
    }
}