class Solution {
    public long minNumberOfSeconds(int h, int[] workerTimes) {
        long low=0;
        int min=Integer.MAX_VALUE;
        for(int num:workerTimes) min=Math.min(num,min);
        long high=(long)min*(h)*(h+1)/2;
        long ans=high;

        while(low<=high){
            long mid=low+(high-low)/2;
            
            if(possible(mid,h,workerTimes)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }

        }
        return ans;
    }
    private static boolean possible(long sec,int h,int[] wt){
        long total=0;
        for(int t:wt){
            
            long x=((long)(Math.sqrt(1+ (8.0*sec)/t)-1)/2);

            total+=x;

            if(total>=h) return true;
        }
        return false;
    }
}