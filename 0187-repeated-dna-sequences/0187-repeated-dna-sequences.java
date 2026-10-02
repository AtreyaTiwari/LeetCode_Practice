class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans=new ArrayList<>();
        int n=s.length();
        if(n<10) return ans;
        HashMap<String,Integer> map=new HashMap<>();

        for(int i=0;i<=n-10;i++){
            String str=s.substring(i,i+10);
            int freq=map.getOrDefault(str,0);
            if(freq==1) ans.add(str);
            map.put(str,freq+1);
        }
        
        // for(String key:map.keySet()){
        //     if(map.get(key)>1) ans.add(key);
        // }
        return ans;
    }
}