package leetcode.easy;

public class ValidMountainArray {
    public boolean validMountainArray(int[] a) {
        if(a == null || a.length < 3){
            return false;
        }
        int i = 0;
        while(i<a.length-1){
            if(a[i] < a[i+1]){
                i++;
            }else{
                break;
            }
        }

        if(i == 0 || i == a.length-1){
            return false;
        }

        while(i<a.length-1){
            if(a[i] > a[i+1]){
                i++;
            }else{
                break;
            }
        }

        return i == a.length-1;
    }

    public static void main(String[] args) {
        ValidMountainArray vm = new ValidMountainArray();
        System.out.println(vm.validMountainArray(new int[]{2,1}));
        System.out.println(vm.validMountainArray(new int[]{3,5,5}));
        System.out.println(vm.validMountainArray(new int[]{0,3,2,1}));
        System.out.println(vm.validMountainArray(new int[]{0,3,3,2,1}));
    }
}
