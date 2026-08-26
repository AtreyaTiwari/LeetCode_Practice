class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int len=10000;
        int l=0;
        int ones=0;
        int st=-1,end=-1;
        int n=s.length();
        for(int r=0;r<n;r++){
            if(s.charAt(r)=='1') ones++;

            while(ones>k){
                if(s.charAt(l)=='1'){
                    ones--;
                }
                l++;
            }
            while(ones==k && s.charAt(l)=='0'){
               l++;
            }
            if(ones == k) {
                int curr = r - l + 1;
                if(curr < len || (curr == len && s.substring(l, r + 1).compareTo(s.substring(st, end + 1)) < 0)){
                    
                    st = l;
                    end = r;
                    len = curr;
                }  
            }
        }
        return (st!=-1 && end!=-1)?s.substring(st,end+1):"";
    }
}