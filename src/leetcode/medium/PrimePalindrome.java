package leetcode.medium;

public class PrimePalindrome {
    int getNextPalindrome(int n){

        String str = String.valueOf(n);
        boolean only9 = true;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) != '9'){
                only9 = false;
                break;
            }
        }

        if(only9){
            return (int)Math.pow(10,str.length())+1;
        }

        int l = str.length();
        int mid = l%2 == 1? (l/2)+1 : l/2;
        String left = (str.substring(0,mid));
        String right =(str.substring(mid));

        String leftPartial = left.length()>right.length()?left.substring(0,left.length()-1):left;
        int leftVal = leftPartial.length()==0? 0 :Integer.parseInt(new StringBuilder(leftPartial).reverse().toString());
        int rightVal = right.length()==0 ? 0:Integer.parseInt(right);

        if(rightVal >= leftVal){
            left = String.valueOf(Integer.parseInt(left) + 1);
            if(left.length() > right.length()){
                right = new StringBuilder(left.substring(0,left.length()-1)).reverse().toString();
            }else{
                right = new StringBuilder(left).reverse().toString();
            }
        }else{
            if(left.length() > right.length()){
                right = new StringBuilder(left.substring(0,left.length()-1)).reverse().toString();
            }else{
                right = new StringBuilder(left).reverse().toString();
            }
        }
        return Integer.parseInt(left+right);
    }

    public boolean isPrime(int x) {
        if (x == 1) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(x); i++) {
                if (x % i == 0) return false;
            }
            return true;
        }
    }

    public boolean isPalindrome(int n){
        String str = String.valueOf(n);
        int i=0, j=str.length()-1;
        while(i < j){
            if(str.charAt(i++) != str.charAt(j--)){
                return false;
            }
        }
        return true;
    }

    public int primePalindrome(int N) {
        int nextPalindrome = N;
        if(isPrime(N) && isPalindrome(N)){
            return N;
        }
        do{
            nextPalindrome = getNextPalindrome(nextPalindrome);
            if(isPrime(nextPalindrome)){
                return nextPalindrome;
            }
        }while(true);
    }

    public static void main(String[] args) {
        PrimePalindrome p = new PrimePalindrome();
        System.out.println(p.primePalindrome(13));
        System.out.println(p.primePalindrome(6));
        System.out.println(p.primePalindrome(98390));
        System.out.println(p.primePalindrome(8));
    }

}
