class Solution {
    public int[][] findFarmland(int[][] land) {
        int m=land.length;
        int n=land[0].length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(land[i][j]==1){
                    int x=i,y=j;
                    while(x<m){
                        if(land[x][j]==1){
                            x++;
                        }else{
                            break;
                        }
                    }
                    while(y<n){
                        if(land[i][y]==1){
                            y++;
                        }else{
                            break;
                        }
                    }
                    ArrayList<Integer> temp=new ArrayList<>(Arrays.asList(i,j,x-1,y-1));
                    list.add(temp);
                    for(int r=i;r<x;r++){
                        for(int s=j;s<y;s++){
                            land[r][s]=0;
                        }
                    }
                }
            }
        }
        int rows = list.size();
        int cols = 4;
        int[][] arr = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = list.get(i).get(j);
            }
        }
        return arr;
    }
}