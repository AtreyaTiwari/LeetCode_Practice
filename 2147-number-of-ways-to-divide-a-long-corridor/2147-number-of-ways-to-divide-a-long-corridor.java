class Solution {
    int mod = 1000000007;
    public int numberOfWays(String corridor) {
        long count = 1;
        int seats = 0;
        int prevIndex = 0;

        for(int i=0; i<corridor.length(); i++){
            char c = corridor.charAt(i);
            if(c == 'S'){
                seats++;
                
                if(seats > 2 && seats % 2 == 1){
                    count = (count * (i - prevIndex) % mod);
                }
                prevIndex = i;
            }
        }

        return seats > 1 && seats % 2 == 0 ? (int)count : 0;
    }
}