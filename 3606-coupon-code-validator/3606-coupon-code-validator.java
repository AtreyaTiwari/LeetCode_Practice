class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> result=new ArrayList<>();

        Map<String, Integer> business=new HashMap<>();
        business.put("electronics",0);
        business.put("grocery",1);
        business.put("pharmacy",2);
        business.put("restaurant",3);

        List<String[]> valid=new ArrayList<>();
        for(int i=0;i<code.length;i++){
            if (isActive[i] &&
                code[i] != null && !code[i].isEmpty() &&
                code[i].matches("^[a-zA-Z0-9_]+$") &&
                business.containsKey(businessLine[i])) {

                valid.add(new String[]{businessLine[i], code[i]});
            }
        }
        valid.sort((a,b) -> {
            int cmp =Integer.compare(business.get(a[0]), business.get(b[0]));
            if(cmp==0) return a[1].compareTo(b[1]);
            return cmp;
        });

        for(String[] coupon: valid){
            result.add(coupon[1]);
        }

        return result;
    }
}