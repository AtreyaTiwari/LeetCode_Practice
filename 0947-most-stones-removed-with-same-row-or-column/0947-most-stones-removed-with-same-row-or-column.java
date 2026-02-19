class Solution {
    public int removeStones(int[][] stones) {
        int maxRow=0;
        int maxCol=0;
        
        for(int[] arr:stones){
            maxRow=Math.max(maxRow,arr[0]);
            maxCol=Math.max(maxCol,arr[1]);
        }
        DisjointSet ds=new DisjointSet(maxRow+maxCol+1);
        Set<Integer> used=new HashSet<>();
        for(int[] arr:stones){
            int nodeRow=arr[0];
            int nodeCol=arr[1]+maxRow+1;
            ds.unionBySize(nodeRow,nodeCol);
            used.add(nodeRow);
            used.add(nodeCol);
        }
        int compo=0;
        for(int node:used){
            if(ds.findUPar(node)==node){
                compo++;
            }
        }
        return stones.length-compo;
    }
    static class DisjointSet{
        List<Integer> par=new ArrayList<>();
        List<Integer> size=new ArrayList<>();
        
        public DisjointSet(int n){
            for(int i=0;i<=n;i++){
                par.add(i);
                size.add(1);
            }
        }
        public int findUPar(int node){
            if(par.get(node)==node) return node;
            int uPar=findUPar(par.get(node));
            par.set(node,uPar);
            return par.get(node);
        }
        public void unionBySize(int u,int v){
            int ul_u=findUPar(u);
            int ul_v=findUPar(v);
            
            if(ul_u==ul_v) return;
            if(size.get(ul_u)>size.get(ul_v)){
                par.set(ul_v,ul_u);
                size.set(ul_u,size.get(ul_u)+size.get(ul_v));
            }else{
                par.set(ul_u,ul_v);
                size.set(ul_v,size.get(ul_u)+size.get(ul_v));
            }
        }
    }
}