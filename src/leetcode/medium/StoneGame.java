package leetcode.medium;

public class StoneGame {
    public boolean stoneGame(int[] piles) {
        return stoneGameUtil(piles,0,0,0,0,true);
    }

    private boolean stoneGameUtil(int [] piles, int left , int right, int a, int l, boolean turn) {
        if(left == right){
            if(turn){
                return a+piles[left] > l;
            }else{
                return a > l+piles[left];
            }
        }

        if(piles[left] == piles[right]){
            int pile = piles[left];
            if(turn){
                a+=pile;
            }else{
                l+=pile;
            }
            return stoneGameUtil(piles,left+1,right,a,l,!turn) || stoneGameUtil(piles,left,right-1,a,l,!turn);
        }else{
            int pile = piles[left] > piles[right]? piles[left++]: piles[right--];
            if(turn){
                a+=pile;
            }else{
                l+=pile;
            }
            return stoneGameUtil(piles,left,right,a,l,!turn);
        }

    }

    public static void main(String[] args) {
        StoneGame sg = new StoneGame();
        System.out.println(sg.stoneGame(new int[]{5,3,4,5}));
    }

}
