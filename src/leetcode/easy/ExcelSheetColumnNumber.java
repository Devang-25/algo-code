package easy;

/**
 * Created by mns on 8/9/18.
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int num = 0, len = s.length();
        for(int i=0;i<len;i++){
            num += Math.pow(26,len-i-1) * (s.charAt(i) - 'A' + 1);
        }

        return num;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber sc = new ExcelSheetColumnNumber();
        System.out.println(sc.titleToNumber("ZXZ"));
        System.out.println(sc.titleToNumber("AA"));
    }
}
