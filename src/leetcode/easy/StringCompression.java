package leetcode.easy;

public class StringCompression {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        int i = 0, j = 0;
        while (j < chars.length) {
            char currChar = chars[j];
            int currCharCount = 0;
            while (j < chars.length && chars[j] == currChar) {
                j++;
                currCharCount++;
            }
            chars[i++] = currChar;
            if(currCharCount > 1) {
                int digits = (int) Math.floor(1 + Math.log10(currCharCount));
                int k = i + digits - 1;
                while (k >= i) {
                    chars[k] = (char) (currCharCount % 10 + '0');
                    currCharCount /= 10;
                    k--;
                }
                i = i + digits;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        StringCompression sc = new StringCompression();
        System.out.println(sc.compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        System.out.println(sc.compress(new char[]{'a', 'a', 'a', 'a', 'a', 'a'}));
        System.out.println(sc.compress(new char[]{'a'}));
    }
}
