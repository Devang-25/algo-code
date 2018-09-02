package hard;

import java.util.LinkedHashMap;

/**
 * Created by mns on 8/8/18.
 */
public class IntegerToEnglishWords2 {
    private static final int[] IM = {1000000000, 1000000, 1000, 100, 90, 80, 70, 60, 50, 40, 30, 20, 19, 18, 17, 16, 15, 14,13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    private static final String[] SM = {"Billion", "Million", "Thousand", "Hundred", "Ninety", "Eighty", "Seventy", "Sixty", "Fifty", "Forty", "Thirty", "Twenty", "Nineteen", "Eighteen", "Seventeen", "Sixteen", "Fifteen", "Fourteen", "Thirteen", "Twelve", "Eleven", "Ten", "Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Two", "One"};


    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return util(num);
    }

    public String util(int num) {
        String ret = "";
        for (int i = 0;i< IM.length;i++) {
            if(num >= IM[i]){
                ret = (IM[i] >= 100 ? util(num / IM[i]) + " " : "") + SM[i] + " " + util(num % IM[i]);
                break;
            }
        }
        return ret.trim();
    }


    public static void main(String[] args) {
        IntegerToEnglishWords2 ie = new IntegerToEnglishWords2();
        System.out.println(ie.numberToWords(1234567));
    }
}
