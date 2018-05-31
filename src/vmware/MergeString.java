/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmware;

/**
 *
 * @author mns
 */
public class MergeString {

    static String mergeStrings(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;

        while (i < a.length() && j < b.length()) {
            sb.append(a.charAt(i++));
            sb.append(b.charAt(j++));
        }

        if (i == a.length()) {
            while (j < b.length()) {
                sb.append(b.charAt(j++));
            }
        }

        if (j == b.length()) {
            while (i < a.length()) {
                sb.append(a.charAt(i++));
            }
        }

        return sb.toString();
    }

}
