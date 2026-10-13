class Solution {
    public long maxAlternatingSum(int[] nums){
        int n=nums.length;
        // int max=-1;
        // if(n%2==0){
        //     max=n/2;
        // }else{
        //     max=(n/2)+1;
        // }
        // PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        // for(int num:nums){
        //     pq.add(Math.abs(num));
        // }
        // long sum=0;
        // for(int i=1;i<=max;i++){
        //     int x=pq.poll();
        //     sum+=  x*x;
        // }
        // while(!pq.isEmpty()){
        //     int x=pq.poll();
        //     sum-=  x*x;
        // }
        // return sum;

        long[] arr=new long[n];
        for(int i=0;i<n;i++){
            arr[i]= nums[i]*nums[i];
        }
        Arrays.sort(arr);
        long sum=0;
        for(int i=0;i<n;i++){
            if(i<n/2){
                sum -= arr[i];
            }else{
                sum += arr[i];
            }
        }
        return sum;
    }
}