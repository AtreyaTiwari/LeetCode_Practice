class Solution {
    public int maxDepth(String s) {
       if (!s.contains("(") || !s.contains(")")) {
            return 0;
        }
       char[] arr=s.toCharArray();
        int count=0;
        int maxCount=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]=='('){
                count++;
            }
            if(arr[i]==')'){
                if(maxCount<count){
                    maxCount=count;
                }
                count--;
            }
        }
        return maxCount; 
    }
}