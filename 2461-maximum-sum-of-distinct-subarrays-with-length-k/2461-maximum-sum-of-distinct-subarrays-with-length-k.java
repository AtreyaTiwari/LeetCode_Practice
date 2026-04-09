class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int left=0;
        Set<Integer> set=new HashSet<>();
        long sum=0;
        long maxi=0;
        for(int r=0;r<nums.length;r++){
            int num=nums[r];
            while(set.contains(num) || r-left+1>k){
                sum-=nums[left];
                set.remove(nums[left]);
                left++;
            }
            sum+=nums[r];
            set.add(nums[r]);
            if(r-left+1==k && set.size()==k){
                if(sum>maxi){
                    maxi=sum;
                }
            }
        }
        return maxi;
    }
}