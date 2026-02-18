class Solution {
    static class Disjoint{
        List<Integer> par=new ArrayList<>();
        List<Integer> size=new ArrayList<>();

        public Disjoint(int n){
            for(int i=0;i<n;i++){
                par.add(i);
                size.add(1);
            }
        }
        public void unionBySize(int u,int v){
            int ul_u=findPar(u);
            int ul_v=findPar(v);

            if(ul_u==ul_v) return;
            if(size.get(ul_u)>size.get(ul_v)){
                par.set(ul_v,ul_u);
                size.set(ul_u,size.get(ul_u)+size.get(ul_v));
            }else{
                par.set(ul_u,ul_v);
                size.set(ul_v,size.get(ul_u)+size.get(ul_v));
            }
        }
        public int findPar(int node){
            if(par.get(node)==node) return node;
            int uPar=findPar(par.get(node));
            par.set(node,uPar);
            return par.get(node);
        }
    }
    public int makeConnected(int n, int[][] connections) {
        Disjoint ds=new Disjoint(n);
        int extraEdge=0;
        int noCC=0;

        for(int[] arr:connections){
            int src=arr[0];
            int nd=arr[1];

            if(ds.findPar(src)==ds.findPar(nd)){
                extraEdge++;
            }else{
                ds.unionBySize(src,nd);
            }
        }
        for(int i=0;i<n;i++){
            if(ds.par.get(i)==i){
                noCC++;
            }
        }
        if(extraEdge>=noCC-1){
            return noCC-1;
        }else{
            return -1;
        }
    }
}