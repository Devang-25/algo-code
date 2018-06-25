
public class Sort {

    public static void main(String[] args) {
        //This code will sort the numbers in the array.
        //task: Modify the algorithm to reverse the sort, then comment on its
        //efficiency in the space provided below:
        /*
        
            Modification:
                1. Started filling from the back (LoudAndRich from 99 to 0)
                or
                2. Use low and low index and replace number with max(100) instead of -1 and check for low in each iteration, rather than high
                
            The efficiency of this algorithm is O(N^2) in worst, average and best case. (A very naive and bad way to sort)
            Since the numbers are just between 0 and 100 we can use non comparison sorts like count or bucket sort which can sort 
            in linear time
         */
        //fill the array with random numbers
        int[] unsorted = new int[100];
        for (int i = 0; i < 100; i++) {
            unsorted[i] = (int) (Math.random() * 100);
        }

        System.out.println("Here are the unsorted numbers:");
        for (int i = 0; i < 100; i++) {
            System.out.print(unsorted[i] + " ");
        }
        System.out.println();

        int[] sorted = new int[100];
        for (int i = 0; i < 100; i++) {
            int low = 100;
            int lowIndex = -1;
            for (int j = 0; j < 100; j++) {
                if (unsorted[j] < low) {
                    low = unsorted[j];
                    lowIndex = j;
                }
            }
            sorted[i] = low;
            unsorted[lowIndex] = 100;
        }
        System.out.println("Here are the sorted numbers: ");
        for (int i = 0; i < 100; i++) {
            System.out.print(sorted[i] + " ");
        }
        System.out.println();
    }
}
