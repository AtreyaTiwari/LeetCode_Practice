class Solution {
    public int minInsertions(String s) {
        int ans=0;
        Stack<Character> st=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='('){
                st.push('(');
            }else if(!st.isEmpty() && c==')'){
                char aage='@';
                if(i<n-1) aage=s.charAt(i+1);
                if(aage==')'){
                    st.pop();
                    i++;
                }
                else{
                    ans+=1;
                    st.pop();
                }
            }else if(st.isEmpty() && c==')'){
                char aage='@';
                if(i<n-1) aage=s.charAt(i+1);
                if(aage==')'){
                    ans+=1;
                    i++;
                }
                else ans+=2;
            }
        }
        return ans+(st.size()*2);
    }
}