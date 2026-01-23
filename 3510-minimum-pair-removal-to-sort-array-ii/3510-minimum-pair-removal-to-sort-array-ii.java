class Solution {
    static class Pair {
        long sum;
        int idx;
        Pair(long s, int i) {
            sum = s;
            idx = i;
        }
    }

    int n;
    boolean[] alive;
    int[] left, right;
    long[] val;
    int inversions;

    PriorityQueue<Pair> pq;

    void init(int[] nums) {

        n = nums.length;
        alive = new boolean[n];
        left = new int[n];
        right = new int[n];
        val = new long[n];
        inversions = 0;

        Arrays.fill(alive, true);

        pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.sum != b.sum) return Long.compare(a.sum, b.sum);
                return a.idx - b.idx;
            }
        );

        for (int i = 0; i < n; i++) {
            left[i] = i - 1;
            right[i] = i + 1;
            val[i] = nums[i];
        }
        right[n - 1] = n;

        for (int i = 0; i < n - 1; i++) {
            if (val[i] > val[i + 1]) inversions++;
            pq.add(new Pair(val[i] + val[i + 1], i));
        }
    }

    boolean isSorted() {
        return inversions == 0;
    }

    int topElement() {
        while (!pq.isEmpty()) {
            Pair p = pq.peek();
            int i = p.idx;

            if (!alive[i] || right[i] == n ||
                val[i] + val[right[i]] != p.sum) {
                pq.poll();
            } else {
                break;
            }
        }
        if (pq.isEmpty()) return -1;
        return pq.peek().idx;
    }

    void merge(int i) {
        int j = right[i];
        if (j == n) return;

        int x = left[i];
        int y = right[j];

        // remove old inversions
        if (val[i] > val[j]) inversions--;
        if (x != -1 && val[x] > val[i]) inversions--;
        if (y != n && val[j] > val[y]) inversions--;

        long merged = val[i] + val[j];

        // add new inversions
        if (x != -1 && val[x] > merged) inversions++;
        if (y != n && merged > val[y]) inversions++;

        // merge
        val[i] = merged;
        alive[j] = false;

        right[i] = y;
        if (y != n) {
            left[y] = i;
            pq.add(new Pair(val[i] + val[y], i));
        }
        if (x != -1) {
            pq.add(new Pair(val[x] + val[i], x));
        }
    }

    public int minimumPairRemoval(int[] nums) {

        init(nums);
        int ans = 0;

        while (!isSorted()) {
            int pos = topElement();
            merge(pos);
            ans++;
        }
        return ans;
    }
}