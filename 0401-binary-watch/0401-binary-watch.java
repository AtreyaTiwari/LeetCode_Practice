class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        ArrayList<String> list=new ArrayList<>();
        
        for(int hr=0;hr<12;hr++){
            for(int mn=0;mn<60;mn++){
                if(Integer.bitCount(hr)+Integer.bitCount(mn)==turnedOn){
                    String str=hr+":"+(mn<10?"0"+mn:mn);
                    list.add(str);
                }
            }
        }
        return list;
    }
} 