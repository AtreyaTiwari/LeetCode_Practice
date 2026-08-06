class Solution {
    public int smallestNumber(int n, int t) {
        for(int i=n;i<111;i++){
            if(check(i,t)) return i;
        }
        return -1;
    }
    private static boolean check(int num,int t){
        int prod=1;
        while(num>0){
            prod*=(num%10);
            num/=10;
        }
        return prod%t==0;
    }
}