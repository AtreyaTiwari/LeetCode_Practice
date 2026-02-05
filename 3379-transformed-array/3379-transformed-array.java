class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                int ind=i-Math.abs(nums[i]);
                if(ind<0){
                    ind=(n+(ind%n))%n;
                }
                res[i]=nums[ind];
            }else{
                res[i]=nums[(nums[i]+i)%n];
            }
        }
        return res;
    }
}