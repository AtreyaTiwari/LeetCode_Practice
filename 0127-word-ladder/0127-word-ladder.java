class Solution {
    static class Pair{
        String w;int v;
        public Pair(String w,int v){
            this.w=w;
            this.v=v;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>();
        for(String s:wordList){
            set.add(s);
        }
        if(!set.contains(endWord)) return 0;

        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        String alpha="abcdefghijklmnopqrstuvwxyz";

        while(!q.isEmpty()){
            Pair p=q.poll();
            String w=p.w;
            int v=p.v;
            if(w.equals(endWord)) return v;
            set.remove(w);

            char[] arr=w.toCharArray();
            for(int i=0;i<arr.length;i++){
                char org=arr[i];
                for(int j=0;j<26;j++){
                    arr[i]=alpha.charAt(j);
                    String temp=new String(arr);
                    if(set.contains(temp)){
                        q.add(new Pair(temp,v+1));
                    }
                }
                arr[i]=org;
            }
        }
        return 0;
    }
}