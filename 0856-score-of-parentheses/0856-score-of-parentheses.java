class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st=new Stack<>();
        st.push(0);
        
        for(char c:s.toCharArray()){
            if(c=='('){
                st.push(0);
            }else if(c==')'){
                int ins=st.pop();

                if(ins==0){
                    ins=1;
                }else{
                    ins*=2;
                }
                st.push(st.pop()+ins);
            }
        }
        return st.pop();
    }
}