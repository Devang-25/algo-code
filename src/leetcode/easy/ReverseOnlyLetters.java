package easy;

/**
 * Created by mns on 10/10/18.
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        int l = 0, r = s.length()-1;
        char [] arr = s.toCharArray();
        while(l < r){
            char a = s.charAt(l);
            char b = s.charAt(r);
            if(!Character.isAlphabetic(a)){
                l++;
            }
            if(!Character.isAlphabetic(b)){
                r--;
            }

            if(Character.isAlphabetic(a) && Character.isAlphabetic(b)){
                char temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;r--;
            }
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        ReverseOnlyLetters r = new ReverseOnlyLetters();
        System.out.println(r.reverseOnlyLetters("abcd-e---fg-gh-----i----j@"));
    }
}
