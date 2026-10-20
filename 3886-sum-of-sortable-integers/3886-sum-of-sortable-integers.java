import java.util.*;

class Solution {

    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        List<Integer> divisors = getDiv(n);

        int sum = 0;

        for (int k : divisors) {
            if (isValid(nums, sorted, k)) {
                sum += k;
            }
        }

        return sum;
    }

    private boolean isValid(int[] nums, int[] sorted, int k) {

        int n = nums.length;

        for (int i = 0; i < n; i += k) {

            int[] a = new int[k];
            int[] b = new int[k];

            for (int j = 0; j < k; j++) {
                a[j] = nums[i + j];
                b[j] = sorted[i + j];
            }

            if (!kmpSearch(a, b)) return false;
        }

        return true;
    }

    // KMP based rotation check
    private boolean kmpSearch(int[] textArr, int[] pattern) {

        int k = textArr.length;

        int[] text = new int[2 * k];
        for (int i = 0; i < 2 * k; i++) {
            text[i] = textArr[i % k];
        }

        int[] lps = buildLPS(pattern);

        int i = 0, j = 0;

        while (i < text.length) {
            if (text[i] == pattern[j]) {
                i++; j++;
                if (j == pattern.length) return true;
            } else {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }

        return false;
    }

    private int[] buildLPS(int[] pattern) {
        int[] lps = new int[pattern.length];

        int len = 0, i = 1;

        while (i < pattern.length) {
            if (pattern[i] == pattern[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) len = lps[len - 1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    private List<Integer> getDiv(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                if (i != n / i) list.add(n / i);
            }
        }

        return list;
    }
}
// class Solution {
//     public int sortableIntegers(int[] nums) {
//         int n=nums.length;
//         int[] sorted=nums.clone();
//         Arrays.sort(sorted);

//         List<Integer> div=getDiv(n);

//         int sum=0;
//         for(int k:div){
//             if(isValid(nums,sorted,k)){
//                 sum+=k;
//             }
//         }
//         return sum;
//     }
//     private static boolean isValid(int[] nums, int[] sorted, int k) {

//     int n = nums.length;

//     for (int i = 0; i < n; i += k) {

//         StringBuilder a = new StringBuilder();
//         StringBuilder b = new StringBuilder();

//         for (int j = 0; j < k; j++) {
//             a.append(nums[i + j]).append(",");
//             b.append(sorted[i + j]).append(",");
//         }

//         String doubled = a.toString() + a.toString();

//         if (!doubled.contains(b.toString())) {
//             return false;
//         }
//     }

//     return true;
// }
//     // private static boolean isValid(int[] nums,int[] sorted,int k){
//     //     int n=nums.length;
//     //     for(int i=0;i<n;i+=k){
//     //         int[] a=new int[k];
//     //         int[] b=new int[k];
//     //         for(int j=0;j<k;j++){
//     //             a[j]=nums[i+j];
//     //             b[j]=sorted[i+j];
//     //         }
//     //         if(!isRotation(a,b)) return false;
//     //     }
//     //     return true;
//     // }
//     // private static boolean isRotation(int[] a,int[] b){
//     //     int k=a.length;
//     //     int[] doubled=new int[2*k];
//     //     for(int i=0;i<2*k;i++){
//     //         doubled[i]=a[i%k];
//     //     }
//     //     for(int i=0;i<=k;i++){
//     //         boolean match=true;
//     //         for(int j=0;j<k;j++){
//     //             if(doubled[i+j]!= b[j]){
//     //                 match =false;
//     //                 break;
//     //             }
//     //         }
//     //         if(match) return true;
//     //     }
//     //     return false;
//     // }
    
//     private static List<Integer> getDiv(int n){
//         List<Integer> list=new ArrayList<>();
//         for(int i=1;i*i<=n;i++){
//             if(n%i==0){
//                 list.add(i);
//                 if(n/i!=i) list.add(n/i);
//             }
//         }
//         return list;
//     }
// }