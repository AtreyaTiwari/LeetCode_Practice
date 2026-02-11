class Solution {
    public boolean isAlienSorted(String[] words, String order) {
    
        int[] freq=new int[26];
        for(int i=0;i<order.length();i++){
            freq[order.charAt(i)-'a']=i;
        }
        for(int i=0;i<words.length-1;i++){
            if(check(words[i],words[i+1],freq)==false){
                return false;
            }
        }
        return true;
    }
    private static boolean check(String s1,String s2,int[] freq){
        if(s1.equals(s2)) return true;
        int min=Math.min(s1.length(),s2.length());
        for(int i=0;i<min;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                int pos1=freq[s1.charAt(i)-'a'];
                int pos2=freq[s2.charAt(i)-'a'];
                if(pos1<pos2) return true;
                else return false;
            }
        }
        return s1.length()==min;
    }
}