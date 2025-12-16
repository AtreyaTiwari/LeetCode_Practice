class Solution {

    private void dfs(int u, int[] present, int[] future, Map<Integer, List<Integer>> adj, int[][][] statesProfit, int budget) {

        List<int[][]> childrenStates = new ArrayList<>();

        if (adj.containsKey(u)) {
            List<Integer> children = adj.get(u);
            for (int i = 0; i < children.size(); i++) {
                int v = children.get(i);
                dfs(v, present, future, adj, statesProfit, budget);
                childrenStates.add(statesProfit[v]);
            }
        }

        for (int parentBought = 0; parentBought <= 1; parentBought++) {

            int price = (parentBought == 1) ? present[u] / 2 : present[u];
            int profit = future[u] - price;

            int[] bestProfitAtU = new int[budget + 1];
            int[] childrenProfitIfUNotBought = new int[budget + 1];

            for (int c = 0; c < childrenStates.size(); c++) {
                int[] childDP = childrenStates.get(c)[0];
                int[] temp = new int[budget + 1];

                for (int used = 0; used <= budget; used++) {
                    if (childrenProfitIfUNotBought[used] < 0) continue;

                    for (int take = 0; used+take <= budget; take++) {
                        temp[used+take] = Math.max(temp[used+take],childrenProfitIfUNotBought[used] + childDP[take]);
                    }
                }
                childrenProfitIfUNotBought = temp;
            }

            for (int b=0; b<=budget; b++) {
                bestProfitAtU[b] = childrenProfitIfUNotBought[b];
            }

            if (price <= budget) {

                int[] childrenProfitIfUBought = new int[budget + 1];

                for (int c=0; c<childrenStates.size(); c++) {
                    int[] childDP = childrenStates.get(c)[1];
                    int[] temp = new int[budget + 1];

                    for (int used=0; used<=budget; used++) {
                        if (childrenProfitIfUBought[used] < 0) continue;

                        for (int take=0; used+take <= budget; take++) {
                            temp[used+take] = Math.max(temp[used+take],childrenProfitIfUBought[used] + childDP[take]);
                        }
                    }
                    childrenProfitIfUBought = temp;
                }

                for (int b = price; b <= budget; b++) {
                    bestProfitAtU[b] = Math.max(bestProfitAtU[b],childrenProfitIfUBought[b - price] + profit);
                }
            }

            statesProfit[u][parentBought] = bestProfitAtU;
        }
    }

    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {

        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < hierarchy.length; i++) {
            int u = hierarchy[i][0] - 1;
            int v = hierarchy[i][1] - 1;

            if (!adj.containsKey(u)) {
                adj.put(u, new ArrayList<>());
            }
            adj.get(u).add(v);
        }

        int[][][] statesProfit = new int[n][2][budget + 1];

        dfs(0, present, future, adj, statesProfit, budget);

        int ans = 0;
        for (int b = 0; b <= budget; b++) {
            ans = Math.max(ans, statesProfit[0][0][b]);
        }

        return ans;
    }
}