class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String n="123456789";
        String l=String.valueOf(low);
        String h=String.valueOf(high);
        List<Integer> ans=new ArrayList<>();
        for(int len=l.length();len<=h.length();len++){
            for(int start=0;start<=9-len;start++){
                int num=Integer.parseInt(n.substring(start,start+len));
                if(num>=low && num<=high){
                    ans.add(num);
                }
            }
        }
        return ans;
    }
}