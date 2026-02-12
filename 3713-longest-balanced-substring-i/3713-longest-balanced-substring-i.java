class Solution {
    public int longestBalanced(String s) {
        int n=s.length();
        int res=0;

        for(int i=0;i<n;i++){
            int[] freq=new int[26];
            for(int k=i;k<n;k++){
                freq[s.charAt(k)-'a']++;
                if(isBal(freq)){
                    res=Math.max(res,k-i+1);
                }
            }
        }
        return res;
    }
    private boolean isBal(int[] freq){
        int c=0;
        for(int num:freq){
            if(num>0){
                if(c==0){
                    c=num;
                }
                else if(num!=c) return false;
            }
            
        }
        return true;
    }
}