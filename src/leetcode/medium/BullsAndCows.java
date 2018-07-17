package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                if (numbers[secret.charAt(i)-'0']++ < 0) cows++;
                if (numbers[guess.charAt(i)-'0']-- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }

    public String getHint2(String secret, String guess) {
        HashMap<Character,HashSet<Integer>> mapS = new HashMap<>();
        HashMap<Character,HashSet<Integer>> mapG = new HashMap<>();
        for(int i=0;i<secret.length();i++){
            HashSet<Integer> pos = mapS.get(secret.charAt(i));
            if(pos == null){
                pos = new HashSet<>();
                mapS.put(secret.charAt(i),pos);
            }
            pos.add(i);
        }
        for(int i=0;i<guess.length();i++){
            HashSet<Integer> pos = mapG.get(guess.charAt(i));
            if(pos == null){
                pos = new HashSet<>();
                mapG.put(guess.charAt(i),pos);
            }
            pos.add(i);
        }
        int bulls = 0, cows = 0;

        for(Character c : mapS.keySet()){
            HashSet<Integer> posS = mapS.get(c);
            HashSet<Integer> posG = mapG.get(c);
            if(posG != null) {
                ArrayList<Integer> posG2 = new ArrayList<>(posG);
                for (Integer i : posG2) {
                    if (posS.contains(i)) {
                        posS.remove(i);
                        posG.remove(i);
                        bulls++;
                    }
                }
                cows += Math.min(posG.size(), posS.size());
            }

        }

        return bulls+"A"+cows+"B";
    }

    public static void main(String[] args) {
        BullsAndCows bc = new BullsAndCows();
        System.out.println(bc.getHint("1123","0111"));
        System.out.println(bc.getHint("1121111","1111111"));
        System.out.println(bc.getHint("11","10"));
    }
}
