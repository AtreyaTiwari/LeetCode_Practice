class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n=grid.length, m=grid[0].length;
        int[][] preSum=new int[n][m];
        int[][] preX=new int[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int val=0;
                int x=grid[i][j]=='X'?1:0;
                
                if(grid[i][j]=='X') val=1;
                else if(grid[i][j]=='Y') val=-1;

                preSum[i][j]=val;
                preX[i][j]=x;

                if(i>0){
                    preSum[i][j] +=preSum[i-1][j];
                    preX[i][j] +=preX[i-1][j];
                }
                if(j>0){
                    preSum[i][j] +=preSum[i][j-1];
                    preX[i][j] +=preX[i][j-1];
                }
                if(i>0 && j>0){
                    preSum[i][j] -=preSum[i-1][j-1];
                    preX[i][j] -=preX[i-1][j-1];
                }
                if(preSum[i][j]==0 && preX[i][j]>0){
                    count++;
                }
            }
        }
        return count;
    }
}