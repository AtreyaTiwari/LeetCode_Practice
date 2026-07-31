class Solution {
    
    public int minimumPushes(String word) {
        int[] freq=new int[26];
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            freq[c-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        Integer[] idx=new Integer[26];
        for(int i=0;i<26;i++){
            idx[i]=i;
        }
        Arrays.sort(idx,(a, b) -> Integer.compare(freq[b], freq[a]));
        for(int i=0;i<26;i++){
            int fr=freq[idx[i]];
            for(int j=0;j<fr;j++){
                sb.append((char)('a'+idx[i]));
            }
        }
        System.out.println(sb);
        word=sb.toString();
        int[] uniq=new int[26];
        int count=1;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(uniq[c-'a']==0){
                uniq[c-'a']=count;
                count++;
            }
        }
        int ans=0;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);

            if(uniq[c-'a']<=8){
                ans+=1;
            }else if(uniq[c-'a']<=16){
                ans+=2;
            }else if(uniq[c-'a']<=24){
                ans+=3;
            }else{
                ans+=4;
            }
        }
        return ans;
    }
}