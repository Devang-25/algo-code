package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class QueueReconstruction {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0){
            return people;
        }

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return Integer.compare(o2[1],o1[1]);
                }
                return Integer.compare(o1[0],o2[0]);
            }
        });


        for(int i=people.length-2;i>=0;i--){
            int [] curr = people[i];
            int j = i;
            while(j< i+curr[1]){
                people[j] = people[j+1];
                j++;
            }
            people[j] = curr;
        }

        return people;
    }

    public static void main(String[] args) {
        QueueReconstruction qc = new QueueReconstruction();
        int [][] inp = new int [][] {
                {7,0},
                {4,4},
                {7,1},
                {5,0},
                {6,1},
                {5,2}
        };

        qc.reconstructQueue(inp);
        for(int i=0;i<inp.length;i++){
            System.out.println(Arrays.toString(inp[i]));
        }
    }
}
