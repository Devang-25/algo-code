package leetcode.medium;

public class HIndex {
//    public int hIndex(int[] citations) {
//        Arrays.sort(citations);
//        int ind = 0;
//        for(int i=citations.length-1;i>=0;i--){
//            if(citations[i] >= ind+1){
//                ind++;
//            }else {
//                break;
//            }
//        }
//
//        return ind;
//    }

    public int hIndex(int[] citations) {
        int [] cnt = new int[citations.length+1];
        for(int i=0;i<citations.length;i++){
            if(citations[i] > citations.length){
                cnt[citations.length]++;
            }else{
                cnt[citations[i]]++;
            }
        }

        int agg  =0;
        for(int i=citations.length;i>=0;i--){
            agg += cnt[i];
            if(agg >= i){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        HIndex hi = new HIndex();
        System.out.println(hi.hIndex(new int[] {3,0,6,1,5,3,2,4,1,9,3,2,4,5,3,2,5}));
    }
}
