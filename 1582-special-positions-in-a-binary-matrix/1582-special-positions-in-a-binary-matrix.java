class Solution {
    public int numSpecial(int[][] mat) {
        int count=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    if(check(i,j,mat)) count++;
                }
            }
        }
        return count;
    }
    private static boolean check(int row,int col,int[][] mat){
        for(int i=0;i<mat[0].length;i++){
            if(mat[row][i]==1 && i!=col) return false;
        }
        for(int i=0;i<mat.length;i++){
            if(mat[i][col]==1 && i!=row) return false;
        }
        return true;
    }
}