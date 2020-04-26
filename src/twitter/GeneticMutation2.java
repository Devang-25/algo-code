/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author mns
 */
public class GeneticMutation2 {

    public static class Mutation {

        String seq;
        int numMutations;

        public Mutation(String seq, int n) {
            this.seq = seq;
            this.numMutations = n;
        }
    }

    public static char[] STRANDS = {'A', 'C', 'G', 'T'};

    public static int findMutationDistance(String start, String end, String[] bank) {
        HashSet<String> bankMap = new HashSet<>();
        HashSet<String> visited = new HashSet<>();

        for (String mut : bank) {
            bankMap.add(mut);
        }

        if (!bankMap.contains(end)) {
            return -1;
        }

        Queue<Mutation> queue = new LinkedList<>();
        queue.add(new Mutation(start, 0));
        visited.add(start);
        
        while (!queue.isEmpty()) {
            Mutation front = queue.poll();

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < STRANDS.length; j++) {
                    if (front.seq.charAt(i) != STRANDS[j]) {
                        char[] charArray = front.seq.toCharArray();
                        charArray[i] = STRANDS[j];
                        String newString = new String(charArray);
                        if (newString.contentEquals(end)) {
                            return front.numMutations + 1;
                        }

                        if (!visited.contains(newString) && bankMap.contains(newString)) {
                            visited.add(newString);
                            queue.add(new Mutation(newString, front.numMutations + 1));
                        }
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = "out.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;
        String _start;
        try {
            _start = in.nextLine();
        } catch (Exception e) {
            _start = null;
        }

        String _end;
        try {
            _end = in.nextLine();
        } catch (Exception e) {
            _end = null;
        }

        int _bank_size = 0;
        _bank_size = Integer.parseInt(in.nextLine().trim());
        String[] _bank = new String[_bank_size];
        String _bank_item;
        for (int _bank_i = 0; _bank_i < _bank_size; _bank_i++) {
            try {
                _bank_item = in.nextLine();
            } catch (Exception e) {
                _bank_item = null;
            }
            _bank[_bank_i] = _bank_item;
        }

        res = findMutationDistance(_start, _end, _bank);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
        in.close();
    }
}
