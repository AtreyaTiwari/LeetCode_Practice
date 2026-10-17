class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        //hold num and org ind
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }

        Arrays.sort(arr,(a,b)->{
            int sumA=getSum(a[0]);
            int sumB=getSum(b[0]);

            if(sumA!=sumB){
                return Integer.compare(sumA, sumB);
            }else{
                return Integer.compare(a[0],b[0]);
            }
        });

        int[] map=new int[n];
        for(int i=0;i<n;i++){
            map[arr[i][1]]=i;
        }
        boolean[] vis=new boolean[n];
        int cycle=0;
        for(int i=0;i<n;i++){
            if(vis[i]){
                continue;
            }
            cycle+=1;
            int j=i;
            while(!vis[j]){
                vis[j]=true;
                j=map[j];
            }
        }
        return n-cycle;
    }
    
    private static int getSum(int num){
        int sum=0;
        while(num>0){
            sum+=(num%10);
            num=num/10;
        }
        return sum;
    }
}