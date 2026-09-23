class Solution {
    class Pair{
        int i,j,s;
        Pair(int i,int j,int s){
            this.i=i;this.j=j;this.s=s;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        boolean[][] vis=new boolean[m][n];
        int[][] ans=new int[m][n];
        Queue<Pair> q=new LinkedList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=true;
                }
            }
        }
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        while(!q.isEmpty()){
            int i=q.peek().i;
            int j=q.peek().j;
            int s=q.peek().s;
            q.remove();
            ans[i][j]=s;
            
            for(int k=0;k<4;k++){
                int nx=i+dx[k];
                int ny=j+dy[k];

                if(nx>=0 && nx<m && ny>=0 && ny<n && !vis[nx][ny]){
                    vis[nx][ny]=true;
                    q.add(new Pair(nx,ny,s+1));
                }
            }
        }
        return ans;
    }
}