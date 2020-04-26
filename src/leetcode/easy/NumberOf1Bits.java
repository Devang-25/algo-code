package leetcode.easy;

/**
 * Created by mns on 6/28/18.
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        NumberOf1Bits n1b = new NumberOf1Bits();
        System.out.println(n1b.hammingWeight(2));
    }
}
