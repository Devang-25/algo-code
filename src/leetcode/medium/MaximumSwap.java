package leetcode.medium;

import java.util.PriorityQueue;

public class MaximumSwap {
    public int maximumSwap(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> {
            if(a[0] == b[0]){
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });
        for(int i=0;i<sb.length();i++){
            pq.add(new int[]{sb.charAt(i)-'0',i});
        }

        for(int i=0;i< sb.length();i++){
            int [] top = pq.poll();
            if(top[1] == i){
                continue;
            }else{
                while(!pq.isEmpty() && pq.peek()[0] == top[0]){
                    top = pq.poll();
                }
                Character temp = sb.charAt(top[1]);
                sb.setCharAt(top[1],sb.charAt(i));
                sb.setCharAt(i,temp);
                break;
            }
        }

        return Integer.parseInt(sb.toString());
    }
    

    public static void main(String[] args) {
        MaximumSwap ms = new MaximumSwap();
        System.out.println(ms.maximumSwap(9973));
        System.out.println(ms.maximumSwap(2736));
        System.out.println(ms.maximumSwap(1));
        System.out.println(ms.maximumSwap(98368));
        System.out.println(ms.maximumSwap(1993));
    }
}
