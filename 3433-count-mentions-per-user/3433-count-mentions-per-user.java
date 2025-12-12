class Solution {
    public int[] countMentions(int numUsers, List<List<String>> events) {
        //have to create 3 array for ans, online check and offline till time

        int[] ans=new int[numUsers];
        boolean[] online=new boolean[numUsers];
        int[] offlineTime=new int[numUsers];

        for(int i=0;i<numUsers;i++) online[i]=true;

        for(List<String> ev:events){
            String event=ev.get(0);
            int time=Integer.parseInt(ev.get(1));

            //check kro phle se offline hai to khin online hone ka samay to nhi a gya
            for(int i=0;i<numUsers;i++){
                if(!online[i] && offlineTime[i]<=time){
                    online[i]=true;
                }
            }

            //dekho event khin Offline ka to nhi h
            if(event.equals("OFFLINE")){
                int id=Integer.parseInt(ev.get(2));
                online[id]=false;
                offlineTime[id]=time+60;
            }else{
                //agar Offline nhi h to fir MESSAGE hoga
                String ids=ev.get(2);
                String[] tokens = ids.split(" ");

                for(String i:tokens){
                    if(i.equals("ALL")){
                        for (int j = 0; j < numUsers; j++) {
                            ans[j]++;
                        }
                    }else if(i.equals("HERE")){
                        for (int j = 0; j < numUsers; j++) {
                            if(online[j]) ans[j]++;
                        }
                    }else if(i.startsWith("id")){
                        int id = Integer.parseInt(i.substring(2));
                        ans[id]++;
                    }
                }
            }
        }
        return ans;
    }
}