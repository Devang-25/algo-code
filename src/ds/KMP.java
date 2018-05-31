
import java.util.Arrays;

/**
 * Created by sekharan on 3/8/17.
 */
public class KMP {
    protected String text;
    protected String pattern;

    public KMP(String text,String pattern){
        this.text = text;
        this.pattern = pattern;
    }

    private int [] patternJump(){
        int patternLength = pattern.length();
        int [] arr = new int[patternLength];

        //Initialization
        int j=0;
        arr[j]=0;
        for(int i=1;i<patternLength;i++){
            if(pattern.charAt(i) == pattern.charAt(j)){
                arr[i]=j+1;
                j++;
            }else{
                while(j-1 >=0){
                    if(pattern.charAt(i) == pattern.charAt(j)){
                        arr[i]=arr[j]+1;
                        break;
                    }else{
                        j = arr[j-1];
                    }
                }
            }
        }

        return arr;
    }

    int find(){
        int j=0;
        int [] arr = patternJump();
        for(int i=0;i<text.length();i++){
            if(text.charAt(i) == pattern.charAt(j)){
                j++;

                if(j == pattern.length()){
                    return i-pattern.length()+1;
                }
            }else{
                if(j > 0) {
                    j = arr[j - 1];
                }else{
                    j=0;
                }
            }
        }

        return -1;
    }

    public static void main(String [] args){
        KMP kmp = new KMP("aaaaaabbbbbccccacccaaaaabbbbcccccaaaaaaaaaaacccccccbbbbbbaaaaaaba","acacabacacabacacac");
        System.out.println(Arrays.toString(kmp.patternJump()));
        System.out.println(kmp.find());
    }

}
