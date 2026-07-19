class Solution {
    public String smallestSubsequence(String s) {
        Stack<Character> st=new Stack<>();
        int[] last=new int[26];
        int n=s.length();
        boolean[] vis=new boolean[26];
        for(int i=0;i<n;i++){
            last[s.charAt(i)-'a']=i;
        }
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);

            if(vis[ch-'a']) continue;
            while(!st.isEmpty() && st.peek()>ch && last[st.peek()-'a']>i){
                vis[st.pop()-'a']=false;
            }
            st.push(ch);
            vis[ch-'a']=true;
        }
        StringBuilder sb=new StringBuilder();
        for(char c:st){
            sb.append(c);
        }
        return sb.toString();
    }
}