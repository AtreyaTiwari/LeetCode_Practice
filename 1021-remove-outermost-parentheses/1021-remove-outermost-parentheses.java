class Solution {
    public String removeOuterParentheses(String str) {
        char[] arr = str.toCharArray();
        StringBuilder newString = new StringBuilder();
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]=='('){
                sum++;
                if(sum>1){
                    newString.append('(');
                }
            }
            else{
                if(sum>1){
                    newString.append(')');
                }
                sum--;
            }
        }
        return newString.toString();
    }
}