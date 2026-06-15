class Solution {
    public boolean isAnagram(String s, String t) {
        // char[] sChar=s.toCharArray();
        // char[] tChar=t.toCharArray();

        // Arrays.sort(sChar);
        // Arrays.sort(tChar);
        // return Arrays.equals(sChar, tChar);
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            freq[c-'a']++;
        }
        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            freq[c-'a']--;
        }
        for(int i=0;i<26;i++){
            if(freq[i]!=0) return false;
        }
        return true;
    }
}