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
        int n=grid.length;int m=grid[0].length;
        int[][] vis=new int[n][m];
        Queue<Pair> q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int time=0;
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        int count=0;
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int t=q.peek().time;
            time=Math.max(time,t);
            q.remove();

            for(int i=0;i<4;i++){
                int nr=r+drow[i];
                int nc=c+dcol[i];

                if(nr<n&&nr>=0 && nc<m&&nc>=0 && grid[nr][nc]==1 && vis[nr][nc]==0){
                    q.add(new Pair(nr,nc,t+1));
                    vis[nr][nc]=2;
                    count++;
                }
            }
        }
        return count==fresh?time:-1;
    }
    // public int orangesRotting(int[][] grid) {
    //     int n=grid.length;int m=grid[0].length;
    //     int[][] vis=new int[n][m];
    //     //traverse grid and prepare visited
    //     Queue<Pair> q=new LinkedList<>();
    //     int fresh=0;
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<m;j++){
    //             if(grid[i][j]==2){
    //                 q.add(new Pair(i,j,0));
    //                 vis[i][j]=2;
    //             }else{
    //                 vis[i][j]=0;
    //             }
    //             if(grid[i][j]==1){
    //                 fresh++;
    //             }
    //         }
    //     }

    //     int time=0;
    //     int[] drow={-1,0,1,0};
    //     int[] dcol={0,1,0,-1};
    //     int count=0;

    //     while(!q.isEmpty()){
    //         int r=q.peek().row;
    //         int c=q.peek().col;
    //         int t=q.peek().time;
    //         time=Math.max(time,t);
    //         q.remove();
            
    //         for(int i=0;i<4;i++){
    //             int nrow= r+drow[i];
    //             int ncol= c+dcol[i];

    //             if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
    //                 q.add(new Pair(nrow,ncol,t+1));
    //                 vis[nrow][ncol]=2;
    //                 count++;
    //             }
    //         }
    //     }
    //     if(count!=fresh) return -1;
    //     return time;
    // }
}