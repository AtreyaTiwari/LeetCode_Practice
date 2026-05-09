class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        grid=solve(grid,k);
        return grid;
    }
    private static int[][] solve(int[][] grid,int k){
        int n=grid.length;
        int m=grid[0].length;
        int l=Math.min(n,m)/2;
        for(int i=0;i<l;i++){
            ArrayList<Integer> list=new ArrayList<>();
            //upper row
            for(int c=i;c<m-i;c++){
                list.add(grid[i][c]);
            }
            //right most col
            for(int r=i+1;r<n-i;r++){
                list.add(grid[r][m-i-1]);
            }
            //bottom most row
            for(int c=m-i-1-1;c>=i;c--){
                list.add(grid[n-i-1][c]);
            }
            //left most col
            for(int r=n-i-1-1;r>i;r--){
                list.add(grid[r][i]);
            }
            // System.out.println(list);
            // System.out.println("Atreua");
            list=rotate(list,k);
            int j=0;
            //upper row
            for(int c=i;c<m-i;c++){
                grid[i][c]=list.get(j++);
            }
            //right most col
            for(int r=i+1;r<n-i;r++){
                grid[r][m-i-1]=list.get(j++);
            }
            //bottom most row
            for(int c=m-i-1-1;c>=i;c--){
                grid[n-i-1][c]=list.get(j++);
            }
            //left most col
            for(int r=n-i-1-1;r>i;r--){
                grid[r][i]=list.get(j++);
            }
        }
        return grid;
    }
    private static ArrayList<Integer> rotate(ArrayList<Integer> list,int k){
        int n=list.size();
        k=k%n;
        ArrayList<Integer> rotated=new ArrayList<>();
        for(int i=0;i<n;i++){
            rotated.add(list.get((i+k)%n));
        }
        return rotated;
    }
}