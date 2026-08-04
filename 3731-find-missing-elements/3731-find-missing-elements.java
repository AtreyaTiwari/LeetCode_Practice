class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int[] arr=new int[101];
        for(int n:nums){
            arr[n]++;
        }
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int n:nums){
            if(n<min){
                min=n;
            }
            if(n>max){
                max=n;
            }
        }
        for(int i=min;i<=max;i++){
            if(arr[i]==0){
                ans.add(i);
            }
        }
        return ans;
    }
}