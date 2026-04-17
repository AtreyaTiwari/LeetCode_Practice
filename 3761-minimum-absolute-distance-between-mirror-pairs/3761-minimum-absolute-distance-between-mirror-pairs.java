class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int ans=Integer.MAX_VALUE;
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=0;
        for(int n:nums){
            if(map.containsKey(n)){
                ans=Math.min(ans,i-map.get(n));
            }
            int rev=rev(n);
            map.put(rev,i);
            i++;
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    private int rev(int num){
        int rev=0;
        while(num>0){
            rev=rev*10+(num%10);
            num/=10;
        }   
        return rev;
    }
}