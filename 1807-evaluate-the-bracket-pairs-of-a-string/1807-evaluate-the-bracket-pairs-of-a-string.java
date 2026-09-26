class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map=new HashMap<>();
        for(List<String> list:knowledge){
            map.put(list.get(0),list.get(1));
        }
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        // System.out.println(map);
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='('){
                StringBuilder key=new StringBuilder();
                int j=i+1;
                while(s.charAt(j)!=')'){
                    key.append(s.charAt(j));
                    j++;
                }
                i=j;
                String skey=key.toString();
                if(map.containsKey(skey.toString())){
                    sb.append(map.get(skey));
                }else{
                    sb.append('?');
                }
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}