class Solution {
    public int maxNumberOfFamilies(int m, int[][] res) {
        Arrays.sort(res,(a,b)->a[0]-b[0]);
        System.out.println(Arrays.deepToString(res));
        int row=res[0][0];
        int n=res.length;
        int[] seats=new int[11];
        int count=0;
        int dig=1;
        for(int i=0;i<n;i++){
            int curR=res[i][0];
            if(curR==row){
                seats[res[i][1]]=-1;
            }else{
                dig++;
                System.out.println(dig);
                if(seats[2]==0 && seats[3]==0 && seats[4]==0 && seats[5]==0){
                    count++;
                    seats[4]=-1;
                    seats[5]=-1;
                }
                if(seats[6]==0 && seats[7]==0 && seats[4]==0 && seats[5]==0){
                    count++;
                    seats[6]=-1;
                    seats[7]=-1;
                } 
                if(seats[6]==0 && seats[7]==0 && seats[8]==0 && seats[9]==0){
                    count++;
                }
                for(int j=0;j<11;j++){
                    seats[j]=0;
                }
                row=curR;
                i--;
            }
        }
        if(seats[2]==0 && seats[3]==0 && seats[4]==0 && seats[5]==0){
            count++;
            seats[4]=-1;
            seats[5]=-1;
        }
        if(seats[6]==0 && seats[7]==0 && seats[4]==0 && seats[5]==0){
            count++;
            seats[6]=-1;
            seats[7]=-1;
        } 
        if(seats[6]==0 && seats[7]==0 && seats[8]==0 && seats[9]==0){
            count++;
        }
        return count + ((m-dig)*2);
    }
}