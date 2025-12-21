class Solution {
    public int minDeletionSize(String[] strs) {
        int n=strs.length;
        int m=strs[0].length();

        int c=0;
        boolean[] fix=new boolean[n-1];

        for(int i=0;i<m;i++){
            boolean need=false;
            for(int j=0;j<n-1;j++){
                if(!fix[j] && strs[j].charAt(i)>strs[j+1].charAt(i)){
                    need=true;
                    break;
                }
            }
            if(need){
                c++;
                continue;
            }
            for(int j=0;j<n-1;j++){
                if(!fix[j] && strs[j].charAt(i)<strs[j+1].charAt(i)){
                    fix[j]=true;
                }
            }

        }
        return c;
    }
}