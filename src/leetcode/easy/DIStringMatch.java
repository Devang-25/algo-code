package leetcode.easy;

import java.util.Arrays;

public class DIStringMatch {
    public int[] diStringMatch(String s) {
        if(s == null || s.length() == 0){
            return null;
        }

        int n = s.length();
        int [] result = new int [n+1];
        boolean [] taken = new boolean[n+1];

        for(int i=0;i<n;i++){
            if(i==0){
                if(s.charAt(i) == 'D'){
                    result[0] = n;result[1] = 0;
                }else{
                    result[0] = 0;result[1] = n;
                }
                taken[0] = taken[n] = true;
            }else{
                if(s.charAt(i) == 'D'){
                    int nextSmallest = 0;
                    for(int j=0;j<n+1;j++){
                        if(!taken[j]){
                            nextSmallest = j;
                            break;
                        }
                    }
                    taken[nextSmallest] = true;
                    result[i+1] = nextSmallest;
                    int k = i;
                    while(k>=0){
                        if(result[k] < result[k+1]){
                            swap(result,k,k+1);
                            k--;
                        }else{
                            break;
                        }
                    }
                }else{
                    int nextLargest = n;
                    for(int j=n;j>=0;j--){
                        if(!taken[j]){
                            nextLargest = j;
                            break;
                        }
                    }
                    result[i+1] = nextLargest;
                    taken[nextLargest] = true;
                    int k = i;
                    while(k>=0){
                        if(result[k] > result[k+1]){
                            swap(result,k,k+1);
                            k--;
                        }else{
                            break;
                        }
                    }
                }
            }
        }

        return result;
    }

    private void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        DIStringMatch ds = new DIStringMatch();
        System.out.println(Arrays.toString(ds.diStringMatch("IDID")));
        System.out.println(Arrays.toString(ds.diStringMatch("III")));
        System.out.println(Arrays.toString(ds.diStringMatch("DDI")));
        System.out.println(Arrays.toString(ds.diStringMatch("DDDDDD")));
        System.out.println(Arrays.toString(ds.diStringMatch("DIIDDI")));
    }
}
