package leetcode.hard;

import java.util.TreeMap;

public class NumberOfAtoms {

    public String countOfAtoms(String formula){
        if(formula == null || formula.length() == 0){
            return "";
        }
        StringBuilder result = new StringBuilder();
        TreeMap<String, Integer> map = countOfAtomsUtil(formula);
        for(String key : map.keySet()){
            result.append(key).append(map.get(key) == 1?"":map.get(key));
        }

        return result.toString();
    }
    public TreeMap<String, Integer> countOfAtomsUtil(String formula){

        TreeMap<String, Integer> map = new TreeMap<>();
        String currAtom = "";
        int currAtomCnt = 0;
        int i = 0;
        while(i < formula.length()){
            char ch = formula.charAt(i);
            if(Character.isUpperCase(ch)){
                if(currAtom.length() > 0){
                    add(map,currAtom, currAtomCnt == 0 ? 1 : currAtomCnt);
                    currAtom = "";
                    currAtomCnt = 0;
                }
                currAtom += ch;
            }
            else if(Character.isLowerCase(ch)){
                currAtom += ch;
            }
            else if(Character.isDigit(ch)){
                currAtomCnt = currAtomCnt*10+(ch-'0');
            }
            else if(ch == '('){
                int cnt = 0;
                int start = i;
                int times = 0;
                if(currAtom.length() > 0){
                    add(map,currAtom, currAtomCnt == 0 ? 1 : currAtomCnt);
                    currAtom = "";
                    currAtomCnt = 0;
                }
                do{
                    if(formula.charAt(i) == '(') cnt++;
                    else if(formula.charAt(i) == ')') cnt--;
                    i++;
                }while(cnt > 0);

                String str = formula.substring(start+1,i-1);
                TreeMap<String, Integer> map2 = countOfAtomsUtil(str);

                while(i<formula.length() && Character.isDigit(formula.charAt(i))){
                    times = times*10+formula.charAt(i)-'0';
                    i++;
                }
                i--;
                addAll(map,map2,times);
            }
            i++;
        }

        if(currAtom.length() > 0){
            add(map,currAtom, currAtomCnt == 0 ? 1 : currAtomCnt);
        }
        return map;
    }

    private void add(TreeMap<String, Integer> map , String atom, int cnt){
        map.put(atom, map.getOrDefault(atom,0)+cnt);
    }

    private void addAll(TreeMap<String, Integer> map , TreeMap<String,Integer> map2, int multiplier){
        for(String key : map2.keySet() ){
            add(map, key, map2.get(key)*multiplier);
        }
    }
    public static void main(String[] args) {
        NumberOfAtoms na = new NumberOfAtoms();
//        System.out.println(na.countOfAtomsUtil("H2O"));
//        System.out.println(na.countOfAtomsUtil("H2O2He3Mg4"));
//        System.out.println(na.countOfAtoms("ON(SO3)2"));
//        System.out.println(na.countOfAtoms("K4(ON(SO3)2)2"));
        System.out.println(na.countOfAtomsUtil("((N42)24(OB40Li30CHe3O48LiNN26)33(C12Li48N30H13HBe31)21(BHN30Li26BCBe47N40)15(H5)16)14"));
    }
}
