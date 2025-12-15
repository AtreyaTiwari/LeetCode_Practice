class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
        int ans=0;
        int prev=1;
        int n=nums.length;
        int j=0;
        for(int i=0;i<n;i++){
            prev*=nums[i];
            while(!(prev<k) && j<=i){
                prev/=nums[j++];
                
            }
            ans+=(i-j+1);
        }
        return ans;
    }
}