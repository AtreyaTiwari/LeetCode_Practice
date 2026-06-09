class Solution {
    private int gcd(int a,int b){
        while(b!=0){
            int temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
    public boolean canMeasureWater(int x, int y, int target) {
        int gcd=gcd(x,y);
        return gcd!=0 && target%gcd==0 && target<=x+y;
    }
}

// class Solution {
//     Set<String> set=new HashSet<>();
//     public boolean canMeasureWater(int x, int y, int target) {
//         return dfs(0,0,target,x,y);
//     }
//     private boolean dfs(int x,int y,int target,int m,int n){
//         String vis= x+","+y;
//         if(set.contains(vis)) return false;
//         if(x+y==target) return true;
//         set.add(vis);
//         boolean s1=dfs(m,y,target,m,n);
//         boolean s2=dfs(x,n,target,m,n);
//         boolean s3=dfs(0,y,target,m,n);
//         boolean s4=dfs(x,0,target,m,n);
//         boolean s5=false;
//         if(x<m){
//             int fill=Math.min(y,m-x);
//             s5=dfs(x+fill,y-fill,target,m,n);
//         }
//         boolean s6=false;
//         if(y<n){
//             int fill=Math.min(x,n-y);
//             s6=dfs(x-fill,y+fill,target,m,n);
//         }
//         return s1||s2||s3||s4||s5||s6;
//     }
// }