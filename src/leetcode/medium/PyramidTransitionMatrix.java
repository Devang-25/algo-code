package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PyramidTransitionMatrix {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        if(bottom == null || bottom.length() == 0){
            return false;
        }

        HashMap<String, ArrayList<String>> prefixMap = new HashMap<>();
        for(String s : allowed){
            String prefix = s.charAt(0)+""+s.charAt(1);
            ArrayList<String> l = prefixMap.get(prefix);
            if( l == null){
                l = new ArrayList<>();
                prefixMap.put(prefix,l);
            }
            l.add(s);
        }

        return util(bottom,prefixMap);

    }

    private boolean util(String bottom , HashMap<String,ArrayList<String>> map){
        if(bottom.length() == 1){
            return true;
        }

        ArrayList<String> bottoms = new ArrayList<>();
        getBottoms(bottom,new StringBuilder(),0,bottoms,map);
        if(bottoms.size() == 0){
            return false;
        }

        for(String s : bottoms){
            if(util(s,map)){
                return true;
            }
        }

        return false;
    }

    private void getBottoms(String bottom,StringBuilder sb, int index, ArrayList<String> result,
                            HashMap<String,ArrayList<String>> map){
        if(index == bottom.length()-1){
            result.add(sb.toString());
            return;
        }
        ArrayList<String> list = map.get(bottom.charAt(index)+""+bottom.charAt(index+1));
        if (list != null){
            for(String s : list){
                sb.append(s.charAt(2));
                getBottoms(bottom,sb,index+1,result,map);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        PyramidTransitionMatrix p = new PyramidTransitionMatrix();
        System.out.println(p.pyramidTransition("XYZ", Arrays.asList(new String[]{"XYD", "YZE", "DEA", "FFF"})));
    }
}
