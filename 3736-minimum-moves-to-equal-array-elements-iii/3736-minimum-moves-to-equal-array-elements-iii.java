class Solution {
    public int minMoves(int[] nums) {
        int[] freq=new int[101];
        for(int n:nums){
            freq[n]++;
        }
        int count=0;
        int max=0;
        for(int i=100;i>=1;i--){
            if(freq[i]!=0){
                max=i;
                break;
            }
        }
        for(int i=max-1;i>=0;i--){
            if(freq[i]!=0){
                count+=((max-i)*freq[i]);
            }
        }
        return count;
    }
}