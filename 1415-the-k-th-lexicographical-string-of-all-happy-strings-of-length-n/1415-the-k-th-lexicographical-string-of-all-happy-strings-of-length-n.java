class Solution {
    public String getHappyString(int n, int k) {
        char[] arr={'a','b','c'};
        List<String> list=new ArrayList<>();
        StringBuilder str=new StringBuilder();
        generate(str,n,list,arr);
        if(k>list.size()) return "";
        return list.get(k-1);
    }
    private void generate(StringBuilder str,int n,List<String> list,char[] arr){
        if(str.length()==n){
            list.add(str.toString());
            return;
        }
        for(int i=0;i<3;i++){
            if(str.length()>0 && str.charAt(str.length()-1)==arr[i]){
                continue;
            }
            str.append(arr[i]);
            generate(str,n,list,arr);
            str.deleteCharAt(str.length() - 1);            
        }
    }
}