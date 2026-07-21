class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int count1=0;
        int block1=0,block2=0;
        int max=0;
        int n=s.length();

        int i=0;
        while(i<n){
            if(s.charAt(i)=='0'){
                block1++;
                i++;
            }else{
                while(i<n && s.charAt(i)=='1'){
                    count1++;
                    i++;
                }
                while(i<n && s.charAt(i)=='0'){
                    block2++;
                    i++;
                }

                if(block1!=0 && block2!=0) max=Math.max(max,block1+block2);
                block1=block2;
                block2=0;
            }
        }
        return count1+max;

        //wrong approach
        
        // int n=s.length();
        // int fZl=-1,fZr=-1;
        // for(int i=0;i<n;i++){
        //     if(s.charAt(i)=='0'){
        //         fZl=i;
        //         break;
        //     }
        // }
        // for(int i=n-1;i>=0;i--){
        //     if(s.charAt(i)=='0'){
        //         fZr=i;
        //         break;
        //     }
        // }
        // char[] str=s.toCharArray();
        // if(fZl!=fZr && fZl!=-1 && fZr!=-1){
        //     for(int i=fZl;i<=fZr;i++){
        //         str[i]='1';
        //     }
        // }
        // int count=0;
        // for(int i=0;i<n;i++){
        //     if(str[i]=='1') count++;
        // }
        // return count;


        // wrong approach 

        // int n=s.length();
        // int max=0;
        // int maxi=-1;
        // int maxL=-1,maxR=-1;
        // for(int i=0;i<n;i++){
        //     char c=s.charAt(i);

        //     if(c=='1'){
        //         int left=i-1,right=i+1;
        //         int cLeft=0,cRight=0;
        //         boolean fZl=false;
        //         boolean fZr=false;
        //         while(left>=0){
        //             if(s.charAt(left)=='0'){
        //                 left--;
        //                 cLeft++;
        //                 fZl=true;
        //             }else if(fZl){
        //                 break;
        //             }else{
        //                 left--;
        //                 cLeft++;
        //             }
        //         }
        //         while(right<n){
        //             if(s.charAt(right)=='0'){
        //                 right++;
        //                 cRight++;
        //                 fZr=true;
        //             }else if(fZr){
        //                 break;
        //             }else{
        //                 right++;
        //                 cRight++;
        //             }
        //         }
        //         if(left==-1) left+=1;
        //         if(right==n) right-=1;
        //         if(fZl && fZr){
        //             if(cLeft>0 && cRight>0){
        //                 int len=right-left+1;
        //                 if(len>max){
        //                     maxi=i;
        //                     maxL=left;
        //                     maxR=right;
        //                     max=len;
        //                 }
        //             }
        //         }
        //     }
        // }
        // char[] str=s.toCharArray();
        // if(maxi!=-1){
        //     for(int i=maxL;i<=maxR;i++){
        //         str[i]='1';
        //     }
        // }
        // int ans=0;
        // for(int i=0;i<n;i++){
        //     if(str[i]=='1') ans++;
        // }
        // return ans;
    }
}