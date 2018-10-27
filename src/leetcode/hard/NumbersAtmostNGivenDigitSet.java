package leetcode.hard;

public class NumbersAtmostNGivenDigitSet {
    public int atMostNGivenDigitSet(String[] D, int N) {
        String s = Integer.toString(N);
        int l = s.length();
        int res = 0;
        for(int i=1;i < l;i++){
            int x = D.length;
            for(int j=1;j<i;j++){
                x *= D.length;
            }
            res += x;
        }


        for(int i=0;i<l;i++){
            boolean flag = false;
            int a = 0;
            for(int j=0;j<D.length;j++){
                if(Integer.parseInt(D[j]) < s.charAt(i)-'0'){
                    a++;
                }else if(Integer.parseInt(D[j]) == s.charAt(i)-'0'){
                    flag = true;
                    if(i == l-1){
                        a++;
                    }
                }
            }
            res += a*Math.pow(D.length,l-i-1);
            if(!flag){
                break;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        NumbersAtmostNGivenDigitSet na = new NumbersAtmostNGivenDigitSet();
        System.out.println(na.atMostNGivenDigitSet(new String[]{"1","4","9"},1000000000));
        System.out.println(na.atMostNGivenDigitSet(new String[]{"1","3","4","7"},100));
        System.out.println(na.atMostNGivenDigitSet(new String[]{"3","4","7"},1));
        System.out.println(na.atMostNGivenDigitSet(new String[]{"1","3","5","7","8","6"},11899));
    }
}
