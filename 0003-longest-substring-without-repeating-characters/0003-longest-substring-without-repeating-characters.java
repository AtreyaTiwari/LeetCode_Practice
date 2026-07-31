class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()<=0){
            return 0;
        }

        int maxLen=-1;
        int left=0,right=0;
        int[] arr=new int[256];
        Arrays.fill(arr,-1);
        
        while(right<s.length()){
            char c=s.charAt(right);

            if(arr[(int)c]!=-1){
                if(left<=arr[(int)c]){
                    left=arr[(int)c]+1;
                }
            }
            int len=right-left+1;
            maxLen=Math.max(maxLen,len);
            arr[(int)c]=right;
            right++;
        }
        return maxLen;
    }
}