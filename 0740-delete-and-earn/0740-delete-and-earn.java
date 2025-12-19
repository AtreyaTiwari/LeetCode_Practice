class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int n=nums.length;
        Arrays.sort(nums);
        int[] freq=new int[10001];
        for(int num:nums){
            freq[num]++;
        }
        int[] dp=new int[nums[n-1]+1];
        Arrays.fill(dp,-1);
        return rec(nums[0],nums,n,freq,nums[n-1],dp);

    }
    private static int rec(int value,int[] nums,int n,int[] freq,int max,int[] dp){
        if(value>max){
            return 0;
        }
        if(dp[value]!=-1) return dp[value];
        int ans=0;
        int notChoose=rec(value+1,nums,n,freq,max,dp);
        
        int choose=(value*freq[value])+rec(value+2,nums,n,freq,max,dp);
        
        return dp[value]=ans=Math.max(choose,notChoose);
        
        
    }
}