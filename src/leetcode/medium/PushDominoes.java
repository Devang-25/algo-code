/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

/**
 *
 * @author sekha
 */
public class PushDominoes {

    public String pushDominoes(String dominoes) {
        if (dominoes == null || dominoes.length() <= 1) {
            return dominoes;
        }

        int l = 0, r = 0;
        StringBuilder result = new StringBuilder(dominoes);
        while (r < dominoes.length()) {
            while (r < dominoes.length() && dominoes.charAt(r) == '.') {
                r++;
            }

            if (r >= dominoes.length()) {
                if (dominoes.charAt(l) == 'R') {
                    for (int i = l; i < dominoes.length(); i++) {
                        result.setCharAt(i, 'R');
                    }
                }
                break;
            }

            if ((dominoes.charAt(l) == '.' || dominoes.charAt(l) == 'L') && dominoes.charAt(r) == 'L') {
                for (int i = l; i <= r; i++) {
                    result.setCharAt(i, 'L');
                }
                l = r++;
            } else if ((dominoes.charAt(l) == '.' || dominoes.charAt(l) == 'L') && dominoes.charAt(r) == 'R') {
                l = r++;
            } else if (dominoes.charAt(l) == 'R' && dominoes.charAt(r) == 'R') {
                for (int i = l; i <= r; i++) {
                    result.setCharAt(i, 'R');
                }
                l = r++;
            } else if (dominoes.charAt(l) == 'R' && dominoes.charAt(r) == 'L') {
                int lengthInBetween = r - l - 1;
                for(int i=l,j=r;i<=l+lengthInBetween/2;i++,j--){
                    result.setCharAt(i,'R');
                    result.setCharAt(j, 'L');
                }
                l = r++;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        PushDominoes pd = new PushDominoes();
        System.out.println(pd.pushDominoes(".L.R...LR..R.."));
        System.out.println(pd.pushDominoes("..."));
        System.out.println(pd.pushDominoes("LL"));
        System.out.println(pd.pushDominoes("R"));
        System.out.println(pd.pushDominoes("L............R"));
        System.out.println(pd.pushDominoes("R............L"));
        System.out.println(pd.pushDominoes("R.............L"));
    }
}
