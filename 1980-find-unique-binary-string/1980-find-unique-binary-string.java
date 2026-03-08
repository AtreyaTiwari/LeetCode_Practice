class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set=new HashSet<>();
        for(String s:nums){
            set.add(s);
        }
        StringBuilder s=new StringBuilder(nums[0]);
        return check(s,nums.length,0,set);
    }
    private static String check(StringBuilder s,int n,int i,Set<String> set){
        if(!set.contains(s.toString())) return s.toString();
        if(i==n) return null;
        char c=s.charAt(i);
        s.setCharAt(i,c == '0' ? '1' : '0');
        String res=check(s,n,i+1,set);
        if(res!=null) return res; 
        s.setCharAt(i,c);

        return check(s,n,i+1,set);
    }
}