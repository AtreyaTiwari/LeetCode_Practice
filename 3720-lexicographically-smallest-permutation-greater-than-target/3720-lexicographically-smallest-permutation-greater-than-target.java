class Solution {
    public String lexGreaterPermutation(String s, String t) {
        StringBuilder sb=new StringBuilder();
        int[] freq=new int[26];
        int n=s.length();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            freq[c-'a']++;
        }
        boolean found=false;
        boolean stuck=false;
        int stInd=-1;
        for(int i=0;i<n;i++){
            char c=t.charAt(i);
            if(freq[c-'a']>0){
                sb.append(c);
                freq[c-'a']--;
            }else if(freq[c-'a']==0){
                for(int j=c-'a'+1;j<26;j++){
                    if(freq[j]>0){
                        found=true;
                        sb.append((char)('a'+j));
                        freq[j]--;
                        break;
                    }
                }
                if(!found){stuck=true;stInd=i;}
                break;
            }
        }
        if(stuck || (sb.length()==n && sb.toString().equals(t))){
            found=false;
            int start=n-1;
            if(stuck) start=stInd-1;
            for(int i=start;i>=0;i--){
                int curr=t.charAt(i)-'a';
                freq[curr]++;
                for(int j=curr+1;j<26;j++){
                    if(freq[j]>0){
                        sb.setLength(i);
                        sb.append((char)('a'+j));
                        freq[j]--;
                        found=true;
                        break;
                    }
                }
                if(found) break;
            }
        }
        if(found){
            for(int i=0;i<26;i++){
                while(freq[i]>0){
                    sb.append((char)('a'+i));
                    freq[i]--;
                }
            }
        }
        // System.out.println(t.equals(sb.toString())+" "+sb.toString());
        return !found?"":sb.toString();
    }
}