class Solution {
    class Pair{
        int i,j,s;
        public Pair(int i,int j,int s){
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
                    vis[i][j]=true;
                    q.add(new Pair(i,j,0));
                }
            }
        }
        int[] delR={-1,0,1,0};
        int[] delC={0,1,0,-1};
        while(!q.isEmpty()){
            Pair p=q.poll();
            int i=p.i,j=p.j,s=p.s;
            ans[i][j]=s;

            for(int k=0;k<4;k++){
                int nR=i+delR[k];
                int nC=j+delC[k];

                if(nR<m&&nR>=0 && nC<n&&nC>=0 && !vis[nR][nC]){
                    vis[nR][nC]=true;
                    q.add(new Pair(nR,nC,s+1));
                }
            }
        }
        return ans;
    }
}