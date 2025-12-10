class Solution {
    static int mod=1000000007;
    public int countPermutations(int[] complexity) {
        int min=Integer.MAX_VALUE;
        int occ=0;
        int n=complexity.length;
        for(int i=0;i<n;i++){
            if(min>=complexity[i]){
                min=complexity[i];
                occ++;
            }
        }
        if(complexity[0]!=min || (complexity[0]==min && occ>1)) return 0;
        return fact(n-1)%mod;
    }
    private static int fact(int num){
        if(num<=1) return 1;
        long f=1;
        for(int i=1;i<=num;i++){
            f=(f*i)%mod;
        }
        return (int)f%mod;
    }
}