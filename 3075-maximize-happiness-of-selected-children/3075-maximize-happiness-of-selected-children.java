class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int step=0;
        long sum=0;
        int n=happiness.length;
        Arrays.sort(happiness);

        for(int i=n-1;i>=0;i--){
            sum+=Math.max(happiness[i]-step,0);
            step++;
            if(step==k) break;
        }
        return sum;

        //correct but less optimized
        // PriorityQueue<Integer> mh=new PriorityQueue<>(Collections.reverseOrder());
        // for(int n:happiness){
        //     mh.add(n);
        // }
        // for(int i=0;i<k;i++){
        //     int num=(mh.poll()-step);
        //     if(num<0) num=0;
        //     sum+=(long)num;
        //     step++;
        // }
        // return sum;
    }
}