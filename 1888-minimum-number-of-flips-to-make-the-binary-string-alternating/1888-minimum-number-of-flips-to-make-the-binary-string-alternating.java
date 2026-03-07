class Solution {
    public int minFlips(String s) {
        int n=s.length();
        String ss=s+s;
        int ans=Integer.MAX_VALUE;
        int alt1=0,alt2=0;
        for(int i=0;i<ss.length();i++){
            char c=ss.charAt(i);

            if(c!= (i%2==0?'0':'1')) alt1++;
            if(c!= (i%2==0?'1':'0')) alt2++;

            if(i>=n){
                char prev=s.charAt(i-n);

                if(prev != ((i-n)%2==0?'0':'1')) alt1--;
                if(prev != ((i-n)%2==0?'1':'0')) alt2--;
            }

            if(i>=n-1) ans=Math.min(ans,Math.min(alt1,alt2));
        }
        return ans;
    }
}