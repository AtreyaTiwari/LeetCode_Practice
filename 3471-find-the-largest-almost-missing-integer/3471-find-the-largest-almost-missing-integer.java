class Solution {
    public int largestInteger(int[] nums, int k) {
        
        int[] prev=new int[51];
        int n=nums.length;
        for(int i=0;i<=n-k;i++){
            int[] freq=new int[51];
            for(int j=i;j<i+k;j++){
                int num=nums[j];
                if(prev[num]!=0) freq[num]=-1;
                else if(prev[num]==0) freq[num]=1;
            }
            for(int h=0;h<51;h++){
                if(freq[h]!=0) prev[h]=freq[h];
            }
        }
        for(int i=50;i>=0;i--){
            if(prev[i]==1) return i;
        }
        return -1;
    }
}