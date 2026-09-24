class Solution {
    public int subarraySum(int[] arr, int target) {
        int n=arr.length,count =0;
        int sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);

        for(int num:arr){
            sum+=num;
            if(map.containsKey(sum-target)){
                count+=map.get(sum-target);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }   
}