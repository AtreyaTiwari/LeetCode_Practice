class Solution {
    public int countBinarySubstrings(String s) {
        char[] str=s.toCharArray();
        int ans=0;
        int i=0,n=str.length;
        while(i<n){
            int c0=0,c1=0;
            while(i<n && str[i]=='0'){
                c0++;i++;
            }
            while(i<n && str[i]=='1'){
                c1++;i++;
            }
            ans+=Math.min(c0,c1);
        }
        i=0;
        while(i<n){
            int c0=0,c1=0;
            while(i<n && str[i]=='1'){
                c1++;i++;
            }
            while(i<n && str[i]=='0'){
                c0++;i++;
            }
            ans+=Math.min(c0,c1);
        }
        return ans;
    }
}