package medium;

/**
 * Created by mns on 8/23/18.
 */
public class MyPow {
    public double pow(double x, int n) {
        if(n == 0)
            return 1;
        if(n<0){
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);
    }

    public static void main(String[] args) {
        MyPow mp = new MyPow();
        System.out.println(mp.pow(10,3));
        System.out.println(mp.pow(10,-2));
    }
}
