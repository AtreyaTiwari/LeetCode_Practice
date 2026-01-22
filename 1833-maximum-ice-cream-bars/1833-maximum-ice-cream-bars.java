class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max=-1;
        for(int i=0;i<costs.length;i++){
            if(costs[i]>=max){
                max=costs[i];
            }
        }
        int[] freq=new int[max+1];
        int count=0;
        for(int n:costs){
            freq[n]++;
        }
        for(int i=1;i<=max;i++){
            int pick=Math.min(freq[i],coins/i);
            coins-=(pick*i);
            count+=pick;   
        }
        return count;
    }
}