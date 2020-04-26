/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airwatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author mns
 */
public class OS {

    static class Process {

        int dur;
        int mem;

        public Process(int d, int m) {
            this.dur = d;
            this.mem = m;
        }
    }

    public static int rec_solve(ArrayList<Process> list, int currIndex,int totalMem) {
        
        if(currIndex >= list.size()){
            return 0;
        }
        
        int curr_mem = 0;
        int max_so_far = Integer.MIN_VALUE;
        ArrayList<Integer> times = new ArrayList<>();
        while(currIndex < list.size() && list.get(currIndex).mem + curr_mem <= totalMem){
            curr_mem += list.get(currIndex).mem;
            if(max_so_far < list.get(currIndex).dur){
                max_so_far = list.get(currIndex).dur;
            }
            
            times.add(max_so_far+rec_solve(list, currIndex+1,totalMem));
            currIndex++;
        }
        
        
        return Collections.min(times);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = null;
        line = sc.nextLine();
        int m, n;
        String[] lineSplit = line.split(" ");
        n = Integer.parseInt(lineSplit[0]);
        m = Integer.parseInt(lineSplit[1]);

        //System.out.println(" " + m+ " "+ n);
        ArrayList<Process> lp = new ArrayList<>();

        int total_dur = 0;
        for (int i = 0; i < n; i++) {
            line = sc.nextLine();
            lineSplit = line.split(" ");
            Process p = new Process(Integer.parseInt(lineSplit[0]),
                    Integer.parseInt(lineSplit[1]));
            //System.out.println(p.dur + " " + p.mem);
            lp.add(p);

        }

        System.out.println(rec_solve(lp, 0,m));
        sc.close();
        
    }

}
