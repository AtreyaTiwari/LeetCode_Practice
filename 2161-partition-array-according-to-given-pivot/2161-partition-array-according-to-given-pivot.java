class Solution {
    public int[] pivotArray(int[] nums, int p) {
        List<Integer> small=new ArrayList<>();
        List<Integer> large=new ArrayList<>();
        int n=nums.length;
        int freq=0;
        for(int i=0;i<n;i++){
            if(nums[i]==p) freq+=1;
            else if(nums[i]<p){
                small.add(nums[i]);
            }else{
                large.add(nums[i]);
            }
        }
        int k=0;
        for(int i=0;i<small.size();i++){
            nums[k++]=small.get(i);
        }
        for(int i=0;i<freq;i++){
            nums[k++]=p;
        }
        for(int i=0;i<large.size();i++){
            nums[k++]=large.get(i);
        }
        return nums;
    }
}