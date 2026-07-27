class Solution {
    public int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE;
        int secMax=Integer.MIN_VALUE;
        for(int num:nums){
            if(num>max){
                secMax=max;
                max=num;
            }else if(num>secMax){
                secMax=num;
            }
        }
        return (max-1)*(secMax-1);
    }
}