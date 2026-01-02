class Solution {
    public int repeatedNTimes(int[] nums) {
        int n=nums.length;
        int[] freq=new int[10001];
        for(int num:nums){
            freq[num]++;
            if(freq[num]==n/2){
                return num;
            }
        }
        return -1;
    }
}