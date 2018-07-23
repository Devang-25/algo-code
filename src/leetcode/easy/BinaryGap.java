package leetcode.easy;

public class BinaryGap {
    public int binaryGap(int N) {
        String b = Integer.toBinaryString(N);
        int maxLength = 0,left=0,right;
        while(left < b.length() && b.charAt(left) == '0') left++;

        for(right = left+1;right <b.length();right++){
            if(b.charAt(right) == '1'){
                maxLength = Math.max(maxLength, right-left);
                left = right;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        BinaryGap bg = new BinaryGap();
        System.out.println(bg.binaryGap(6));
        System.out.println(bg.binaryGap(8));
        System.out.println(bg.binaryGap(5));
    }
}
