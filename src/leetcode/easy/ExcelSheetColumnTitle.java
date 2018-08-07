package leetcode.easy;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n>0){
            n-=1;
            sb.append((char)('A'+(n%26)));
            n = n/26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle ec = new ExcelSheetColumnTitle();
        System.out.println(ec.convertToTitle(1));
        System.out.println(ec.convertToTitle(28));
        System.out.println(ec.convertToTitle(701));
        System.out.println(ec.convertToTitle(234552));
    }
}
