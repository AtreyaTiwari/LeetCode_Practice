class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans=new String[m];
        String s0=".".repeat(n);
        ans[0]=s0;
        String s="#".repeat(n-1);
        s+=".";
        for(int i=1;i<m;i++){
            ans[i]=s;
        }
        return ans;
    }
}