package leetcode.easy;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int [] change = new int[]{0,0,0};

        for(int i=0;i<bills.length;i++){
            if(bills[i]== 10){
                if(change[0] ==0){
                    return false;
                }else{
                    change[1]++;
                    change[0]--;
                }
            }else if(bills[i] == 20 ){
                if((change[1] == 0 && change[0] <=2) || change[0] == 0){
                    return false;
                }else{
                    if(change[1] == 0){
                        change[0] -= 3;
                    }else{
                        change[1]--;
                        change[0]--;
                    }
                    change[2]++;
                }
            }else{
                change[0]++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LemonadeChange lm = new LemonadeChange();
        System.out.println(lm.lemonadeChange(new int[]{5,5,10}));
        System.out.println(lm.lemonadeChange(new int[]{10,10}));
        System.out.println(lm.lemonadeChange(new int[]{5,5,5,10,20}));
        System.out.println(lm.lemonadeChange(new int[]{5,5,5,5,20,20,5,5,20,5}));
        System.out.println(lm.lemonadeChange(new int[]{5,5,20,5,5,10,5,10,5,20}));
    }
}
