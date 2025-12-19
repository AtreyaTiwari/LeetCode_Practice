class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int n=nums.length;
        int max=-1;
        for(int num:nums){
            if(num>max){
                max=num;
            }
        }
        int[] freq=new int[max+1];
        for(int num:nums){
            freq[num]++;
        }
        int[] dp=new int[max+1];
        Arrays.fill(dp,-1);
        return rec(1,n,freq,max,dp);

    }
    private static int rec(int value,int n,int[] freq,int max,int[] dp){
        if(value>max){
            return 0;
        }
        if(dp[value]!=-1) return dp[value];
        int ans=0;
        int notChoose=rec(value+1,n,freq,max,dp);
        int choose=(value*freq[value])+rec(value+2,n,freq,max,dp);
        return dp[value]=ans=Math.max(choose,notChoose);
    }
}