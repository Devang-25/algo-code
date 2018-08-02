package leetcode.hard;

public class NthMagicalNumber {
    public int nthMagicalNumber(int N, int A, int B) {
        long l = Math.min(A,B), r = Long.MAX_VALUE;
        long lcm = (A*B)/gcd(A,B);
        //System.out.println(lcm);
        while(l < r){
            long mid = (l+r)/2;
            long x = (mid/A) + (mid/B) - (mid/lcm);
            //System.out.println(l + " " + r +" " +mid + " " + (mid/A) + " "+ (mid/B) + " " + x );
            if(x < N){
                l = mid+ 1;
            }else if(x > N){
                r = mid;
            }else{
                if(mid % A != 0 && mid % B != 0){
                    mid -= Math.min((mid%A),(mid%B));
                }
//                while(mid % A != 0 && mid % B != 0){
//                    mid--;
//                }
                return (int)(mid%1000000007);
            }
        }

        return -1;
    }

    long gcd(long a, long b)
    {
        if (a == 0 || b == 0)
            return 0;

        if (a == b)
            return a;

        if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a);
    }
    public static void main(String[] args) {
        NthMagicalNumber nmg = new NthMagicalNumber();
//        System.out.println(nmg.nthMagicalNumber(1,2,3));
//        System.out.println(nmg.nthMagicalNumber(4,2,3));
//        System.out.println(nmg.nthMagicalNumber(5,2,4));
//        System.out.println(nmg.nthMagicalNumber(3,6,4));
//        System.out.println(nmg.nthMagicalNumber(10,9,4));
        System.out.println(nmg.nthMagicalNumber(8,10,5));
    }
}
