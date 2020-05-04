package leet.may30day;

public class NumberComplement {
    public int findComplementOrig(int num) {
        String binaryString = Integer.toBinaryString(num);
        int complement = 0;
        int exp = 0;
        for(int i = binaryString.length()-1 ; i >=0 ; i--) {
            if(binaryString.charAt(i) == '0') {
                complement += Math.pow(2,exp);
            }
            exp++;
        }

        return complement;
    }

    public int findComplement(int num) {
        int comp = 0;
        int pos = 0;
        while(num > 0) {
            if((num & 1) == 0 ) {
                comp = comp | 1 << pos;
            }
            pos ++;
            num >>= 1;
        }
        return comp;
    }

    public static void main(String [] args) {
        NumberComplement nc = new NumberComplement();
        System.out.println(nc.findComplementOrig(1));
        System.out.println(nc.findComplementOrig(5));
        System.out.println(nc.findComplement(1));
        System.out.println(nc.findComplement(5));
    }
}