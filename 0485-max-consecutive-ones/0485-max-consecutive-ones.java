class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0,appear=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                appear++;
            }else{
                max=Math.max(max,appear);
                appear=0;
            }
        }
        max=Math.max(max,appear);
        return max;
    }
}