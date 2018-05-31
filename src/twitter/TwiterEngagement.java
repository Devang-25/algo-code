/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.TreeMap;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.Scanner;

/**
 *
 * @author sekhar natarajan
 */
public class TwiterEngagement {

    public static void main(String[] args) throws ParseException {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        Scanner ir = new Scanner(System.in);
        String[] dates = ir.nextLine().split(",");
        Date startDate = parseDate(dates[0].trim());
        startDate.setTime(startDate.getTime());
        Date endDate = parseDate(dates[1].trim());
        endDate.setTime(endDate.getTime());

        ir.nextLine();

        String inpData = "";

        TreeMap<Date, TreeMap<String, Stats>> statsMap = new TreeMap<>(new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return o2.compareTo(o1);
            }
        });

        while (ir.hasNext() && !(inpData = ir.nextLine()).isEmpty()) {
            String[] input = inpData.split(",");
            Date thisDate = parseDate(input[0].trim());
            String category = input[1].trim();
            if (thisDate.compareTo(startDate) >= 0 && thisDate.compareTo(endDate) < 0) {
                if (statsMap.containsKey(thisDate)) {
                    if (statsMap.get(thisDate).containsKey(category)) {
                        statsMap.get(thisDate).get(category).total += Integer.parseInt(input[2].trim());
                    } else {
                        Stats stat = new Stats(category, Integer.parseInt(input[2].trim()));
                        statsMap.get(thisDate).put(stat.category, stat);
                    }
                } else {
                    TreeMap<String, Stats> innerMap = new TreeMap<>();
                    Stats stat = new Stats(category, Integer.parseInt(input[2].trim()));
                    innerMap.put(category, stat);
                    statsMap.put(thisDate, innerMap);
                }
            }
        }

        for (Date date : statsMap.keySet()) {
            System.out.print(printDate(date));

            TreeMap<String, Stats> innerMap = statsMap.get(date);
            for (String strKey : innerMap.keySet()) {
                Stats stat = innerMap.get(strKey);
                System.out.print(", " + stat.category + ", " + stat.total);
            }
            System.out.print(" ");
            System.out.println("");
        }
    }

//    public static void main(String[] args) throws ParseException {
//        String date = "2015-12-22";
//        System.out.println(parseDate(date).toString());
//    }
    private static String printDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH) + 1;
        return ((cal.get(Calendar.YEAR)) + "-" + (month < 10 ? "0" + month : month));
    }

    private static Date parseDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        return sdf.parse(date);

    }

    static class Stats {

        String category;
        Integer total;

        public Stats(String type, Integer total) {
            this.category = type;
            this.total = total;
        }
    }

    static class InputReader {

        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public float nextFloat() {
            return Float.parseFloat(next());
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException ex) {
                //Logger.getLogger(CuttingBoards.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }
}
