package leetcode.medium;

public class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] a) {
        if(a == null || a.length <= 1){
            return 0;
        }
        int minCnt = 0;
        for(int j=0;j<a[0].length();j++){
            for(int i=0;i<a.length-1;i++){
                if(a[i].charAt(j) > a[i+1].charAt(j)){
                    minCnt++;
                    break;
                }
            }
        }

        return minCnt;
    }
    public static void main(String[] args) {
        DeleteColumnsToMakeSorted dc = new DeleteColumnsToMakeSorted();
        System.out.println(dc.minDeletionSize(new String[] { "cba","daf","ghi" }));
        System.out.println(dc.minDeletionSize(new String[] { "zyx","wvu","tsr" }));
        System.out.println(dc.minDeletionSize(new String[] { "a","b" }));
    }
}
