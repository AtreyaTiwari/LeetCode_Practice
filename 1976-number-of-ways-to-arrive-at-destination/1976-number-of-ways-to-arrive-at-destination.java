class Solution {
    class AdPair{
        int nd;long t;
        public AdPair(int nd,long t){
            this.nd=nd;this.t=t;
        }
    }
    class Tpair{
        long t;int c;
        public Tpair(long t,int c){
            this.t=t;
            this.c=c;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<AdPair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new AdPair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new AdPair(roads[i][0],roads[i][2]));
        }

        PriorityQueue<AdPair> pq=new PriorityQueue<>(Comparator.comparingLong(x->x.t));
        pq.add(new AdPair(0,0));

        Tpair[] times = new Tpair[n];
        for(int i = 0; i < n; i++){
            times[i] = new Tpair(Long.MAX_VALUE, 0);
        }
        times[0]=new Tpair(0,1);


        while(!pq.isEmpty()){
            AdPair p=pq.poll();
            int node=p.nd;
            long time=p.t;

            if(time>times[node].t) continue;

            for(AdPair ad:adj.get(node)){
                int adnd=ad.nd;
                long adt=ad.t;

                if(times[adnd].t > adt+time){
                    times[adnd].t=adt+time;
                    times[adnd].c=times[node].c;
                    pq.add(new AdPair(adnd, adt + time));
                }else if(times[adnd].t == adt+time){
                    times[adnd].c=(times[adnd].c+times[node].c)%1000000007;
                }
            }
        }
        return times[n-1].c%1000000007;
    }
}