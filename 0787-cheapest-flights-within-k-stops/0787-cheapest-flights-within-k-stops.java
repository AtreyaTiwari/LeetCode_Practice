class Solution {
    class Plane{
        int st,nd,cost;
        public Plane(int st,int nd,int cost){
            this.st=st;this.nd=nd;this.cost=cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Plane>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Plane(0,flights[i][1],flights[i][2]));
        }
        int[] costs=new int[n];
        Arrays.fill(costs,100000009);
        costs[src]=0;

        Queue<Plane> q=new LinkedList<>();
        q.add(new Plane(0,src,0));

        while(!q.isEmpty()){
            Plane p=q.poll();
            int stop=p.st;
            int node=p.nd;
            int cost=p.cost;

            if(stop>k) continue;
            if(node==dst) continue;

            for(Plane ad:adj.get(node)){
                int adnd=ad.nd;
                int adcs=ad.cost;

                if(costs[adnd]>(cost+adcs)){
                    costs[adnd]=cost+adcs;
                    q.add(new Plane(stop+1,adnd,cost+adcs));
                }
            }
        }
        return costs[dst]==100000009?-1:costs[dst];
    }
}