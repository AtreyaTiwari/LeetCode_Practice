class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        HashMap<String , List<Character>> map=new HashMap<>();
        for(int i=0;i<allowed.size();i++){
            String str=allowed.get(i);
            String key=str.substring(0,2);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(str.charAt(2));
        }
        return helper(bottom,"",0,map);
    }
    private static boolean helper(String row,String next,int ind,HashMap<String , List<Character>> map){
        if(row.length()==1) return true;

        if(next.length()==row.length()-1){
            return helper(next,"",0,map);
        }
        String key=row.substring(ind,ind+2);
        if(!map.containsKey(key)){
            return false;
        }
        for(char c:map.get(key)){
            if(helper(row,next+c,ind+1,map)){
                return true;
            }
        }
        return false;
    }

}