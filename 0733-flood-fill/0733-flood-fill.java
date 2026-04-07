class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] ans=image;
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        int iniCol=image[sr][sc];

        dfs(sr,sc,ans,image,delrow,delcol,iniCol,newColor);

        return ans; 
    }
    private static void dfs(int row,int col,int[][] ans,int[][] image,int[] delrow,int[] delcol,int iniCol,int newColor){
        ans[row][col]=newColor;
        int n=image.length;
        int m=image[0].length;

        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==iniCol && ans[nrow][ncol]!=newColor){
                dfs(nrow, ncol, ans, image, delrow, delcol, iniCol, newColor);
            }
        }
    }
}