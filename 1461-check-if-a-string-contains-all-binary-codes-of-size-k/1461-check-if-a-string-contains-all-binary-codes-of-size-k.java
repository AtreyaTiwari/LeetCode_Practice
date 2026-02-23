class Solution {
    public boolean hasAllCodes(String s, int k) {
        if(s.length()<k) return false;
        Set<String> set=new HashSet<>();
        for(int i=0;i<=s.length()-k;i++){
            String sub=s.substring(i,i+k);
            set.add(sub);
        }
        double max=Math.pow(2,k);
        return set.size()==max;
    }
}