class Solution {
    public int minOperations(String s) {
        int count1=0;
        int n=s.length();
        StringBuilder str=new StringBuilder();
        for(int i=0;i<n;i++){
            if(i%2==0) str.append('0');
            else str.append('1');
        }
        for(int i=0;i<n;i++){
            if(str.charAt(i)!=s.charAt(i)) count1++;
        }
        str=new StringBuilder();
        int count2=0;
        for(int i=0;i<n;i++){
            if(i%2==0) str.append('1');
            else str.append('0');
        }
        for(int i=0;i<n;i++){
            if(str.charAt(i)!=s.charAt(i)) count2++;
        }
        return Math.min(count1,count2);
    }
}