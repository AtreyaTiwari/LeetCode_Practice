
class Solution {
    int ans = Integer.MAX_VALUE;
    class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    public int minScore(int n, int[][] roads) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
        boolean[] vis = new boolean[n + 1];
        dfs(1, adj, vis);

        return ans;
    }
    private void dfs(int node, List<List<Pair>> adj, boolean[] vis) {
        vis[node] = true;

        for (Pair p : adj.get(node)) {
            ans = Math.min(ans, p.weight);

            if (!vis[p.node]) {
                dfs(p.node, adj, vis);
            }
        }
    }
}