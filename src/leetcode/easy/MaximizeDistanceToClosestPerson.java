package leetcode.easy;

public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int [] seats){

        int [] lefts = new int [seats.length];
        int [] rights = new int [seats.length];

        int left = Integer.MIN_VALUE+1;
        int right = Integer.MAX_VALUE-1;
        for(int i=0;i<seats.length;i++){
            lefts[i] = left;
            if(seats[i] == 1){
                left = i;
            }
        }
        for(int i=seats.length-1;i >= 0;i--){
            rights[i] = right;
            if(seats[i] == 1){
                right = i;
            }
        }

        int max = 0;
        for(int i=0;i<seats.length;i++){
            if(seats[i] == 0)
                max = Math.max(max, Math.min(i-lefts[i],rights[i]-i));
        }

        return max;
    }

    public static void main(String[] args) {
        MaximizeDistanceToClosestPerson m = new MaximizeDistanceToClosestPerson();
        System.out.println(m.maxDistToClosest(new int []{0,0,0,0,1,0,1}));
    }
}
