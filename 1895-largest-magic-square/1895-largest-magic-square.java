class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int k=Math.min(m,n);
        for(int i=k;i>1;i--){
            if(solve(i,m,n,grid)){
                return i;
            }
        }
        return 1;
    }
    private static boolean solve(int k,int m,int n,int[][] grid){
        for(int i=0;i<=m-k;i++){
            for(int j=0;j<=n-k;j++){
                if(sumCheck(i, i+k-1, j, j+k-1, grid)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean sumCheck(int sti,int endi,int stj,int endj,int[][] grid){
        int check=0;
        for(int i=sti;i<=endi;i++){
            check+=grid[i][stj];
        }

        //row check
        for(int i=sti;i<=endi;i++){
            int sum=0;
            for(int j=stj;j<=endj;j++){
                sum+=grid[i][j];
            }
            if(sum!=check){
                return false;
            }
        }

        //col check
        for(int j=stj;j<=endj;j++){
            int sum=0;
            for(int i=sti;i<=endi;i++){
                sum+=grid[i][j];
            }
            if(sum!=check){
                return false;
            }
        }
        //diagonal
        int k=endi-sti+1;
        int primarySum = 0;
        int secondarySum = 0;
        for (int d = 0; d < k; d++) {
            primarySum += grid[sti + d][stj + d];
            secondarySum += grid[sti + d][endj - d];
        }
        if(primarySum!=check || secondarySum!=check) return false;

        return true;
    }
}