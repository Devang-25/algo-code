/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author mns
 */
public class AtoI {
    public int myAtoi(String str) {
        
        if(str == null || str.trim().length() == 0){
            return 0;
        }
        
        int result = 0;
        
        str = str.trim();
        boolean negative = str.charAt(0) == '-';
        
        int length = str.length();
        int power = 0;
        int begin = (str.charAt(0) == '+' || str.charAt(0) == '-') ? 1 : 0;
        for(int i=length-1;i>=begin;i--){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                
                if(negative){
                    long lv = result - (long)((str.charAt(i)-'0')*Math.pow(10, power));
                    if(lv >= Integer.MIN_VALUE){
                        result -= ((str.charAt(i)-'0')*Math.pow(10, power));
                        power++;
                    }else{
                        result = Integer.MIN_VALUE;
                    }
                }else{
                    long lv = result+ (long)((str.charAt(i)-'0')*Math.pow(10, power));
                    if(lv <= Integer.MAX_VALUE){
                        result += ((str.charAt(i)-'0')*Math.pow(10, power));
                        power++;
                    }else{
                        result = Integer.MAX_VALUE;
                    }
                }
            }else{
                result = 0;
                power=0;
            }
        }
        
        return result;
    }
    
    
    public static void main(String[] args) {
        AtoI atoi = new AtoI();
        System.out.println(atoi.myAtoi("12344556"));
        System.out.println(atoi.myAtoi("+12344556"));
        System.out.println(atoi.myAtoi("123445569999000"));
        System.out.println(atoi.myAtoi("-0"));
        System.out.println(atoi.myAtoi("-aa0aa"));
    }
}
