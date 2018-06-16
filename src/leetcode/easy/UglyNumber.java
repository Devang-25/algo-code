package leetcode.easy;

public class UglyNumber {
    public boolean isUgly(int n) {

        if(n <= 0)
            return false;

        while(n > 1){
            if(n % 2 == 0){
                n/=2;
            }else if(n%3 == 0){
                n/=3;
            }else if(n %5==0){
                n/=5;
            }else{
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        UglyNumber ug = new UglyNumber();
        System.out.println(ug.isUgly(14));
        System.out.println(ug.isUgly(1));
        System.out.println(ug.isUgly(6));
        System.out.println(ug.isUgly(8));
        System.out.println(ug.isUgly(-2147483648));
    }
}
