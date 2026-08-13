class Solution {
    public String reverseWords(String s) {
        String[] arr= s.trim().split("\\s+");
        // String out="";
        StringBuilder sb=new StringBuilder();
        for (int i = arr.length-1; i >0; i--) {
            // out+=arr[i]+" ";
            sb.append(arr[i]+" ");
        }
        sb.append(arr[0]);
        return sb.toString();
    }
}