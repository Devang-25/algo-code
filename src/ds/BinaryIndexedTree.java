package ds;

public class BinaryIndexedTree {
    int [] arr = null;
    BinaryIndexedTree(int n){
        this.arr = new int[n+1];
    }
    BinaryIndexedTree(int [] nums){
        this.arr = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            add(i,nums[i]);
        }
    }

    public void add(int ind, int val){
        ind += 1;
        while( ind < arr.length){
            arr[ind] += val;
            ind += (ind & (-ind));
        }
    }

    public int getSum(int ind){
        int sum = 0;
        ind = ind+1;
        while(ind > 0){
            sum += arr[ind];
            ind -= (ind & (-ind));
        }

        return sum;
    }

    public static void main(String[] args) {
        BinaryIndexedTree bit = new BinaryIndexedTree(new int[]{2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(bit.getSum(5));
        bit.add(3,6);
        System.out.println(bit.getSum(5));
    }
}
