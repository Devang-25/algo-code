package leetcode.easy;

/**
 * Created by mns on 6/28/18.
 */
public class HammingDistance {
    public int hammingDistance(int x, int y){
        int xor = x ^ y;
        int count = 0;
        for(int i=0;i<Integer.BYTES*8;i++){
            count += (xor >> i)&1;
        }

        return count;
    }

    public static void main(String[] args) {
        HammingDistance hd = new HammingDistance();
        System.out.println(hd.hammingDistance(1,4));
    }
}
