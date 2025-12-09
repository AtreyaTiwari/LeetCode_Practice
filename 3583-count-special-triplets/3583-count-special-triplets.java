class Solution {
    static int mod=1000000007;
    public int specialTriplets(int[] nums) {
        long[] leftPos=new long[200001];
        long[] rightPos=new long[200001];
        int n=nums.length;
        for(int i=0;i<n;i++){
            rightPos[nums[i]]++;
        } 
        long count=0;
        for(int i=0;i<n;i++){
            int target=nums[i]*2;
            rightPos[nums[i]]--;

            count= (count + ((leftPos[target]*rightPos[target]))%mod)%mod;

            leftPos[nums[i]]++;
        }
        return (int)count;
    }
}