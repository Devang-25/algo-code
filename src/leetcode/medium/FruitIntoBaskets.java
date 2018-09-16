package leetcode.medium;

import java.util.HashMap;

public class FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        int i =0 , j = 0;

        int max = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(j<tree.length){
            while(j <tree.length && map.size() <= 2){
                map.put(tree[j],map.getOrDefault(tree[j],0)+1);
                if(map.size() <= 2){
                    max = Math.max(max, j-i+1);
                }
                j++;
            }
            if(j == tree.length){
                return max;
            }

            while(map.size() > 2){
                map.put(tree[i],map.get(tree[i])-1);
                if(map.get(tree[i]) == 0){
                    map.remove(tree[i]);
                }
                i++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        FruitIntoBaskets fib = new FruitIntoBaskets();
        System.out.println(fib.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
        System.out.println(fib.totalFruit(new int[]{1,2,1}));
        System.out.println(fib.totalFruit(new int[]{0,1,2,2}));
        System.out.println(fib.totalFruit(new int[]{1,2,3,2,2}));
        System.out.println(fib.totalFruit(new int[]{1,0,2,1,3,1,2,1}));
    }
}
