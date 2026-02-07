class Solution {
    public int minimumDeletions(String s) {
        int b=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='b') b++;
            else ans=Math.min(ans+1,b);
        }
        return ans;
    }
}