class Solution {
    int[][] dp;
    String s1, s2;

    public int minimumDeleteSum(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        dp = new int[s1.length()][s2.length()];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, 0);
    }

    private int solve(int i, int j) {
        // If s1 finished → delete rest of s2
        if (i == s1.length()) {
            int sum = 0;
            for (int k = j; k < s2.length(); k++)
                sum += s2.charAt(k);
            return sum;
        }

        // If s2 finished → delete rest of s1
        if (j == s2.length()) {
            int sum = 0;
            for (int k = i; k < s1.length(); k++)
                sum += s1.charAt(k);
            return sum;
        }

        // Memoized result
        if (dp[i][j] != -1)
            return dp[i][j];

        // If characters match
        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = solve(i + 1, j + 1);
        } else {
            int deleteS1 = s1.charAt(i) + solve(i + 1, j);
            int deleteS2 = s2.charAt(j) + solve(i, j + 1);
            dp[i][j] = Math.min(deleteS1, deleteS2);
        }

        return dp[i][j];
    }
}
