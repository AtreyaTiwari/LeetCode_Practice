class Solution {
    public long[] distance(int[] nums) {
        HashMap<Integer,Long> count=new HashMap<>();
        HashMap<Integer,Long> sum=new HashMap<>();
        int n=nums.length;
        long[] ans=new long[n];
        
        for(int i=0;i<n;i++){
            int num=nums[i];
            long c=count.getOrDefault(num,0L);
            long s=sum.getOrDefault(num,0L);
            ans[i]+=c*i - s;
            count.put(num,c+1);
            sum.put(num,s+i);
        }
        count.clear();
        sum.clear();
        for(int i=n-1;i>=0;i--){
            int num=nums[i];
            long c=count.getOrDefault(num,0L);
            long s=sum.getOrDefault(num,0L);
            ans[i]+=s-c*i;
            count.put(num,c+1);
            sum.put(num,s+i);
        }
        return ans;
    }
}