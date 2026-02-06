class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;

        boolean[][] vis=new boolean[m][n];
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};

        //first and last rows
        for(int i=0;i<n;i++){
            if(board[0][i]=='O' && !vis[0][i]){
                dfs(0,i,board,vis,dr,dc,m,n);
            }

            if(board[m-1][i]=='O' && !vis[m-1][i]){
                dfs(m-1,i,board,vis,dr,dc,m,n);
            }
        }

        //first and last cols
        for(int i=0;i<m;i++){
            if(board[i][0]=='O' && !vis[i][0]){
                dfs(i,0,board,vis,dr,dc,m,n);
            }
            if(board[i][n-1]=='O' && !vis[i][n-1]){
                dfs(i,n-1,board,vis,dr,dc,m,n);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }
    private static void dfs(int r,int c,char[][] board,boolean[][] vis,int[] dr,int[] dc,int m,int n){
        vis[r][c]=true;

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            if(nr<m&&nr>=0&&nc<n&&nc>=0 && board[nr][nc]=='O' && !vis[nr][nc]){
                dfs(nr,nc,board,vis,dr,dc,m,n);
            }
        }
    }
}