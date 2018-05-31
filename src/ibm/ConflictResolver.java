/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 *
 * @author mns
 */
public class ConflictResolver {

    static class Employee {

        public Employee manager;
        public String name;
        public boolean flag = false;

        public Employee(String name, Employee manager) {
            this.name = name;
            this.manager = manager;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while ((s = in.readLine()) != null) {
            String[] rel = s.split(",");
            HashMap<String, Employee> empMap = new HashMap<>();
            for (int i = 0; i < rel.length - 2; i++) {
                String[] keyVal = rel[i].split("->");

                if (keyVal.length == 2) {
                    if (empMap.get(keyVal[0]) == null) {
                        empMap.put(keyVal[0], new Employee(keyVal[0], null));
                    }

                    if (empMap.get(keyVal[1]) == null) {
                        empMap.put(keyVal[1], new Employee(keyVal[1], empMap.get(keyVal[0])));
                    } else {
                        empMap.get(keyVal[1]).manager = empMap.get(keyVal[0]);
                    }
                }
            }

            Employee empOne = empMap.get(rel[rel.length - 2]);
            Employee empTwo = empMap.get(rel[rel.length - 1]);

            while (empOne != null || empTwo != null) {
                if (empOne.flag) {
                    System.out.print(empOne.name);
                    break;
                } else if (empTwo.flag) {
                    System.out.print(empTwo.name);
                    break;
                } else {
                    empOne.flag = true;
                    empTwo.flag = true;
                    empOne = empOne.manager;
                    empTwo = empTwo.manager;
                }

            }

        }
    }
}
