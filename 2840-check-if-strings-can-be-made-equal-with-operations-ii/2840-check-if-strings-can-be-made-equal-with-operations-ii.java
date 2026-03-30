class Solution {
    public boolean checkStrings(String s1, String s2) {
        int[] evenFreq= new int[26];
        int[] oddFreq= new int[26];

        for(int i=0;i<s1.length();i++){
            char c=s1.charAt(i);
            if(i%2==0){
                evenFreq[c-'a']++;
            }else{
                oddFreq[c-'a']++;
            }
        }
        for(int i=0;i<s2.length();i++){
            char c=s2.charAt(i);
            if(i%2==0){
                if(evenFreq[c-'a']<=0) return false;
                evenFreq[c-'a']--;
            }else{
                if(oddFreq[c-'a']<=0) return false;
                oddFreq[c-'a']--;
            }
        }
        return true;
    }
}