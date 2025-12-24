class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int sum=0;
        int count=0;
        int m=capacity.length;
        for(int num:apple){
            sum+=num;
        }
        int cap=0;
        for(int i=m-1;i>=0;i--){
            cap+=capacity[i];
            count++;
            if(cap>=sum) break;
        }
        return count;
    }
}