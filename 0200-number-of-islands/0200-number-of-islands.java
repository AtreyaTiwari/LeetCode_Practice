class Pair{
    int first;
    int second;
    
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        int[][] visited=new int[n][m];
        int count=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && grid[i][j]=='1'){
                    count++;
                    // bfs(i,j,visited,grid);
                    dfs(i,j,visited,grid);
                }        
            }
        }
        return count;
    }
    private static void dfs(int i,int j,int[][] vis,char[][] grid){
        vis[i][j]=1;
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        int n=grid.length;
        int m=grid[0].length;
        for(int k=0;k<4;k++){
            int ni=i+dx[k];
            int nj=j+dy[k];

            if(ni<n && ni>=0 && nj<m && nj>=0 && vis[ni][nj]==0 && grid[ni][nj]=='1'){
                dfs(ni,nj,vis,grid);
            }
        }
    }
    // private void bfs(int row,int col,int[][] visited,char[][] grid){
    //     visited[row][col]=1;
    //     Queue<Pair> q=new LinkedList<Pair>();
    //     q.add(new Pair(row,col));
    //     int n=grid.length;
    //     int m=grid[0].length;
        
    //     int[] dRow = {-1, 0, 1, 0};
    //     int[] dCol = {0, 1, 0, -1};
        
    //     while(!q.isEmpty()) {
    //         int x = q.peek().first;
    //         int y = q.peek().second;
    //         q.remove();
            
    //         for(int i = 0; i < 4; i++) {
    //             int nrow = x + dRow[i];
    //             int ncol = y + dCol[i];
    //     // while(!q.isEmpty()){
    //     //     int x=q.peek().first; //row for the element 
    //     //     int y=q.peek().second; //column for the element
    //     //     q.remove();
            
    //     //     for(int i=-1;i<=1;i++){
    //     //         for(int j=-1;j<=1;j++){
    //     //             int nrow=x+i;
    //     //             int ncol=y+j;
                    
    //                 if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && visited[nrow][ncol]==0){
    //                     visited[nrow][ncol]=1;
    //                     q.add(new Pair(nrow,ncol));
    //                 }
                    
    //             }
    //         }
    //     }
    // }
}