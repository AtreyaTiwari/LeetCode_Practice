class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long org=0;
        
        int n=prices.length;
        for(int i=0;i<n;i++){
            long prod=prices[i]*strategy[i];
            org+=prod;
        }
        long ans=org;
        long[] deltaFirst = new long[n];
        long[] deltaSecond = new long[n];

        for(int i=0;i<n;i++){
            deltaFirst[i]= -(long) strategy[i] * prices[i];
            deltaSecond[i] = prices[i] - (long) strategy[i] * prices[i];
        }

        int h = k / 2;
        long first=0;
        for(int i=0;i<h;i++) first+=deltaFirst[i];
        for(int i=h;i<k;i++) first+=deltaSecond[i];

        ans=Math.max(org,org+first);

        for(int i=0;i+k<n;i++){
            
            first-=deltaFirst[i];
            first+=deltaFirst[i+h];

            first-=deltaSecond[i+h];
            first+=deltaSecond[i+k];

            ans=Math.max(ans,org+first);
        }
        
        return ans;
    }
}