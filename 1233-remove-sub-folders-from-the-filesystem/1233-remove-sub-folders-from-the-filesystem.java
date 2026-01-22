class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        ArrayList<String> ans=new ArrayList<>();
        ans.add(folder[0]);
        for(int j=1;j<folder.length;j++){
            String check=ans.get(ans.size()-1);
            String fol=folder[j];
            int mini=Math.min(check.length(),fol.length());
            int i=0;
            while(i<mini && check.charAt(i)==fol.charAt(i)){
                i++;
            }
            if(i==mini){
                if(i<fol.length() && fol.charAt(i)=='/'){
                    continue;
                }
                else{
                    ans.add(fol);
                }
            }else{
                ans.add(fol);
            }
        }
        return ans;
    }
    // private static ArrayList<String> compare(String fol,ArrayList<String> ans){
        
    // } 
}