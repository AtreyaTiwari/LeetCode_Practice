class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==0){
            return "";
        }   
        int st=0;
        int end=0;
        for(int i=0;i<s.length();i++){
            int[] odd=expand(s,i,i);
            int[] even=expand(s,i,i+1);

            int[] longer=(odd[1]-odd[0])>(even[1]-even[0])?odd:even;

            if((longer[1]-longer[0])>(end-st)){
                end=longer[1];
                st=longer[0];
            }
        }
        return s.substring(st,end+1);
    }
    private static int[] expand(String s,int l,int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            r++;
            l--;
        }
        return new int[]{l+1,r-1};
    }
}