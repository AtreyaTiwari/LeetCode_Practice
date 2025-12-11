class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int count=0;
        int[] xMin=new int[n+1];
        int[] xMax=new int[n+1];
        int[] yMax=new int[n+1];
        int[] yMin=new int[n+1];
        
        Arrays.fill(yMin, Integer.MAX_VALUE);
        Arrays.fill(xMin, Integer.MAX_VALUE);

        for(int[] arr:buildings){
            int x=arr[0],y=arr[1];

            xMin[y]=Math.min(xMin[y],x);
            xMax[y]=Math.max(xMax[y],x);
            yMin[x]=Math.min(yMin[x],y);
            yMax[x]=Math.max(yMax[x],y);
        }
        for(int[] arr:buildings){
            int x=arr[0],y=arr[1];

            if(yMin[x]<y && yMax[x]>y && xMin[y]<x && xMax[y]>x){
                count++;
            }
        }
        return count;
    }
}