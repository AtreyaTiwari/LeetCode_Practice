class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        long prod=1;
        int n=grid.length;
        int m=grid[0].length;

        int[] arr=new int[n*m];
        long[] pref=new long[n*m];
        long[] suff=new long[n*m];
        pref[0]=1;suff[n*m -1]=1;

        int p=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[p++]=grid[i][j];
            }
        }

        for(int i=1;i<n*m;i++){      
            pref[i]=(pref[i-1]*arr[i-1])%12345;
        }
        for(int i=n*m -2;i>=0;i--){      
            suff[i]=(suff[i+1]*arr[i+1])%12345;
        }
        
        for(int i=0;i<n*m;i++){
            int r=i/m;int c=i%m;
            grid[r][c]=(int)(pref[i]*suff[i])%12345;
        }
        return grid;
    }
}