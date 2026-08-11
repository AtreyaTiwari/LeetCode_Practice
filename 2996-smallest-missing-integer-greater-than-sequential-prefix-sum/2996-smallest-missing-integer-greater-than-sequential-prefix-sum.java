class Solution {
    public int missingInteger(int[] nums) {
        int n=nums.length;
        int sum=nums[0];
        int[] freq=new int[51];
        for(int num:nums) freq[num]++;

        for(int i=1;i<n;i++){
            if(nums[i]!=nums[i-1]+1){
                break;
            }else{
                sum+=nums[i];
            }
        }
        if(sum>50) return sum;
        while(freq[sum]!=0){
            sum++;
            if(sum>50) return sum;
        }
        return sum;
    }
}