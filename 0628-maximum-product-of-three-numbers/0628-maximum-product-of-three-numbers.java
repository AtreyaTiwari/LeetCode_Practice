class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for(int num: nums) {
            if(max1 < num) {
                max1 = num;
                if(max2 < num) {
                    max1 = max2;
                    max2 = num;
                    if(max3 < num) {
                        max2 = max3;
                        max3 = num;
                    }
                }
            }
            if(min1 > num) {
                min1 = num;
                if(min2 > num) {
                    min1 = min2;
                    min2 = num;
                }
            }
        }
        return Math.max(max1*max2*max3, min1*min2*max3);
    }
}