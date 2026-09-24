class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";

        int st=0,l=0,minLen=Integer.MAX_VALUE;
        int count=t.length();
        int[] freq=new int[128];
        for(char c:t.toCharArray()) freq[c]++;

        for(int r=0;r<s.length();r++){
            char c=s.charAt(r);
            if(freq[c]>0) count--;

            freq[c]--;
            
            while(count==0){
                if(r-l+1<minLen){
                    minLen=r-l+1;
                    st=l;
                }
                freq[s.charAt(l)]++;
                if(freq[s.charAt(l)]>0) count++;
                l++;
            }
            
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(st,st+minLen);
    }
}
