class Solution {
    public int maxRotateFunction(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        int totSum=0;
        for(int i=0;i<n;i++){
            dp[0]+=(nums[i]*i);
            totSum+=nums[i];
        }
        int ans=dp[0];
        for(int k=1;k<n;k++){
            dp[k]=dp[k-1]+(totSum-nums[n-k])-(nums[n-k]*(n-1));
            ans=Math.max(ans,dp[k]);
        }
        return ans;
    }
}