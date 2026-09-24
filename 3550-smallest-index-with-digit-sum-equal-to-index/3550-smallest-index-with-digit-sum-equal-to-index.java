class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(helper(nums[i],i)){
                return i;
            }
        }
        return -1;
    }
    private boolean helper(int digit,int i){
        int sum=0;
        while(digit>0){
            sum+=digit%10;
            digit/=10;
        }
        return sum==i;
    }
}