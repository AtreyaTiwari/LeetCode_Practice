class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] pre=new int[n][m];
        
        return build(grid,pre,k);
    }
    private static int  build(int[][] grid,int[][] prev,int k){
        for(int j=0;j<prev[0].length;j++){
            int sum=0;
            for(int i=0;i<prev.length;i++){
                sum+=grid[i][j];
                prev[i][j]=sum;
            }
        }
        // System.out.println(Arrays.deepToString(prev));
        int count=0;
        for(int i=0;i<prev.length;i++){
            int sum=0;
            for(int j=0;j<prev[0].length;j++){
                sum+=prev[i][j];
                if(sum<=k) count++;
                else break;
            }
        }
        return count;
    }
}