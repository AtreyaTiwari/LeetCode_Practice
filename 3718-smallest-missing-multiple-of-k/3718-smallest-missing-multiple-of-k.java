class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n=nums.length;
        int[] multiple=new int[n+1];
        for(int i=0;i<=n;i++){
            multiple[i]=k*(i+1);
        }
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        for(int num:multiple){
            if(!set.contains(num)){
                return num;
            }
        }
        return -1;
    }
}