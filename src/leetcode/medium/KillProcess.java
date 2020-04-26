package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by mns on 7/12/18.
 */
public class KillProcess {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, Set<Integer>> adjMap = new HashMap<>();
        for(int i=0;i<ppid.size();i++){
            Set<Integer> children = adjMap.get(ppid.get(i));
            if(children == null){
                children = new HashSet<>();
                adjMap.put(ppid.get(i),children);
            }
            children.add(pid.get(i));
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> result=  new ArrayList<>();
        q.add(kill);
        while(!q.isEmpty()){
            int front = q.poll();
            result.add(front);
            if(adjMap.containsKey(front)){
                q.addAll(adjMap.get(front));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        KillProcess kp = new KillProcess();
        kp.killProcess(Arrays.asList(1, 3, 10, 5),Arrays.asList(3, 0, 5, 3),5).stream().forEach(System.out::println);
    }
}
