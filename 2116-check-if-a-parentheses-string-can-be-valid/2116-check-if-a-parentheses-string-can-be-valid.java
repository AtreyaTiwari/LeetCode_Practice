class Solution {
    public boolean canBeValid(String s, String locked) {
        int min=0;
        int max=0;
        int n=s.length();
        if(n%2!=0) return false;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            int lock=locked.charAt(i)-'0';

            if(lock==0){
                if(c=='('){
                    max++;
                    min--;
                }else if(c==')'){
                    min--;
                    max++;
                }
            }else{
                if(c=='('){
                    max++;
                    min++;
                }else if(c==')'){
                    min--;
                    max--;
                }
            }
            if(max<0) return false;
            min=Math.max(0,min);
        }
        return min==0;
    }
}