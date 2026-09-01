import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {

        int n = classroom.length;
        int m = classroom[0].length();

        int sr = 0, sc = 0;
        int litterCount = 0;

        // Give every litter cell an index
        int[][] litterId = new int[n][m];
        for (int[] row : litterId)
            Arrays.fill(row, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                }

                if (ch == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        int allCollected = (1 << litterCount) - 1;

        /*
            State:
            row, col, currentEnergy, mask, moves
        */
        Queue<int[]> q = new LinkedList<>();

        // visited[row][col][energy][mask]
        boolean[][][][] visited =
            new boolean[n][m][energy + 1][1 << litterCount];

        q.offer(new int[]{sr, sc, energy, 0, 0});
        visited[sr][sc][energy][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];
            int e = curr[2];
            int mask = curr[3];
            int moves = curr[4];

            // All litter collected
            if (mask == allCollected) {
                return moves;
            }

            // No energy
            if (e == 0)
                continue;

            for (int k = 0; k < 4; k++) {

                int nr = r + dr[k];
                int nc = c + dc[k];

                // Outside grid
                if (nr < 0 || nr >= n ||
                    nc < 0 || nc >= m)
                    continue;

                char cell = classroom[nr].charAt(nc);

                // Wall
                if (cell == 'X')
                    continue;

                int newEnergy = e - 1;
                int newMask = mask;

                // Litter
                if (cell == 'L') {
                    int id = litterId[nr][nc];
                    newMask |= (1 << id);
                }

                // Recharge
                if (cell == 'R') {
                    newEnergy = energy;
                }

                if (!visited[nr][nc][newEnergy][newMask]) {

                    visited[nr][nc][newEnergy][newMask] = true;

                    q.offer(new int[]{
                        nr,
                        nc,
                        newEnergy,
                        newMask,
                        moves + 1
                    });
                }
            }
        }

        return -1;
    }
}