import java.util.Arrays;

public class LISNumber {

    public int findNumberOfLCS(int [] nums){
        if(nums != null && nums.length > 0){

            int [] maxLengthEndingHere = new int[nums.length];
            int [] numWays = new int[nums.length];

            Arrays.fill(maxLengthEndingHere,1);
            Arrays.fill(numWays,1);

            int max = 1;

            for(int i=1;i<nums.length;i++){
                int j = i-1;
                while(j >=0){
                    if(nums[i] > nums[j]){
                        if(maxLengthEndingHere[j]+1 > maxLengthEndingHere[i]){
                            maxLengthEndingHere[i] = maxLengthEndingHere[j]+1;
                            numWays[i] = numWays[j];

                            if(maxLengthEndingHere[i] > max){
                                max = maxLengthEndingHere[i];
                            }
                        }else if(maxLengthEndingHere[j]+1 == maxLengthEndingHere[i]){
                            numWays[i] += numWays[j];
                        }
                    }
                    j--;
                }
            }

            int maxOverallCount = 0;
            for(int i=0;i<nums.length;i++){
                if(maxLengthEndingHere[i] == max){
                    maxOverallCount += numWays[i];
                }
            }
            return maxOverallCount;

        }else{
            return 0;
        }
    }


    public static void main(String[] args) {
        LISNumber l = new LISNumber();
        System.out.println(l.findNumberOfLCS(new int[] {1,3,5,4,7}));
        System.out.println(l.findNumberOfLCS(new int[] {2,2,2,2,2}));
    }
}
