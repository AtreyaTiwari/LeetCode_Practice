class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums) map.put(num,map.getOrDefault(num,0)+1);

        int ans=1;
        for(int num:nums){
            if(num==1){
                if(map.get(num)%2!=0){
                    ans=Math.max(ans,map.get(num));
                }else{
                    ans=Math.max(ans,map.get(num)-1);
                }
            }else{
                int count=0;
                if(map.get(num)>=2){
                    long curr=num;

                    while(curr<=Integer.MAX_VALUE && map.containsKey((int)curr)){
                        if(map.get((int)curr)==1){
                            count++;
                            break;
                        }
                        count++;
                        if(curr>Long.MAX_VALUE/curr) break;
                        curr*=curr;
                    }
                }
                ans=Math.max(ans,2*count-1);
            }
        }
        return ans;
    }
}