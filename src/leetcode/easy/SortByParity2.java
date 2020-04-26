package leetcode.easy;

import java.util.Arrays;

/**
 * Created by mns on 10/14/18.
 */
public class SortByParity2 {
    public int[] sortArrayByParityII(int[] a) {
        int [] res = new int[a.length];
        int i = 0,j=1,k=0;
        while(i < a.length || j < a.length){
            if(a[k]%2 == 0){
                res[i] = a[k++];
                i+=2;
            }else{
                res[j] = a[k++];
                j+=2;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        SortByParity2 sbp = new SortByParity2();
        System.out.println(Arrays.toString(sbp.sortArrayByParityII(new int[]{4,2,5,7})));
        System.out.println(Arrays.toString(sbp.sortArrayByParityII(new int[]{4})));
        System.out.println(Arrays.toString(sbp.sortArrayByParityII(new int[]{1,4})));
    }
}
