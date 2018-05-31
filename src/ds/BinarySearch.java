package ds;

/**
 * Created by mns on 5/9/18.
 */
public class BinarySearch {
    public static int findFirst(int [] arr, int num){
        int left = 0;
        int right = arr.length-1;
        int pos = -1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(arr[mid] >= num){
                if(arr[mid] == num){
                    pos = mid;
                }
                right = mid - 1;
            }else{
                left = mid+1;
            }
        }

        return pos;
    }

    public static int findLast(int [] arr, int num){
        int left = 0;
        int right = arr.length-1;
        int pos = -1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(arr[mid] <= num){
                if(arr[mid] == num){
                    pos = mid;
                }
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return pos;
    }

    /** Smallest number greater than or equal to the given number */
    public static int findCeil(int [] arr, int num){
        int left = 0;
        int right = arr.length-1;
        int pos = -1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(arr[mid] == num){
                return mid;
            }else if(arr[mid] > num){
                pos = mid;
                right = mid - 1;
            }else{
                left = mid+1;
            }
        }

        return pos;
    }

    /** Smallest number greater than or equal to the given number */
    public static int findHigher(int [] arr, int num){
        int left = 0;
        int right = arr.length-1;
        int pos = -1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(arr[mid] > num){
                if(arr[mid] > num) {
                    pos = mid;
                }
                right = mid - 1;
            }else{
                left = mid+1;
            }
        }

        return pos;
    }

    /** Largest number lesser than or equal to the given number */
    public static int findFloor(int [] arr, int num){
        int left = 0;
        int right = arr.length-1;
        int pos = -1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(arr[mid] == num){
                return mid;
            }else if(arr[mid] > num){
                right = mid - 1;
            }else{
                pos = mid;
                left = mid+1;
            }
        }

        return pos;
    }

    /** Largest number lesser than the given number */
    public static int findLower(int [] arr, int num){
        int left = 0;
        int right = arr.length-1;
        int pos = -1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(arr[mid] >= num){
                right = mid - 1;
            }else{
                if(arr[mid] < num) {
                    pos = mid;
                }
                left = mid+1;
            }
        }

        return pos;
    }

    /** **/

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        System.out.println(BinarySearch.findFirst(new int[] {0,0,0,1,1,2},2));
        System.out.println(BinarySearch.findLast(new int[] {0,0,0,1,1,2},2));
        System.out.println(BinarySearch.findLast(new int[] {0,0,0,1,1,2},1));
        System.out.println(BinarySearch.findLast(new int[] {0},0));
        System.out.println(BinarySearch.findCeil(new int[] {0},-1));
        System.out.println(BinarySearch.findCeil(new int[] {1,1,1,2,2,2,3,4,5,5,5,6},2));
        System.out.println(BinarySearch.findCeil(new int[] {1,1,1,2,2,2,3,4,5,5,5,7},6));

        System.out.println(BinarySearch.findFloor(new int[] {1,1,1,2,2,2,3,4,5,5,5,7},8));
        System.out.println(BinarySearch.findFloor(new int[] {1,1,1,2,2,2,3,4,5,5,5,7},-100));

        System.out.println(BinarySearch.findHigher(new int[] {0,0,0,1,1,2},2));
        System.out.println(BinarySearch.findHigher(new int[] {0,0,0,1,1,2},0));
        System.out.println(BinarySearch.findHigher(new int[] {0,0},0));
        System.out.println(BinarySearch.findLower(new int[] {0,0,0,1,1,2},1));
        System.out.println(BinarySearch.findLower(new int[] {0,0},0));

    }
}
