class Solution {
    public String longestPrefix(String s) {
       
        return kmpLpsTableSolving(s);
    }
    private static String kmpLpsTableSolving(String s){
        int n=s.length();
        int i=1;
        int len=0;
        int[] lps=new int[n];
        while(i<n){
            if(s.charAt(len)==s.charAt(i)){
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len!=0){
                    len=lps[len-1];
                }else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        int max=lps[n-1];
        return s.substring(0,max);
    } 
}