class Solution {
    public long maxMatrixSum(int[][] matrix) {
        //agrr neg num odd honge to ek bchega vrna agr even h to fir kaise bhi pos bn hi jayenge
        long  posSum=0;
        long  negSum=0;
        int min=Integer.MAX_VALUE;
        int n=matrix.length;
        int negCount=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                //agrr num pos h
                if(matrix[i][j]>=0){
                    posSum+=matrix[i][j];
                }else{ //agrr num neg h
                    negSum+=matrix[i][j];
                    negCount++;
                }

                if(min>Math.abs(matrix[i][j])){
                    min=Math.abs(matrix[i][j]);
                }
            }
        }
        if(negCount%2==1){
            return posSum+Math.abs(negSum)-(2*min);
        }
        return posSum+Math.abs(negSum);
    }
}