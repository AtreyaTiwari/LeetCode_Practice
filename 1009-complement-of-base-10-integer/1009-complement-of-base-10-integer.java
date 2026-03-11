class Solution {
    public int bitwiseComplement(int n) {
        String st=Integer.toBinaryString(n);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<st.length();i++){
            sb.append('1'-st.charAt(i));
        }
        return Integer.parseInt(sb.toString(),2);
    }
}