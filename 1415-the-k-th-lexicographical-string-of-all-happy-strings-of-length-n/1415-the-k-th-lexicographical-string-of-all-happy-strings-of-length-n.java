class Solution {
    int count=0;
    String ans="";
    public String getHappyString(int n, int k) {
        char[] arr={'a','b','c'};
        StringBuilder str=new StringBuilder();
        generate(str,n,arr,k);
        return count>=k?ans:"";
    }
    private void generate(StringBuilder str,int n,char[] arr,int k){
        if(str.length()==n){
            count++;
            if(count==k){
                ans=str.toString();
            }
            return;
        }
        for(int i=0;i<3;i++){
            if(str.length()>0 && str.charAt(str.length()-1)==arr[i]){
                continue;
            }
            str.append(arr[i]);
            generate(str,n,arr,k);
            str.deleteCharAt(str.length() - 1);            
        }
    }
}