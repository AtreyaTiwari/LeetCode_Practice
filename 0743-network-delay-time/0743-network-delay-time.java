class Solution {
    class Pair{
        int nd,t;
        public Pair(int nd,int t){
            this.nd=nd;this.t=t;
        }

    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }
        int[] time=new int[n+1];
        Arrays.fill(time,100000009);
        time[k]=0;

        PriorityQueue<Pair> pq=new PriorityQueue<>(Comparator.comparing(x->x.t));
        pq.add(new Pair(k,0));

        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int node=p.nd;
            int t=p.t;
            if(time[node]<t) continue;

            for(Pair ad:adj.get(node)){
                int adnd=ad.nd;
                int adt=ad.t;
                if(time[adnd]>t+adt){
                    pq.add(new Pair(adnd,t+adt));
                    time[adnd]=t+adt;
                }
            }
        }
        
        int maxT=-100000009;
        for(int i=1;i<time.length;i++){
            maxT=Math.max(maxT,time[i]);
        }
        return maxT==100000009?-1:maxT;
    }
}