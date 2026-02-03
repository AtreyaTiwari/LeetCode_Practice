class Solution {
    public boolean isTrionic(int[] nums) {
        int n=nums.length;
        int p=-1,q=-1;
        int i=0;
        while( i<n-1 && nums[i]<nums[i+1]){
            i++;
        }
        if(i==n-1 || i==0) return false;
        else p=i;
        i=p;
        while(i<n-1 && nums[i]>nums[i+1]){
            i++;
        }
        if(i==n-1) return false;
        else q=i;
        i=q;
        while(i<=n-2 && nums[i]<nums[i+1]){
            i++;
        }
        if(i==n-1) return true;
        return false;
    }
}