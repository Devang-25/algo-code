package dsalgo.dp;

import java.util.HashMap;

public class ProfitableSchemes {
    private int MOD = 1000000007;
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        //HashMap<String,Integer> cache = new HashMap<>();
        //return util(G,P,0,group,profit, cache);
        Integer[][][] cache = new Integer[group.length][G + 1][P + 1];
        return util(G,P,0,group,profit,cache);
    }

    private int util(int g, int p, int ind, int [] group, int [] profit, HashMap<String,Integer> cache){
        if(ind == group.length){
            if(p<=0){
                return 1;
            }
            return 0;
        }

        if(p < 0){
            p = 0;
        }
        String key = g + " " + p + " " + ind;
        if(cache.get(key) != null){
            return cache.get(key);
        }

        int x = 0, y ;
        if(group[ind] <= g){
            x = util(g-group[ind], p-profit[ind], ind+1, group, profit,cache)%MOD;
        }
        y = util(g,p,ind+1,group,profit,cache)%MOD;
        cache.put(key, x+y);
        return cache.get(key);
    }

    private int util(int g, int p, int ind, int [] group, int [] profit, Integer [][][] cache){
        if(ind == group.length){
            if(p<=0){
                return 1;
            }
            return 0;
        }

        if(p < 0){
            p = 0;
        }
        if (cache[ind][g][p] != null) return cache[ind][g][p];

        int x = 0, y ;
        if(group[ind] <= g){
            x = util(g-group[ind], p-profit[ind], ind+1, group, profit,cache)%MOD;
        }
        y = util(g,p,ind+1,group,profit,cache)%MOD;
        cache[ind][g][p] = (x+y)%MOD;
        return cache[ind][g][p];
    }

    public static void main(String[] args) {
        ProfitableSchemes ps = new ProfitableSchemes();
        System.out.println(ps.profitableSchemes(5,3,new int[]{2,2,2,3,2}, new int[]{2,3,3,2,3}));
        System.out.println(ps.profitableSchemes(10,5,new int[]{2,3,5}, new int[]{6,7,8}));
    }
}
