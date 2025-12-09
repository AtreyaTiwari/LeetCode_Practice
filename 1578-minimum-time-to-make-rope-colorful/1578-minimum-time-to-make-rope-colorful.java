class Solution {
    public int minCost(String colors, int[] neededTime) {
        int time=0;
        int n=colors.length();
        int prevTime=neededTime[0];
        char[] str=colors.toCharArray();
        for(int i=1;i<n;i++){
            if(str[i]==str[i-1]){
                time+=Math.min(prevTime,neededTime[i]);
                prevTime=Math.max(neededTime[i],prevTime);
            }else{
                prevTime=neededTime[i];
            }
        }
        return time;
    }
}