class Solution {
    public int minimumCost(int[] nums) {
        int[] freq=new int[51];
        for(int i=1;i<nums.length;i++){
            freq[nums[i]]++;
        }
        int sum=nums[0],count=1;
        for(int i=1;i<51;i++){
            if(freq[i]!=0){
                sum+=(i);
                freq[i]--;
                i--;
                count+=1;
            }
            if(count==3) break;
        }
        return sum;
    }
}