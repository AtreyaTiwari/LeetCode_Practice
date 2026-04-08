class Solution {
    public int maxProfit(int[] nums) {
    // int mini=nums[0];
    // int profit=0;
    // int n=nums.length;

    // for(int i=1;i<n;i++){
    //     profit=Math.max(profit,nums[i]-mini);
    //     mini=Math.min(mini,nums[i]);
    // }
    // return profit;
    int ans=0;
    int low=nums[0];
    for(int i=1;i<nums.length;i++){
        if(ans<nums[i]-low){
            ans=nums[i]-low;
        }
        if(low>nums[i]){
            low=nums[i];
        }
    }
    return ans;
    }
}