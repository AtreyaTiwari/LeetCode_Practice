class Solution {
    public long countGood(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        int right=0;
        int left=0;
        long count=0;
        while(right<n){
            int num=nums[right];
            int freq=map.getOrDefault(num,0);
            
            k-=freq;
            map.put(num,freq+1);

            while(k<=0){
                count+=n-right;
                int rem=nums[left];
                int f=map.get(rem);
                k+=(f-1);
                map.put(rem,f-1);
                left++;
            }
            right++;
        }
        return count;
    }
}