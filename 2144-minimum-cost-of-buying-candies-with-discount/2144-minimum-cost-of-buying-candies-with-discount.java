class Solution {
    public int minimumCost(int[] cost) {
        int n=cost.length;
        Arrays.sort(cost);
        int c=0;
        for(int i=n-1;i>=0;i-=3){
            c+=cost[i];
            if(i-1>=0){
                c+=cost[i-1];
            }
        }
        return c;
    }
}