class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n=nums.length;
        // int[] dp=new int[n];
        // Arrays.fill(dp,-1);
        // int ans= memo(nums,target,0,dp);
        int ans= tabu(nums,target);
        return ans==0?-1:ans;
    }
    // private static int memo(int[] nums,int target,int ind,int[] dp){
    //    if(ind==nums.length-1) return dp[ind]=0;
    
    //    if(dp[ind]!=-1) return dp[ind];
    //    int ans=-1;
    //    for(int j=ind+1;j<nums.length;j++){
    //     if(Math.abs(nums[ind]-nums[j])<=target){
    //         int jump=memo(nums,target,j,dp);
    //         if(jump!=-1){
    //             ans=Math.max(ans,jump+1);
    //         }
    //     }
    //    }
    //    return dp[ind]=ans;
    // }
    private static int tabu(int[] nums,int target){
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        dp[n-1]=0;
        int ans=-1;
        for(int ind=n-2;ind>=0;ind--){
            for(int j=ind+1;j<n;j++){
                if(Math.abs(nums[ind]-nums[j])<=target && dp[j]!=-1){
                    dp[ind]=Math.max(dp[ind],1+dp[j]);
                }
            }
        }
        return dp[0];
    }
}