package leetcode.easy;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] a) {
        int [] res = new int[a.length];
        int x=0, y = a.length-1;
        for(int i=0;i<a.length;i++){
            if(a[i] % 2 == 0){
                res[x++] = a[i];
            }else{
                res[y--] = a[i];
            }
        }

        return res;
    }
}
