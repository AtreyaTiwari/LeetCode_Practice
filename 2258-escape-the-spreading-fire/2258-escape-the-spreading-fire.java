class Solution {
    static class Pair{
        int i,j,time;
        Pair(int i,int j,int time){
            this.i=i;this.j=j;this.time=time;
        }
    }
    public int maximumMinutes(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] timeGrid=new int[m][n];
        for(int[] arr:timeGrid){
            Arrays.fill(arr,1000000009);
        }
        bfsFill(grid,timeGrid);
        // if(canReach(1000000009)) return 1000000009;

        int min=0;int max=1000000000;
        while(min<=max){
            int mid=min+(max-min)/2;
            if(canReach(mid,grid,timeGrid)){
                min=mid+1;
            }else{
                max=mid-1;
            }
        }
        return max;
    }
    private static boolean canReach(int wait,int[][] grid,int[][] timeGrid){
        int m=grid.length;
        int n=grid[0].length;

        if(wait>=timeGrid[0][0]) return false;

        boolean[][] vis=new boolean[m][n];
        Queue<Pair> q=new LinkedList<>();
        vis[0][0]=true;
        q.add(new Pair(0,0,wait));

        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};

        while(!q.isEmpty()){
            int i=q.peek().i;
            int j=q.peek().j;
            int time=q.peek().time;
            q.poll();

            if(i==m-1 && j==n-1) return true;
            
            for(int k=0;k<4;k++){
                int ni=i+dx[k];
                int nj=j+dy[k];

                if(ni<0 || ni>=m || nj<0 || nj>=n || grid[ni][nj]==2 || vis[ni][nj]){
                    continue;
                }

                int nextTime=time+1;
                
                if(ni==m-1 && nj==n-1){
                    if(timeGrid[ni][nj]==1000000009 ||nextTime<=timeGrid[m-1][n-1]){
                        vis[ni][nj]=true;
                        q.add(new Pair(ni,nj,nextTime));
                    }
                }else{
                    if(timeGrid[ni][nj]==1000000009 ||nextTime<timeGrid[ni][nj]){
                        vis[ni][nj]=true;
                        q.add(new Pair(ni,nj,nextTime));
                    }
                }
            }
        }
        return false;
    }

    private static void bfsFill(int[][] grid,int[][] timeGrid){
        int m=grid.length;
        int n=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    timeGrid[i][j]=0;
                    q.add(new Pair(i,j,0));
                }
            }
        }
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        while(!q.isEmpty()){
            int i=q.peek().i;
            int j=q.peek().j;
            int time=q.peek().time;
            q.remove();
            
            for(int k=0;k<4;k++){
                int ni=i+dx[k];
                int nj=j+dy[k];
                
                if(ni<m && ni>=0 && nj<n && nj>=0 && grid[ni][nj]!=2 && timeGrid[ni][nj]>time+1){
                    timeGrid[ni][nj]=time+1;
                    q.add(new Pair(ni,nj,time+1));
                }
            }
        }
        // System.out.println(Arrays.deepToString(timeGrid));
    }

}