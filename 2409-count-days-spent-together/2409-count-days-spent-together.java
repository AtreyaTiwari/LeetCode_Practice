class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        float aA= Float.parseFloat(arriveAlice.substring(0,2));
        aA+=(Float.parseFloat(arriveAlice.substring(3,5)))/100;
        float lA= Float.parseFloat(leaveAlice.substring(0,2));
        lA+=(Float.parseFloat(leaveAlice.substring(3,5)))/100;

        float bA= Float.parseFloat(arriveBob.substring(0,2));
        bA+=(Float.parseFloat(arriveBob.substring(3,5)))/100;
        float bL= Float.parseFloat(leaveBob.substring(0,2));
        bL+=(Float.parseFloat(leaveBob.substring(3,5)))/100;

        float greaterArr=aA>=bA?aA:bA;
        float smallerLev=lA<=bL?lA:bL;
        System.out.println(greaterArr+" "+smallerLev);
        
        if(greaterArr>smallerLev) return 0;
        else if(greaterArr==smallerLev) return 1;
        else{
            int ans=0;
            int[] arr={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int gInt=(int)greaterArr;
            int gDeci=Math.round((greaterArr - gInt) * 100);
            System.out.println(gInt+" "+gDeci);

            int sInt=(int)smallerLev;
            int sDeci=Math.round((smallerLev - sInt) * 100);
            System.out.println(sInt+" "+sDeci);
            if(gInt==sInt) return sDeci-gDeci+1;

            ans+=(arr[gInt-1]-gDeci+1);
            gInt+=1;
            ans+=sDeci;
            for(int i=gInt;i<sInt;i++){
                ans+=arr[i-1];
            }
            return ans;
        }
        
    }
}