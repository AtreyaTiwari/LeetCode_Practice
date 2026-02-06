class Solution {
    public int minRemoval(int[] nums, int k) {
        int maxLen=0;
        Arrays.sort(nums);
        int l=0;
        int n=nums.length;
        
        for(int r=0;r<n;r++){
            while((long)nums[r]>(long)nums[l]*k){
                l++;
            }
            maxLen=Math.max(maxLen,r-l+1);
        }


        return n-maxLen;
    }
}