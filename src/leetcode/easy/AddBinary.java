package leetcode.easy;

public class AddBinary {
    public String addBinary(String a, String b) {
        int l = Math.min(a.length(),b.length());
        int carry = 0, i = 0;

        String larger = a.length() > b.length()?a:b;
        StringBuilder sb = new StringBuilder();

        for(i=0;i<l;i++){
            carry = a.charAt(a.length()-i-1)-'0' + b.charAt(b.length()-i-1)-'0'+ carry;
            sb.append(carry % 2);
            carry/=2;
        }

        while(i<larger.length()){
            carry = larger.charAt(larger.length()-i-1)-'0'+ carry;
            sb.append(carry % 2);
            carry/=2;
            i++;
        }

        if(carry > 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary ab = new AddBinary();
//        System.out.println(ab.addBinary("11","1"));
//        System.out.println(ab.addBinary("0","0"));
//        System.out.println(ab.addBinary("0","1001"));
        System.out.println(ab.addBinary("100","110010"));
    }
}
