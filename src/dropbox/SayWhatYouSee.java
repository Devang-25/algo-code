/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dropbox;

import java.util.Arrays;

/**
 *
 * @author mns
 */
public class SayWhatYouSee {

    static String[] say_what_you_see(String[] input_strings) {
        String[] output = new String[input_strings.length];
        for (int i = 0; i < input_strings.length; i++) {
            String current = input_strings[i];
            String outPutString = "";
            if (current.length() > 0) {
                String currentNum = "" + current.charAt(0);
                int currentNumCount = 1;
                for (int j = 1; j < current.length(); j++) {
                    if (currentNum.contentEquals("" + current.charAt(j))) {
                        currentNumCount++;
                    } else {
                        outPutString += "" + currentNumCount + currentNum;
                        currentNum = "" + current.charAt(j);
                        currentNumCount = 1;
                    }
                }
                outPutString += "" + currentNumCount + currentNum;
            }
            output[i] = outPutString;
        }

        return output;
    }

    public static void main(String[] args) {
        String[] input = new String[]{"12", "21","11111111111","21114","21","1"};
        System.out.println(Arrays.toString(say_what_you_see(input)));
    }
}
