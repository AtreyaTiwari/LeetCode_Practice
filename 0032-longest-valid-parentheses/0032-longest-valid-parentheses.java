class Solution {
    public int longestValidParentheses(String s) {
        int n=s.length();
        if(n==0) return 0;
        int[] dp=new int[n];
        int count=0;
        
        for(int i=1;i<n;i++){
            char c=s.charAt(i);
            if(c==')'){
                // "...()"
                if(s.charAt(i-1)=='('){
                    dp[i]=2;
                    if(i>=2){
                        dp[i]+=dp[i-2];
                    }
                }else{
                    // "...))"
                    int openInd=i-dp[i-1]-1;
                    if(openInd>=0 && s.charAt(openInd)=='('){
                        dp[i]=dp[i-1]+2;
                        if(openInd>=1){
                            dp[i]+=dp[openInd-1];
                        }
                    }
                }
            }
            count=Math.max(count,dp[i]);
        }    
        return count;
    }
    
}