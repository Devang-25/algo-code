/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airwatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author mns
 */
public class OSCorrect {

    static class Process {

        int dur;
        int mem;
        int finishTime = -1;

        public Process(int d, int m) {
            this.dur = d;
            this.mem = m;
        }

        @Override
        public String toString() {
            return this.dur + " " + this.mem;
        }

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

        int totalTime = 0;
        int k = 0;
        PriorityQueue<Process> pq = new PriorityQueue<>(new Comparator<Process>() {
            @Override
            public int compare(Process o1, Process o2) {
                return o1.finishTime - o2.finishTime;
            }
        });

        while (k < lp.size()) {

            Process next = lp.get(k);
            while (next != null && m > next.mem) {
                next.finishTime = totalTime + next.dur;
                pq.add(next);
                //System.out.println(pq.toString());
                m -= next.mem;

                if (++k < lp.size()) {
                    next = lp.get(k);
                }

            }

            if (!pq.isEmpty()) {
                Process finished = pq.poll();
                m += finished.mem;
                totalTime = finished.finishTime;
                //System.out.println(totalTime);
            }
        }

        if (!pq.isEmpty()) {
            while (!pq.isEmpty()) {
                Process finished = pq.poll();
                m += finished.mem;
                totalTime = finished.finishTime;
            }
        }
        System.out.println(totalTime);

    }

}
