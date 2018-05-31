/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 *
 * @author mns
 */
public class CompVersions {

    private static class Solution {

        private void normalize(ArrayList<String> list1, ArrayList<String> list2) {
           
            if (list1.size() < list2.size()) {
                int diff = list2.size()-list1.size();
                for (int i = 0; i < diff; i++) {
                    list1.add("0");
                }
            } else if (list1.size() > list2.size()) {
                int diff = list1.size()-list2.size();
                for (int i = 0; i < diff; i++) {
                    list2.add("0");
                }
            }
        }

        public int compareVersion(String version1, String version2) {
            String[] version1Comp = version1.split("\\.");
            String[] version2Comp = version2.split("\\.");

            if (version1Comp != null && version1Comp.length == 0) {
                version1Comp = new String[1];
                version1Comp[0] = version1;
            }

            if (version2Comp != null && version2Comp.length == 0) {
                version2Comp = new String[1];
                version2Comp[0] = version2;
            }

            ArrayList<String> version1CompList = new ArrayList<>(Arrays.asList(version1Comp));
            ArrayList<String> version2CompList = new ArrayList<>(Arrays.asList(version2Comp));

            normalize(version1CompList, version2CompList);

            for (int i = 0; i < version1CompList.size(); i++) {
                int a = Integer.parseInt(version1CompList.get(i));
                int b = Integer.parseInt(version2CompList.get(i));
                if (a < b) {
                    return -1;
                } else if (a > b) {
                    return 1;
                }
            }
            
            return 0;

        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.compareVersion("1.0.1", "1"));
    }
}
