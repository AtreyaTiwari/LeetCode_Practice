class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        List<Integer> pos=new ArrayList<>();
        List<Integer> neg=new ArrayList<>();

        for(int num:nums){
            if(num<0) neg.add(num);
            else pos.add(num);
        }
        int m=0,k=0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                nums[i]=pos.get(m++);
            }else{
                nums[i]=neg.get(k++);
            }
        }
        return nums;
    }
}