package leetcode.easy;

import java.util.HashMap;

/**
 * Created by mns on 8/10/18.
 */
public class Logger {
    /** Initialize your data structure here. */
    HashMap<String,Integer> map;
    public Logger() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message) || timestamp - map.get(message) >= 10){
            map.put(message,timestamp);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Logger lg = new Logger();
        System.out.println(lg.shouldPrintMessage(1,"foo"));
        System.out.println(lg.shouldPrintMessage(2,"bar"));
        System.out.println(lg.shouldPrintMessage(3,"foo"));
        System.out.println(lg.shouldPrintMessage(8,"bar"));
        System.out.println(lg.shouldPrintMessage(10,"foo"));
        System.out.println(lg.shouldPrintMessage(11,"foo"));
    }
}
