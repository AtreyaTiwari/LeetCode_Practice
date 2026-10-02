class Solution {
    public int maxPalindromes(String s, int k) {
        int n=s.length();
        int count=0;
        for(int i=0;i<=n-k;i++){
            if(check(s.substring(i,i+k))){
                count++;
                i=i+k-1;
            }else if(i+k<n && check(s.substring(i,i+k+1))){
                i=i+k;
                count++;
            }
        }
        return count;
    } 
    private static boolean check(String str){
        int st=0;
        int end=str.length()-1;
        while(st<=end){
            if(str.charAt(st)!=str.charAt(end)){
                return false;
            }
            st++;
            end--;
        }
        return true;
    }
}