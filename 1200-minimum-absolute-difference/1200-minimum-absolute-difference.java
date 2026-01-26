class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n=arr.length;
        List<List<Integer>> ans=new ArrayList<>();
        int diff=Integer.MAX_VALUE;
        Arrays.sort(arr);
        // for(int i=0;i<n-1;i++){
        //     for(int j=i+1;j<n;j++){
        //         diff=Math.min(diff,Math.abs(arr[j]-arr[i]));
        //     }
        // }
        // for(int i=0;i<n-1;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(Math.abs(arr[j]-arr[i])==diff){
        //             ans.add(Arrays.asList(arr[i],arr[j]));
        //         }
        //     }
        // }
        for(int i=0;i<n-1;i++){
            diff=Math.min(diff,Math.abs(arr[i+1]-arr[i]));
        }
        for(int i=0;i<n-1;i++){
            if(Math.abs(arr[i+1]-arr[i])==diff){
                    ans.add(Arrays.asList(arr[i],arr[i+1]));
                }
        }

        return ans;
    }
}