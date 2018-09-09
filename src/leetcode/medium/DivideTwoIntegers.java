package leetcode.medium;

public class DivideTwoIntegers {
    public int divide(int dividend , int divisor){
        long result = 0;
        boolean sign = false;
        if(dividend <0  && divisor <0 || dividend >0 && divisor >0){
            sign = true;
        }
        long dd = Math.abs(dividend);
        long ds = Math.abs(divisor);
        while(dd >= ds){
            dd -= ds;
            result++;
        }

        System.out.println(result);
        if(!sign){
            return -(int)result;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        DivideTwoIntegers dt = new DivideTwoIntegers();
        System.out.println(dt.divide(10,3));
        System.out.println(dt.divide(7,-3));
        System.out.println(dt.divide(900,-1));
        System.out.println(dt.divide(-1,-1));
        System.out.println(dt.divide(-2147483648,-1));
    }
}
