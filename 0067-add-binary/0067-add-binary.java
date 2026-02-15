class Solution {
    public String addBinary(String a, String b){
        int carry=0;
        int i=a.length()-1;
        int j=b.length()-1;
        StringBuilder res=new StringBuilder();

        while(i>=0 || j>=0 || carry!=0){
            int sum=carry;

            if(i>=0) sum+= a.charAt(i--)-'0';
            if(j>=0) sum+= b.charAt(j--)-'0';

            res.append(sum%2);
            carry=sum/2;

        }
        return res.reverse().toString();
    }


    // {
    //     int x=binTOdeci(a);
    //     int y=binTOdeci(b);
    //     int sum=x+y;

    //     return deciTObin(sum);
    // }
    // int binTOdeci(String str){
    //     int sum=0;
    //     char[] arr=str.toCharArray();
    //     int n=arr.length;
    //     for(int i=n-1;i>=0;i--){
    //         sum += (arr[i] - '0') *(int) Math.pow(2, n - i - 1);
    //     }
    //     return sum;
    // }
    // String deciTObin(int num){
    //     if (num == 0) return "0";
    //     StringBuilder sb = new StringBuilder();
    //     while (num > 0) {
    //         sb.append(num % 2);
    //         num = num / 2;
    //     }
    //     return sb.reverse().toString();
    // }
}