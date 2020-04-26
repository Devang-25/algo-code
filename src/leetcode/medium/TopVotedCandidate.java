package leetcode.medium;
import java.util.TreeMap;

public class TopVotedCandidate {

    private TreeMap<Integer,Integer> map ;
    public TopVotedCandidate(int[] persons, int[] times) {
        int [] cnt = new int[5000];
        map = new TreeMap<>();
        if( persons.length > 0) {
            cnt[persons[0]]++;
            map.put(times[0], persons[0]);
            int maxSoFar = persons[0];
            for (int i = 1; i < times.length; i++) {
                cnt[persons[i]]++;
                if(cnt[maxSoFar] <= cnt[persons[i]]){
                    maxSoFar = persons[i];
                    map.put(times[i], maxSoFar);
                }
            }
        }
    }

    public int q(int t) {
        Integer closestTime = map.floorKey(t);
        if(closestTime != null){
            return map.get(closestTime);
        }
        return -1;
    }

    public static void main(String[] args) {
        TopVotedCandidate tvc = new TopVotedCandidate(new int[]{0,1,1,0,0,1,0}, new int[]{0,5,10,15,20,25,30});
        int q [] = new int[] {3,12,25,15,24,8};
        for(int i : q){
            System.out.println(tvc.q(i));
        }
        tvc = new TopVotedCandidate(new int [] {0,0,0,0,1}, new int[] {0,6,39,52,75} );
        q = new int[] {45,49,59,68,42,37,99,26,78,43};
        for(int i : q) {
            System.out.println(tvc.q(i));
        }
        tvc = new TopVotedCandidate(new int [] {0,0,1,1,2}, new int[] {0,67,69,74,87} );
        q = new int[] {4,62,100,88,70,73,22,75,29,10};
        for(int i : q) {
            System.out.println(tvc.q(i));
        }
    }
}
