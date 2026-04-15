class Solution {
    public int closestTarget(String[] words, String target, int s) {
        int min=Integer.MAX_VALUE;
        int n=words.length;
        for(int i=s;i<n;i++){
            if(words[i].equals(target)){
                int rd=(i-s);
                int ld=(n-i)+(s);
                min=Math.min(min,Math.min(rd,ld));
            }
        }
        for(int i=s;i>=0;i--){
            if(words[i].equals(target)){
                int ld=(s-i);
                int rd=(n-s)+(i);
                min=Math.min(min,Math.min(rd,ld));
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}