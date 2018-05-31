/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airwatch;

import java.util.Scanner;

/**
 *
 * @author mns
 */
public class JesseEncryption {

    private static String encrypt(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            //System.out.println(Integer.toString(ch-'a'));
            if (Character.isAlphabetic(ch)) {
                if (ch - 'a' >= 10 && ch - 'a' <= 25) {
                    sb.append(Integer.toString(ch-'a'));
                    sb.append('#');
                }else if(ch - 'a'>=0 &&ch-'a' < 10 ){
                    sb.append(Integer.toString(ch-'a'));
                }
            }else{
                sb.append(ch);
            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(encrypt(input));
    }
}
