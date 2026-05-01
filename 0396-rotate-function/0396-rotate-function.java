class Solution {
    public int maxRotateFunction(int[] nums) {
        int n=nums.length;
        // int[] dp=new int[n];
        int fun=0;
        int totSum=0;
        for(int i=0;i<n;i++){
            fun+=(nums[i]*i);
            totSum+=nums[i];
        }
        // int ans=dp[0];
        int ans=fun;
        for(int k=1;k<n;k++){
            ans=Math.max(ans,fun+(totSum-nums[n-k])-(nums[n-k]*(n-1)));
            fun=fun+(totSum-nums[n-k])-(nums[n-k]*(n-1));
        }
        return ans;
    }
}