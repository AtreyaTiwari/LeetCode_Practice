class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int n=nums.length;
        for(int i=n-1;i>=0;i--){
            int num=nums[i];
            while(num>0){
                list.add(num%10);
                num/=10;
            }
        }
        int m=list.size();
        int[] ans=new int[m];
        for(int i=m-1;i>=0;i--){
            ans[i]=list.get(m-i-1);
        }
        return ans;
    }
}