class Solution {
    public long maxSumTrionic(int[] nums) 
    {
        int n=nums.length;
        long[] prefsum=new long[n+1];
        int[] increasing=new int[n];
        int[] decreasing=new int[n];
        long[] maxsum=new long[n];
        for(int i=0;i<n;i++)
        {
            prefsum[i+1]=prefsum[i]+nums[i];
            increasing[i]=decreasing[i]=1;
        }
        
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i] < nums[i+1]) increasing[i]+=increasing[i+1];
            else if(nums[i] > nums[i+1]) decreasing[i]+=decreasing[i+1];
        }
        long curr=0;
        for(int i=n-1;i>=0;i--)
        {
            if(i + 1 < n && nums[i] < nums[i+1])
            {
                if(curr + nums[i] > nums[i]) curr+=nums[i];
                else curr=(long)nums[i];
                maxsum[i]=curr;
            }
            else if(i - 1 >= 0 && nums[i-1] < nums[i])
            {
                curr=(long)nums[i];
                maxsum[i]=curr;
            }
        }
        long max=(long)-1e17;
        for(int i=0;i<n-3;i++)
        {
            if(increasing[i] >= 2)
            {
                int j1=increasing[i]-1;
                int nextIdx1=i+j1;
                if(nextIdx1 < n && decreasing[nextIdx1] >= 2)
                {
                    int j2=decreasing[nextIdx1]-1;
                    int nextIdx2=nextIdx1+j2;
                    if(nextIdx2 < n && increasing[nextIdx2] >= 2)
                    {
                        int j=nextIdx2;
                        long s=prefsum[j+1]-prefsum[i];
                        max=Math.max(max,s+maxsum[j+1]);    
                    }
                }
            }
        }
        return max;
    }
}