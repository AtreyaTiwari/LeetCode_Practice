class Solution {
    // public List<String> removeSubfolders(String[] folder) {
    //     Arrays.sort(folder);

    //     List<String> ans = new ArrayList<>();
    //     ans.add(folder[0]);

    //     for (int i = 1; i < folder.length; i++) {
    //         String last = ans.get(ans.size() - 1);
    //         String curr = folder[i];
    //         if (!curr.startsWith(last + "/")) {
    //             ans.add(curr);
    //         }
    //     }
    //     return ans;
    // }

    //check this 
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        ArrayList<String> ans=new ArrayList<>();
        ans.add(folder[0]);
        for(int i=1;i<folder.length;i++){
            String last=ans.get(ans.size()-1);
            String curr=folder[i];

            if(!curr.startsWith(last+"/")){
                ans.add(curr);
            }
        }
        return ans;
    }
    private static ArrayList<String> compare(String fol,ArrayList<String> ans){
        String check=ans.get(ans.size()-1);
        int i=0;
        while(i<Math.min(check.length(),fol.length())){
            if(check.charAt(i)==fol.charAt(i)){
                i++;
            }
        }
        if(i==Math.min(check.length(),fol.length())){
            if(i<fol.length() && fol.charAt(i)=='/'){
                return ans;
            }
        }else{
            ans.add(fol);
        }
        return ans;
    } 
}