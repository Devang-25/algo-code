package leetcode;

import java.util.TreeMap;

public class MedianFinder {

    TreeMap<Integer,Integer> treeMap; // Treemap doesn't allow duplicates
    int size;
    public MedianFinder(){
        this.treeMap = new TreeMap<>();
        this.size = 0;
    }

    public void addNum(int num) {
        if (treeMap.get(num) == null){
            treeMap.put(num,1);
        }else{
            treeMap.put(num,treeMap.get(num)+1);
        }

        this.size++;
    }

    public double findMedian() {

        if(size > 0){
            if(size % 2 == 0){
                int midIndex = size/2 - 1;
                int currentIndex = -1;
                double tot = 0.0;
                boolean foundOne = false;

                for(Integer key : treeMap.keySet()){
                    int cnt = treeMap.get(key);
                    if(foundOne){
//                        System.out.println("The two middle elements are " + tot + " " + key);
                        tot+= key;

                        return tot/2.0;
                    }

                    if(cnt + currentIndex > midIndex){
                        return key;
                    }else if(cnt +currentIndex == midIndex){
                        tot+= key;
                        foundOne = true;
                    }else{
                        currentIndex += cnt;
                    }

                }


            }else{

                int midIndex = size/2;
                int currentIndex = -1;

                for(Integer key : treeMap.keySet()){
                    int cnt = treeMap.get(key);
                    if(cnt + currentIndex >= midIndex){
//                        System.out.println("The middle element is " + key);
                        return key;
                    }else{
                        currentIndex += cnt;
                    }

                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
//        mf.addNum(6);
//        System.out.println(mf.findMedian());
//        mf.addNum(10);
//        System.out.println(mf.findMedian());
//        mf.addNum(2);
//        System.out.println(mf.findMedian());
//        mf.addNum(6);
//        System.out.println(mf.findMedian());
//        mf.addNum(5);
//        System.out.println(mf.findMedian());
//        mf.addNum(0);
//        System.out.println(mf.findMedian());
//        mf.addNum(6);
//        System.out.println(mf.findMedian());
//        mf.addNum(3);
//        System.out.println(mf.findMedian());
//        mf.addNum(1);
//        System.out.println(mf.findMedian());
//        mf.addNum(0);
//        System.out.println(mf.findMedian());
//        mf.addNum(0);
//        System.out.println(mf.findMedian());

        mf.addNum(-1);
        System.out.println(mf.findMedian());
        mf.addNum(-2);
        System.out.println(mf.findMedian());
        mf.addNum(-3);
        System.out.println(mf.findMedian());
        mf.addNum(-4);
        System.out.println(mf.findMedian());
        mf.addNum(-5);
        System.out.println(mf.findMedian());

        //2 5 6 6 10
    }

}
