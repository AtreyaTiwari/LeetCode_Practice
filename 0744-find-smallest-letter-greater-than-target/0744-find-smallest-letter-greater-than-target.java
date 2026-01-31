class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start=0,end=letters.length-1;int mid=0;
        char ch=letters[0];
        while (start<=end) {
            mid=start+(end-start)/2;
            if(letters[mid]<=target){
                start=mid+1;
            }else{
                ch=letters[mid];
                end=mid-1;
            }
        }
        if(letters[mid]>target){
            return letters[mid];
        }
        return ch;
    }
}