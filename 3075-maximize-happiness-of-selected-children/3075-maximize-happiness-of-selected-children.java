class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int step=0;
        PriorityQueue<Integer> mh=new PriorityQueue<>(Collections.reverseOrder());

        for(int n:happiness){
            mh.add(n);
        }
        long sum=0;
        for(int i=0;i<k;i++){
            int num=(mh.poll()-step);
            if(num<0) num=0;
            sum+=(long)num;
            step++;
        }
        return sum;
    }
}