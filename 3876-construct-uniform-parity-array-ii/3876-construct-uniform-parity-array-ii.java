class Solution {
    public boolean uniformArray(int[] nums) {
        int n=nums.length;
        if(n==1) return true;
        //odd
        boolean allOdd=true;
        for(int num:nums){ if(num%2==0) allOdd=false;}
        if(allOdd) return true;
        int smlOdd=Integer.MAX_VALUE;
        int smlEven=Integer.MAX_VALUE;
        int grtEven=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]%2==1){
                smlOdd=Math.min(smlOdd,nums[i]);
            }else{
                smlEven=Math.min(smlEven,nums[i]);
                grtEven=Math.max(grtEven,nums[i]);
            }
        }
        if(grtEven!=Integer.MIN_VALUE && smlOdd!=Integer.MAX_VALUE && grtEven-smlOdd>=1 && smlEven>smlOdd) return true;
        //even 
        for(int num:nums){
            if(num%2==1) return false;
        }
        return true;
    }
}