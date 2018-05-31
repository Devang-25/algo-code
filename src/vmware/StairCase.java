/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmware;

import java.util.Scanner;

/**
 *
 * @author mns
 */
public class StairCase {

    static void StairCase(int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                System.out.print(" ");
            }
            
            for(int j=0;j<=i;j++){
                System.out.print("#");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int _n;
        _n = Integer.parseInt(in.nextLine().trim());

        StairCase(_n);

    }
}
