class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n=nums.length;
        int flipped=0;
        int res=0;
        int[] flip=new int[n];
        for(int i=0;i<n;i++){
            if(i>=k){
                flipped^=flip[i-k]; //flip effect khtm hoa rha h
            }
            if(flipped==nums[i]){ //flip karna hi pdega 
                if(i+k>n) return -1; 
                flipped^=1;
                res++;
                flip[i]=1;
            }
        }
        return res;
    }
}