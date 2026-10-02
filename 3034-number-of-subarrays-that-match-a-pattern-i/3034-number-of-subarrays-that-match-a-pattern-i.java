class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n=nums.length;
        int m=pattern.length;
        int count=0;
        for(int i=0;i<n-m;i++){
            boolean valid=true;
            for(int k=0;k<m;k++){
                if(pattern[k]==1){
                   valid=nums[i+k+1]>nums[i+k]?true:false;
                   if(!valid) break;
                }else if(pattern[k]==0){
                    valid=nums[i+k+1]==nums[i+k]?true:false;
                    if(!valid) break;
                }else{
                    valid=nums[i+k+1]<nums[i+k]?true:false;
                    if(!valid) break;
                }
            }
            if(valid) count++;
        }
        return count;
    }
}