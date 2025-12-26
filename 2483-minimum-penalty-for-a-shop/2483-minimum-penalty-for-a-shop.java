class Solution {
    public int bestClosingTime(String customers) {
        int n=customers.length();
        int[] pre=new int[n+1];
        pre[0]=0;
        for(int i=0;i<n;i++){
            char c=customers.charAt(i);
            if(c=='Y'){
                pre[i+1]=pre[i]+1;
            }else{
                pre[i+1]=pre[i]-1;
            }
        }
        int maxi=-1,max=Integer.MIN_VALUE;
        for(int i=0;i<=n;i++){
            if(pre[i]>max){
                max=pre[i];
                maxi=i;
            }
        }
        return maxi;
    }
}