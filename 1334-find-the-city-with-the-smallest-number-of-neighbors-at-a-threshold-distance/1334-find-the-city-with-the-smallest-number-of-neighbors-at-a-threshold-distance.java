class Solution {
    public int findTheCity(int n, int[][] edges, int th) {
        int[][] dis=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) dis[i][j]=0;
                else dis[i][j]=100000009;
            }
        }
        for(int i=0;i<edges.length;i++){
            int x=edges[i][0];
            int y=edges[i][1];
            int w=edges[i][2];

            dis[x][y]=w;dis[y][x]=w;
        }
        for(int k=0;k<n;k++){
           for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    dis[i][j]=Math.min(dis[i][j],dis[i][k]+dis[k][j]);
                }
            } 
        }
        int c=Integer.MAX_VALUE,cMin=-1;
        for(int i=0;i<n;i++){
            int ci=0;
            for(int j=0;j<n;j++){
                if(dis[i][j]<=th) ci++;
            }
            if(c>=ci){
                c=ci;
                cMin=i;
            }
        }
        return cMin;
    }
}