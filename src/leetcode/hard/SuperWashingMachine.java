package leetcode.hard;

/**
 * Created by mns on 12/18/18.
 */
public class SuperWashingMachine {
    public int findMinMoves(int[] machines) {
        if(machines == null || machines.length == 0){
            return 0;
        }

        int sum = 0;
        for( int i : machines){
            sum += i;
        }
        if(sum % machines.length != 0){
            return -1;
        }

        int avg = sum/machines.length;
        int minCnt = 0;
        int balance = 0;
        for(int i : machines){
            balance += i-avg;
            minCnt = Math.max(minCnt, Math.max(i-avg, Math.abs(balance)));
        }

        return minCnt;
    }

    public static void main(String[] args) {
        SuperWashingMachine swm = new SuperWashingMachine();
        System.out.println(swm.findMinMoves(new int[] {0,6,5,1,6,0}));
    }
}
