class Solution {
    static class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return;
            if (rank[pa] < rank[pb]) parent[pa] = pb;
            else if (rank[pa] > rank[pb]) parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
        }

        void reset(int x) {
            parent[x] = x;
            rank[x] = 0;
        }
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

        DSU dsu = new DSU(n);
        dsu.union(0, firstPerson);

        int i = 0;
        while (i < meetings.length) {
            int time = meetings[i][2];
            List<Integer> people = new ArrayList<>();

            // process all meetings at same time
            while (i < meetings.length && meetings[i][2] == time) {
                int u = meetings[i][0];
                int v = meetings[i][1];
                dsu.union(u, v);
                people.add(u);
                people.add(v);
                i++;
            }

            // rollback connections if secret not present
            for (int p : people) {
                if (dsu.find(p) != dsu.find(0)) {
                    dsu.reset(p);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (dsu.find(j) == dsu.find(0)) {
                res.add(j);
            }
        }
        return res;
    }
}
