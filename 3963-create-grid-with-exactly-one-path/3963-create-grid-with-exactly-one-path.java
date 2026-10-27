class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans=new String[m];
        
        String s0="";
        for(int i=0;i<n;i++){
            s0+='.';
        }
        ans[0]=s0;
        String s="";
        for(int i=0;i<n;i++){
            if(i==n-1) s+='.';
            else s+='#';
        }
        for(int i=1;i<m;i++){
            ans[i]=s;
        }
        return ans;
    }
}