package leetcode.easy;

public class ShiftingLetters {
    public String shiftingLetters(String S, int [] shifts){
        StringBuilder sb = new StringBuilder(S);

        int aggShifts = 0;
        for(int i=S.length()-1;i>=0;i--){
            aggShifts = (aggShifts +shifts[i])%26;
            int next = sb.charAt(i) + aggShifts;
            int ch = next > 'z' ? 'a' + ( next - 'z' - 1)
                    : next;
            sb.setCharAt(i,(char)(ch));
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        ShiftingLetters sl = new ShiftingLetters();
        System.out.println(sl.shiftingLetters("abc", new int []{3,5,9}));
        System.out.println(sl.shiftingLetters("ruu", new int []{26,9,17}));
        System.out.println(sl.shiftingLetters("bad", new int []{10,20,30}));
        System.out.println(sl.shiftingLetters("zvhez", new int []{10,16,10,26,26}));
    }


}
