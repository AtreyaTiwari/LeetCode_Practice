class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        return solve(grid,n,m);
    }
    private static int[] solve(int[][] grid,int n,int m){
        int maxSize=Math.min(n,m);
        if(maxSize%2==0) maxSize-=1;
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Comparator.reverseOrder());
        build(grid,n,m,maxSize,pq);
        int size = Math.min(3, pq.size());
        int[] ans = new int[size];

        for(int i = 0; i < size; i++){
            ans[i] = pq.poll();
        }
        return ans;
    }
    private static void build(int[][] grid,int n,int m,int maxSize,PriorityQueue<Integer> pq){
        HashSet<Integer> set=new HashSet<>();
        
        for(int size=maxSize;size>=1;size-=2){
            for(int i=0;i<n;i++){
                int endR=i+size-1;
                if(endR>=n) break;
                for(int j=0;j<m;j++){
                    if(size == 1){
                    int sum = grid[i][j];
                    if(set.add(sum)) pq.add(sum);
                    continue;
                }
                    int endC=j+size-1;
                    if(endC>=m) break;
                
                    int midRow = (i + endR) / 2;
                    int midCol = (j + endC) / 2; 
                    int k = (size - 1) / 2;
                    int sum = 0;

                    // top → right
                    for (int t = 0; t < k; t++)
                        sum += grid[midRow - k + t][midCol + t];

                    // right → bottom
                    for (int t = 0; t < k; t++)
                        sum += grid[midRow + t][midCol + k - t];

                    // bottom → left
                    for (int t = 0; t < k; t++)
                        sum += grid[midRow + k - t][midCol - t];

                    // left → top
                    for (int t = 0; t < k; t++)
                        sum += grid[midRow - t][midCol - k + t];

                    if(set.add(sum)){
                        pq.add(sum);
                    }
                }
            }
        }
        
    } 
}