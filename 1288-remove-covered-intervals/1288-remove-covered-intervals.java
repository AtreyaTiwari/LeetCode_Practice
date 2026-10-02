class Solution {
    public int removeCoveredIntervals(int[][] arr) {
        
        Arrays.sort(arr,(a,b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            return b[1]-a[1];
        });
        int count=0;
        int n=arr.length;
        int st=arr[0][0];
        int end=arr[0][1];
        for(int i=1;i<n;i++){
            if(arr[i][0]<=end && arr[i][1]<=end){
                count++;
            }else{
                st=arr[i][0];
                end=arr[i][1];
            }
        }
        return n-count;
    }
}