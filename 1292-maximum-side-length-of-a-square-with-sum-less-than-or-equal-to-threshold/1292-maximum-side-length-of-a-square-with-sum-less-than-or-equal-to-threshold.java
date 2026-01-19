class Solution {
    //optimized
    public int maxSideLength(int[][] mat, int th) {
        int m=mat.length;
        int n=mat[0].length;

        int[][] pre= new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                pre[i][j]=mat[i-1][j-1]+pre[i-1][j]+pre[i][j-1]-pre[i-1][j-1];
            }
        }
        int low=0;int high=Math.min(m,n);
        while(low<high){
            int i=(low+high+1)/2;
            if(solve(i,m,n,pre,th)){
                low=i;
            }else{
                high=i-1;
            }
        }
        return low;
    }
    private static boolean solve(int k,int m,int n,int[][] pre,int th){
        for(int i=k;i<=m;i++){
            for(int j=k;j<=n;j++){
                int sum=pre[i][j]-pre[i-k][j]-pre[i][j-k]+pre[i-k][j-k];
                if(sum<=th) return true;
            }
        }
        return false;
    }

    //not optimized
    // public int maxSideLength(int[][] mat, int th) {
    //     int m=mat.length;
    //     int n=mat[0].length;
    //     int k=Math.min(m,n);
    //     int low=0;int high=k;
    //     while(low<high){
    //         int i=(low+high+1)/2;
    //         if(solve(i,m,n,mat,th)){
    //             low=i;
    //         }else{
    //             high=i-1;
    //         }
    //     }
    //     return low;
    // }
    // private static boolean solve(int k,int m,int n,int[][] mat,int th){
    //     for(int i=0;i<=m-k;i++){
    //         for(int j=0;j<=n-k;j++){
    //             if(sumCheck(i, i+k-1, j, j+k-1, mat,th)){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
    // private static boolean sumCheck(int sti,int endi,int stj,int endj,int[][] mat,int th){
        
    //     int sum=0;
    //     for(int i=sti;i<=endi;i++){
    //         for(int j=stj;j<=endj;j++){
    //             sum+=mat[i][j];
    //             if(sum>th) return false;
    //         }
    //     }
    //     return true;
    // }
}