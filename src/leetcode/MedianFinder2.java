import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder2 {
    PriorityQueue<Integer> firstHalf = null;
    PriorityQueue<Integer> secondHalf = null;

    int size;

    public MedianFinder2(){
        secondHalf = new PriorityQueue<>();
        firstHalf = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        this.size = 0;
    }

    public void addNum(int num) {
        if(secondHalf.size() > 0 && num >= secondHalf.peek()){
            secondHalf.offer(num);
        }else {
            firstHalf.offer(num);
        }


        if(firstHalf.size() > secondHalf.size()){
            secondHalf.offer(firstHalf.poll());
        }else if(firstHalf.size() < secondHalf.size()){
            firstHalf.offer(secondHalf.poll());
        }

//        System.out.print(firstHalf.toString() + " " + firstHalf.peek());
//        System.out.print(secondHalf.toString()+ " " + secondHalf.peek());
//        System.out.println();
        size++;
    }

    public double findMedian() {

        if(size > 0){
            if(size % 2 == 0){
                if(firstHalf.size() == secondHalf.size()){
                    return ( firstHalf.peek() + secondHalf.peek() ) / 2.0;
                }
            }else{
                return firstHalf.size() > secondHalf.size()? firstHalf.peek():secondHalf.peek();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        MedianFinder2 mf = new MedianFinder2();
        mf.addNum(6);
        System.out.println(mf.findMedian());
        mf.addNum(10);
        System.out.println(mf.findMedian());
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(6);
        System.out.println(mf.findMedian());
        mf.addNum(5);
        System.out.println(mf.findMedian());
        mf.addNum(0);
        System.out.println(mf.findMedian());
        mf.addNum(6);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
        mf.addNum(1);
        System.out.println(mf.findMedian());
        mf.addNum(0);
        System.out.println(mf.findMedian());
        mf.addNum(0);
        System.out.println(mf.findMedian());

//        mf.addNum(-1);
//        System.out.println(mf.findMedian());
//        mf.addNum(-2);
//        System.out.println(mf.findMedian());
//        mf.addNum(-3);
//        System.out.println(mf.findMedian());
//        mf.addNum(-4);
//        System.out.println(mf.findMedian());
//        mf.addNum(-5);
//        System.out.println(mf.findMedian());

        //2 5 6 6 10
    }
}
