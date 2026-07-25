class Solution {
    public int maxProduct(int n) {
        int[] freq=new int[10];
        while(n>0){
            freq[n%10]++;
            n/=10;
        }
        int prod=1;
        int cnt=0;
        for(int i=9;i>=0;i--){
            if(freq[i]>1 && cnt<1){
                return i*i;
            }else if(freq[i]>=1){
                prod*=i;
                cnt++;
                if(cnt==2) break;
            }
        }
        return prod;
    }
}