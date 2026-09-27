class Solution {
    
    public String reverseParentheses(String s) {
        char[] arr=s.toCharArray();
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            char c=arr[i];
            if(c=='('){
                st.push(i);
            }else if(c==')'){
                rev(arr,st.peek()+1,i-1);
                st.pop();
            }
        }
        StringBuilder sb=new StringBuilder();
        for(char c:arr){
            if(c!='(' && c!=')') sb.append(c);
        }
        return sb.toString();
    }
    private static void rev(char[] arr,int s,int e){
        while(s<=e){
            char temp=arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
            s++;e--;
        }
    }
}