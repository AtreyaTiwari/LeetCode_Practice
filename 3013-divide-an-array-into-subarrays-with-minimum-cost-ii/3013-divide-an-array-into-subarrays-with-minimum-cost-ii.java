import java.util.*;

class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        k--;

        PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> large = new PriorityQueue<>();
        HashMap<Integer,Integer> del = new HashMap<>();

        int l = 1;
        long sumSmall = 0, ans = Long.MAX_VALUE;
        int smallSize = 0;

        for(int r = 1; r < n; r++){

            // ADD
            if(smallSize < k){
                small.add(nums[r]);
                sumSmall += nums[r];
                smallSize++;
            } else if(!small.isEmpty() && nums[r] < small.peek()){
                int moved = small.poll();
                sumSmall -= moved;
                large.add(moved);

                small.add(nums[r]);
                sumSmall += nums[r];
            } else {
                large.add(nums[r]);
            }

            // WINDOW TOO BIG
            if (r - l + 1 > dist + 1) {
                int out = nums[l++];
                del.put(out, del.getOrDefault(out, 0) + 1);

                if (!small.isEmpty() && out <= small.peek()) {
                    sumSmall -= out;
                    smallSize--;
                }

                clean(small, del);
                clean(large, del);

                // REBALANCE BASED ON VALID SIZE
                while (smallSize < k && !large.isEmpty()) {
                    int x = large.poll();
                    clean(large, del);
                    small.add(x);
                    sumSmall += x;
                    smallSize++;
                }
                while (smallSize > k) {
                    int x = small.poll();
                    sumSmall -= x;
                    large.add(x);
                    smallSize--;
                }
            }

            if (r - l + 1 >= k) {
                ans = Math.min(ans, sumSmall);
            }
        }

        return ans + nums[0];
    }

    void clean(PriorityQueue<Integer> pq, HashMap<Integer, Integer> del) {
        while (!pq.isEmpty() && del.getOrDefault(pq.peek(), 0) > 0) {
            int x = pq.poll();
            del.put(x, del.get(x) - 1);
        }
    }
}
