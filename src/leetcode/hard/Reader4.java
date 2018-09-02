package leetcode.hard;

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

import java.util.Arrays;

public class Reader4 {
    private int ptr = 0;
    private String str;
    private static final int BUFFER_LENGTH = 4;
    public Reader4(String s){
        this.str = s;
    }

    /**
     * @param buf Destination buffer
     * @return
     */
    private int read4(char[] buf){
        int i = 0;
        while(ptr < str.length() && i < BUFFER_LENGTH){
            buf[i++] = str.charAt(ptr++);
        }
        return i;
    }

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private int read = 0, write = 0;
    private char [] b = new char[BUFFER_LENGTH];
    public int read(char[] buf, int n) {
        int i = 0;
        while(read < write && i < n){
            buf[i++] = b[read++];
        }

        while( i < n){
            write = read4(b);
            read = 0;
            if(write == 0){
                break;
            }
            while( read < write && i < n){
                buf[i++] = b[read++];
            }
        }

        return i;
    }

    public static void main(String[] args) {
        Reader4 r4 = new Reader4("exampleexampleapples");
        char [] buff = new char[10];
        System.out.println(r4.read( buff,10));
        System.out.println(Arrays.toString(buff));
        System.out.println(r4.read( buff,5));
        System.out.println(Arrays.toString(buff));
        System.out.println(r4.read( buff,10));
        System.out.println(Arrays.toString(buff));

//        Reader4 r4 = new Reader4("A");
//        char [] buff = new char[10];
//        System.out.println(r4.read( buff,10));
//        System.out.println(Arrays.toString(buff));
//        System.out.println(r4.read( buff,10));
//        System.out.println(Arrays.toString(buff));
//        System.out.println(r4.read( buff,10));
//        System.out.println(Arrays.toString(buff));

    }
}
