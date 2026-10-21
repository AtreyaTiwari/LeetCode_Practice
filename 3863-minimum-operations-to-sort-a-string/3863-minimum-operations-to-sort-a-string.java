class Solution {
    public int minOperations(String s) {
        int n=s.length();
        char prev=s.charAt(0);
        boolean alreadySorted=true;
        char min=s.charAt(0);
        char max=s.charAt(0);

        for(int i=1;i<n;i++){
            if(s.charAt(i)<prev){
                alreadySorted=false;
            }
            min=(char)Math.min(min,s.charAt(i));
            max=(char)Math.max(max,s.charAt(i));
            prev=s.charAt(i);
        }

        if(alreadySorted || n==1) return 0;
        if(n<=2) return -1;
        
        if(s.charAt(0)==min || s.charAt(n-1)==max) return 1;
        
        for(int i=1;i<n-1;i++){
            if(s.charAt(i)==min || s.charAt(i)==max) return 2;
        }
        return 3;
    }
}