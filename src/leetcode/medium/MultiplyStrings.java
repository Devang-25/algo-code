package leetcode.medium;

import java.util.ArrayList;

/**
 * Created by mns on 6/22/18.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2){
        int n = num2.length();

        ArrayList<String> intResults = new ArrayList<>();


        String append = "";
        int maxLength = 0;
        for(int i = n-1;i >=0 ;i-- ){
            String s = multiply(num1,num2.charAt(i))+append;
            intResults.add(s);
            maxLength = Math.max(maxLength,s.length());
            append += "0";
        }

        StringBuffer result = new StringBuffer();
        //intResults.stream().forEach(System.out::println);
        int carry = 0;
        for(int i=0;i<maxLength;i++){
            int sum = 0;
            for(String intResult : intResults){
                int pos = intResult.length()-i-1;
                if(pos >= 0) {
                    sum += (intResult.charAt(pos) - '0');
                }
            }
            sum += carry;
            carry = sum/10;
            result.append(sum%10);
        }

        if(carry > 0){
            result.append(carry);
        }
        while(result.length() >0 && result.charAt(result.length()-1) == '0'){
            result.setLength(result.length()-1);
        }
        return result.length() == 0 ? "0" : result.reverse().toString();
    }

    String multiply(String a, char b){
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        for(int i=a.length()-1;i>=0;i--){
            int num = (b-'0')*(a.charAt(i)-'0')+carry;
            carry = num/10;
            sb.append(num%10);
        }
        if(carry != 0){
            sb.append(carry);
        }
        return  sb.reverse().toString();
    }

    public static void main(String[] args) {
        MultiplyStrings ms = new MultiplyStrings();
        System.out.println(ms.multiply("123","456"));
        System.out.println(ms.multiply("999","999"));
        System.out.println(ms.multiply("9899","0"));
    }
}
