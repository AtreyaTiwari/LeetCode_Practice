class Solution {
    class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa != pb) {
                parent[pb] = pa;
            }
        }
    }

    public String findTheString(int[][] lcp) {
        int n = lcp.length;

        // Step 1: Diagonal validation
        for (int i = 0; i < n; i++) {
            if (lcp[i][i] != n - i) return "";
        }

        DSU dsu = new DSU(n);

        // Step 2: Union for lcp > 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = lcp[i][j];
                for (int x = 0; x < k; x++) {
                    if (i + x < n && j + x < n) {
                        dsu.union(i + x, j + x);
                    }
                }
            }
        }

        // Step 3: Assign characters
        char[] res = new char[n];
        int[] groupChar = new int[n]; // root → char index
        Arrays.fill(groupChar, -1);

        int nextChar = 0;

        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            if (groupChar[root] == -1) {
                if (nextChar >= 26) return ""; // only lowercase letters allowed
                groupChar[root] = nextChar++;
            }
            res[i] = (char) ('a' + groupChar[root]);
        }

        // Step 4: Validate LCP
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (res[i] == res[j]) {
                    if (i + 1 < n && j + 1 < n)
                        dp[i][j] = 1 + dp[i + 1][j + 1];
                    else
                        dp[i][j] = 1;
                } else {
                    dp[i][j] = 0;
                }

                if (dp[i][j] != lcp[i][j]) {
                    return "";
                }
            }
        }

        return new String(res);
    }
}