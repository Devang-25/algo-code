package ds;

public class BinaryIndexedTree {
    int [] arr = null;
    BinaryIndexedTree(int n){
        this.arr = new int[n+1];
    }
    BinaryIndexedTree(int [] nums){
        this.arr = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            add(i+1,nums[i]);
        }
    }

    public void add(int ind, int val){
        while( ind < arr.length){
            System.out.println("Adding to index " + ind + " " + Integer.toBinaryString(ind));
            arr[ind] += val;
            System.out.println(ind & -ind);
            ind += (ind & (-ind));;
        }
        print();
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

    public void print(){
        for(int i : arr){
            System.out.print(i + ", ");
        }
    }

    public static void main(String[] args) {
        BinaryIndexedTree bit = new BinaryIndexedTree(new int[]{2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9});
       System.out.println(bit.getSum(5));
       bit.add(3,6);
       System.out.println(bit.getSum(5));
    }
}
