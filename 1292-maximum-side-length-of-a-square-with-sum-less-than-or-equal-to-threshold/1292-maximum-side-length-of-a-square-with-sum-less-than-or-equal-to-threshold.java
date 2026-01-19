class Solution {
    public int maxSideLength(int[][] mat, int th) {
        int m=mat.length;
        int n=mat[0].length;
        int k=Math.min(m,n);
        int low=0;int high=k;
        while(low<high){
            int i=(low+high+1)/2;
            if(solve(i,m,n,mat,th)){
                low=i;
            }else{
                high=i-1;
            }
        }
        return low;
    }
    private static boolean solve(int k,int m,int n,int[][] mat,int th){
        for(int i=0;i<=m-k;i++){
            for(int j=0;j<=n-k;j++){
                if(sumCheck(i, i+k-1, j, j+k-1, mat,th)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean sumCheck(int sti,int endi,int stj,int endj,int[][] mat,int th){
        
        int sum=0;
        for(int i=sti;i<=endi;i++){
            for(int j=stj;j<=endj;j++){
                sum+=mat[i][j];
                if(sum>th) return false;
            }
        }
        return true;
    }
}