class Solution {
    public int earliestFinishTime(int[] landS, int[] landD, int[] waterS, int[] waterD) {
        int n=landS.length;
        int m=waterS.length;
        int time=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int s=landS[i]+landD[i];
            for(int j=0;j<m;j++){
                if(waterS[j]<=s){
                    s+=waterD[j];
                }else if(waterS[j]>s){
                    s+=waterD[j]+(waterS[j]-s);
                }
                time=Math.min(time,s);
                s=landS[i]+landD[i];
            }
        }
        for(int i=0;i<m;i++){
            int s=waterS[i]+waterD[i];
            for(int j=0;j<n;j++){
                if(landS[j]<=s){
                    s+=landD[j];
                }else if(landS[j]>s){
                    s+=landD[j]+(landS[j]-s);
                }
                time=Math.min(time,s);
                s=waterS[i]+waterD[i];
            }
        }
        return time;
    }
}