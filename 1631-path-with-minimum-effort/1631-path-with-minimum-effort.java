class Solution {
    class Pair{
        int c,x,y;
        public Pair(int c,int x,int y){
            this.c=c;this.x=x;this.y=y;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;

        int[][] cost=new int[n][m];
        for(int[] ar:cost) Arrays.fill(ar,100000009);

        PriorityQueue<Pair> pq=new PriorityQueue<>(Comparator.comparing(x->x.c));

        cost[0][0]=0;
        pq.add(new Pair(0,0,0));

        int[] dr={-1,0,+1,0};
        int[] dc={0,+1,0,-1};

        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int c=p.c;
            int x=p.x;
            int y=p.y;

            if(x==n-1 && y==m-1) return c;

            for(int i=0;i<4;i++){
                int nx=x+dr[i];
                int ny=y+dc[i];

                if(nx<n&&nx>=0 && ny<m&&ny>=0){
                    int costOrg=Math.abs(heights[x][y]-heights[nx][ny]);
                    int maxC=Math.max(c,costOrg);
                    if(cost[nx][ny]>maxC){
                        cost[nx][ny]=maxC;
                        pq.add(new Pair(maxC,nx,ny));
                    }
                }
            }
        }
        return -1;
    }
}