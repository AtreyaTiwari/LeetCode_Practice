class Pair{
    int row;
    int col;
    int time;
    Pair(int row,int col, int time){
        this.row=row;
        this.col=col;;
        this.time=time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int fresh=0;
        Queue<Pair> q=new LinkedList<>();
        int[][] vis=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1) fresh++;
            }
        }
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        int time=0;
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int t=q.peek().time;
            q.remove();
            time=Math.max(t,time);
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1 && vis[nr][nc]==0){
                    vis[nr][nc]=2;
                    fresh--;
                    q.add(new Pair(nr,nc,t+1));
                }
            }
        }
        return fresh==0?time:-1;
    }
}