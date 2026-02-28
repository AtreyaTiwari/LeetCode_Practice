class Solution {

    public int concatenatedBinary(int n) {
        int mod=1000000007;
        StringBuilder s=new StringBuilder();

        for(int i=1;i<=n;i++){
            String bin=Integer.toBinaryString(i);
            s.append(bin);
        }
        int sum=0;
        int pow=1;
        for(int i=s.length()-1;i>=0;i--){
            int num=s.charAt(i)-'0';
            sum=(sum+(num*pow)%mod)%mod;
            pow=(pow*2)%mod;
        }
        return sum%mod;

    }
}