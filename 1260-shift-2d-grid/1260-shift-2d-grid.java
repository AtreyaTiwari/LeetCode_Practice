class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int g=0;
        int[] arr=new int[m*n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[g++]=grid[i][j];
            }
        }
        rotate(arr,k);
        g=0;
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<m;i++){
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<n;j++){
                list.add(arr[g++]);
            }
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
    private static void rotate(int[] arr,int k){
        k=k%arr.length;
        int n=arr.length;
        rev(arr,0,n-1);
        rev(arr,0,k-1);
        rev(arr,k,n-1);
    }
    private static void rev(int[] arr,int l,int r){
        while(l<r){
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            r--;l++;
        }
    }
}