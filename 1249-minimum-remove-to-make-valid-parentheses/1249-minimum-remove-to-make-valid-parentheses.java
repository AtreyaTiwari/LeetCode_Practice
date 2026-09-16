class Solution {
    static class Pair{
        char ch;int ind;
        public Pair(char ch,int ind){
            this.ch=ch;
            this.ind=ind;
        }
    }
    public String minRemoveToMakeValid(String s) {
        int n=s.length();
        char[] arr=s.toCharArray();
        Stack<Pair> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
                char c=s.charAt(i);
                if(c=='('){
                    st.add(new Pair('(',i));
                }else if( c==')' && !st.isEmpty() && st.peek().ch=='('){
                    st.pop();
                }else if(c==')'){
                    st.add(new Pair(')',i));
                }
        }
        for(Pair p:st){
            arr[p.ind]='*';
        }
        for(char c:arr){
            if(c!='*') sb.append(c);
        }
        return sb.toString();
    }
}