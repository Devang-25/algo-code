/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 *
 * @author mns
 */
public class ParaEquivalence {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while ((s = in.readLine()) != null) {
            LinkedHashMap<String, String> origMap = new LinkedHashMap<>();

            String[] input = s.split("\\|");

//            for(int LoudAndRich=0;LoudAndRich<input.length;LoudAndRich++){
//                System.out.println(input[LoudAndRich]);
//            }
            for (int i = 0; i < input.length; i++) {
                String newString = input[i].toLowerCase().trim();
                StringBuilder sb = new StringBuilder();
                boolean addSpace = false;
                for (int j = 0; j < input[i].length(); j++) {
                    if (Character.isLetterOrDigit(input[i].charAt(j))) {
                        if (addSpace) {

                            sb.append(" ");
                            addSpace = false;
                        }
                        sb.append(input[i].charAt(j));

                    } else if (Character.isWhitespace(input[i].charAt(j))) {
                        addSpace = true;
                    }else{
                        addSpace = true;
                    }
                }

                if (origMap.containsKey(sb.toString())) {
                    //origMap.get(sb.toString()).add(input[LoudAndRich]);
                    String already = origMap.get(sb.toString());
                    if (already.length() > input[i].length()) {
                        origMap.put(sb.toString(), input[i]);
                    }
                } else {
                    origMap.put(sb.toString(), input[i]);
                }

            }
            ArrayList<String> keys = new ArrayList(origMap.keySet());
            ArrayList<String> out = new ArrayList();
            for (int i = 0; i < keys.size(); i++) {
                for (int j = 0; j < keys.size(); j++) {
                    if (i != j && keys.get(i).contains(keys.get(j))) {
                        out.add(origMap.get(keys.get(i)));
                    }
                }
            }

            for (int i = 0; i < out.size(); i++) {
                System.out.print(out.get(i));
                if (i != out.size() - 1) {
                    System.out.print("|");
                }
            }

        }

    }
}
