class Solution {
    public char findKthBit(int n, int k) {
        String s=generate("0",n-1);
        return s.charAt(k-1);
    }
    private static String generate(String s,int n){
        if(n==0) return s;
        StringBuilder st=new StringBuilder(s);
        st.append('1');
        StringBuilder temp=new StringBuilder();
        for(char c:s.toCharArray()){
            if(c=='1') temp.append('0');
            else temp.append('1');
        }
        st.append(temp.reverse());
        return generate(st.toString(),n-1);
    }
}