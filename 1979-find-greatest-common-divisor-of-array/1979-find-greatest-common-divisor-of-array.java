class Solution {
    public int findGCD(int[] nums) {
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        for(int num:nums){
            if(low>num) low=num;
            if(high<num) high=num;
        }
        return gcd(low,high);
    }
    private static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}