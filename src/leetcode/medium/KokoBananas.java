package leetcode.medium;

public class KokoBananas {
    public int minEatingSpeed(int[] piles, int H) {
        int min = 1, max = 1000000000;
        int mid;
        while(min != max){
            mid = min + (max-min)/2;
            boolean possible = canEat(piles,H,mid);
            if(possible){
                max = mid;
            }else{
                min = mid+1;
            }
        }
        return max;
    }

    private boolean canEat(int [] piles,int H, int mid){
        int totalHrs = 0;
        for(int i=0;i<piles.length;i++){
            totalHrs += (piles[i]/mid);
            if(piles[i]%mid != 0)
                totalHrs++;
            if(totalHrs > H){
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        KokoBananas k = new KokoBananas();
        System.out.println(k.minEatingSpeed(new int[]{3,6,7,11},8));
        System.out.println(k.minEatingSpeed(new int[]{30,11,23,4,20},6));
    }
}
