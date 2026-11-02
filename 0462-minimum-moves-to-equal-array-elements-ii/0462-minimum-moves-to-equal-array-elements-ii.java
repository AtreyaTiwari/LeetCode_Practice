class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int mid=n%2==0?(n/2)-1:n/2;
        int ans=0;
        for(int num:nums){
            ans+=Math.abs(num-nums[mid]);
        }
        return ans;
    }
}