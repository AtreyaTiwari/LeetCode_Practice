class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events,(a,b)-> Integer.compare(a[0], b[0]));
        int n=events.length;

        int[][] dp=new int[n][3];
        for(int[] ar:dp) Arrays.fill(ar,-1);
        return memo(0,events,n,2,dp);
        
        // return rec(0,events,n,2);

    }
    private static int memo(int i,int[][] events,int n,int k,int[][] dp){
        if(k==0||i==n) return 0;

        if(dp[i][k]!=-1) return dp[i][k];

        int notPick=memo(i+1,events,n,k,dp);

        int next=nextIndex(events,i);
        int pick=events[i][2]+memo(next,events,n,k-1,dp);

        return dp[i][k]=Math.max(pick,notPick);
    }
    
    // private static int rec(int i,int[][] events,int n,int k){
    //     if(k==0 || i==n){
    //         return 0;
    //     }
    //     int notPick=rec(i+1,events,n,k);
        
    //     int next=nextIndex(events,i);
    //     int pick=events[i][2]+rec(next,events,n,k-1);
        
    //     return Math.max(pick,notPick);
        
    // }
    private static int nextIndex(int[][] events, int i) {
        int start = i + 1, end = events.length - 1;
        int ind = events.length;
        int endTime = events[i][1];

        while (start<=end) {
            int mid = (start+end) / 2;
            if (events[mid][0] > endTime) {
                ind = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ind;
    }
}