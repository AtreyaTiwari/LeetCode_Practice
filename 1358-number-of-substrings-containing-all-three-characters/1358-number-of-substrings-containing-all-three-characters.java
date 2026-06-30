class Solution {
    public int numberOfSubstrings(String s) {
        int l=0;
        int n=s.length();
        int[] freq=new int[3];
        int ans=0;
        for(int r=0;r<n;r++){
            freq[s.charAt(r)-'a']++;
            
            while(freq[0]>0 && freq[1]>0 && freq[2]>0){
                ans+=n-r;
                freq[s.charAt(l)-'a']--;
                l++;
            }
        }
        return ans;
    }
    // tle
    // public int numberOfSubstrings(String s) {
    //     int n=s.length();
    //     int count=0;
    //     for(int k= 2;k<n;k++){
    //         int i=0;
    //         int a=0,b=0,c=0;
    //         for(int j=0;j<=k;j++){
    //             if(s.charAt(j)=='a') a++;
    //             else if(s.charAt(j)=='b') b++;
    //             else if(s.charAt(j)=='c') c++;
    //         }
    //         while(i+k<n){
    //             if(a>0 && b>0 && c>0) count++;

    //             int t=i+k;    

    //             if(t<n-1 && s.charAt(t+1)=='a') a++;
    //             else if(t<n-1 && s.charAt(t+1)=='b') b++;
    //             else if(t<n-1 && s.charAt(t+1)=='c') c++;

    //             if(s.charAt(i)=='a') a--;
    //             else if(s.charAt(i)=='b') b--;
    //             else if(s.charAt(i)=='c') c--;
    //             i++;
    //         }
    //     }
    //     return count;
    // }
}