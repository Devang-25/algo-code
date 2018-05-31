import java.util.HashMap;

public class Codec {

    private static long entryNum;
    private HashMap<Long,String> map = null;
    public Codec(){
        this.entryNum = 0;
        this.map = new HashMap<>();
    }

    public synchronized String encode(String longUrl) {
        map.put(entryNum , longUrl);
        return String.valueOf(entryNum++);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(Long.parseLong(shortUrl));
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        System.out.println(codec.decode(codec.encode("https://leetcode.com/problems/design-tinyurl")));
        System.out.println(codec.decode(codec.encode("https://leetcode.com/problems/design-tinyurl2")));
    }
}
