class Solution {
    public int numEnclaves(int[][] board) {
        int m=board.length;
        int n=board[0].length;

        boolean[][] vis=new boolean[m][n];
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};

        //first and last rows
        for(int i=0;i<n;i++){
            if(board[0][i]==1 && !vis[0][i]){
                dfs(0,i,board,vis,dr,dc,m,n);
            }

            if(board[m-1][i]==1 && !vis[m-1][i]){
                dfs(m-1,i,board,vis,dr,dc,m,n);
            }
        }

        //first and last cols
        for(int i=0;i<m;i++){
            if(board[i][0]==1 && !vis[i][0]){
                dfs(i,0,board,vis,dr,dc,m,n);
            }
            if(board[i][n-1]==1 && !vis[i][n-1]){
                dfs(i,n-1,board,vis,dr,dc,m,n);
            }
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1 && !vis[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
    private static void dfs(int r,int c,int[][] board,boolean[][] vis,int[] dr,int[] dc,int m,int n){
        vis[r][c]=true;

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            if(nr<m&&nr>=0&&nc<n&&nc>=0 && board[nr][nc]==1 && !vis[nr][nc]){
                dfs(nr,nc,board,vis,dr,dc,m,n);
            }
        }
    }
}