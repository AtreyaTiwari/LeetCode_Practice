class Solution {
    public int distinctSubseqII(String s) {
        long mod=1000000007;
        long dp=1;
        long[] last=new long[26];
        int n=s.length();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            int ind=c-'a';
            long newDp=(2*dp-last[ind]+mod)%mod;
            last[ind]=dp;
            dp=newDp;
        }
        return (int)((dp-1+mod)%mod);
    }
}