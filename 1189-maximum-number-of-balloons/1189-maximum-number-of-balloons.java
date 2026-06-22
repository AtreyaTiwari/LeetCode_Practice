class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq=new int[26];
        int n=text.length();
        for(int i=0;i<n;i++){
            char c=text.charAt(i);
            freq[c-'a']++;
        }
        int count=0;
        while(true){
            if(freq['b'-'a']<=0 || freq['a'-'a']<=0 || freq['l'-'a']<=1 || freq['o'-'a']<=1 || freq['n'-'a']<=0){
                break;
            }
            count++;
            freq['b'-'a']--;
            freq['a'-'a']--;
            freq['l'-'a']-=2;
            freq['o'-'a']-=2;
            freq['n'-'a']--;
        }
        return count;
    }
}