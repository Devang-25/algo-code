package leetcode.easy;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while(i < j){
            while(i<s.length() && !isAlphaNumberic(s.charAt(i))){
                i++;
            }
            while(j >=0 && !isAlphaNumberic(s.charAt(j))){
                j--;
            }
            if(i <j){
                if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                    return false;
                }
            }
            i++;j--;
        }

        return true;
    }
    boolean isAlphaNumberic(char ch){
       return Character.isAlphabetic(ch) || Character.isDigit(ch);
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(vp.isPalindrome("race a car"));
        System.out.println(vp.isPalindrome(".,"));
    }

}
