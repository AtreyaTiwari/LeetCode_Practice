class Solution {
    public String processStr(String s) {
        StringBuilder res=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c<='z' && c>='a'){
                res.append(c);
            }else if(c=='*'){
                if(res.length()!=0){
                    res.deleteCharAt(res.length()-1);
                }
            }else if(c=='#'){
                String dup=res.toString();
                res.append(dup);
            }else{
                res=new StringBuilder(res.reverse().toString());
            }
        }
        return res.toString();
    }
}