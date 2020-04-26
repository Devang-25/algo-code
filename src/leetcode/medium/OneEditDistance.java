package leetcode.medium;

/**
 * Created by mns on 6/26/18.
 */
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t){
        if(Math.abs(s.length() - t.length()) >= 2){
            return false;
        }

        int i =0, j = 0;

        while(i < s.length() && j < t.length()){
            if(s.charAt(i) != t.charAt(j)) {
                return s.substring(i + 1).contentEquals(t.substring(j + 1))
                        || s.substring(i + 1).contentEquals(t.substring(j))
                        || s.substring(i).contentEquals(t.substring(j+1));
            }
            i++;
            j++;
        }

        return i==s.length()-1 || j==t.length()-1;
    }

    public static void main(String[] args) {
        OneEditDistance oe = new OneEditDistance();
        System.out.println(oe.isOneEditDistance("1203","12113"));
        System.out.println(oe.isOneEditDistance("",""));
    }
}
