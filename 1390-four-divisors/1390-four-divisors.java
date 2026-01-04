class Solution {
    public int sumFourDivisors(int[] nums) {
        
        int max=0; int n=nums.length;

        for(int i=0;i<n;i++){
            if(max<nums[i]){
                max=nums[i];
            }
        }
        
        HashMap<Integer,Integer> map= devisor(max);
        int res=0;
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                res+=map.get(nums[i]);
            }
        }
        return res;
    }
    private static HashMap<Integer,Integer> devisor(int max){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int n=1;n<=max;n++){
            int sum=0;
            int count=0;
            for (int i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    count+=1;
                    sum+=i;
                    if (i != n / i)
                        count+=1;
                        sum+= (n/i);
                }
            }
            if(count==4){
                map.put(n,sum);
            }
        }
        return map;
    }
}