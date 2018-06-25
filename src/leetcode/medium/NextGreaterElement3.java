package leetcode.medium;

import java.util.Arrays;

public class NextGreaterElement3 {
    public int nextGreaterElement(int n){
        char  [] ch = String.valueOf(n).toCharArray();
        for(int i=ch.length-1;i>=1;i--){
            if(ch[i] > ch[i-1]){

                int min = i;
                for(int j=i+1;j<ch.length;j++){
                    if(ch[j] < ch[min] && ch[j] > ch[i-1]){
                        min = j;
                    }
                }
                swap(ch,i-1,min);
                Arrays.sort(ch, i,ch.length);
                try {
                    return Integer.valueOf(new String(ch));
                }catch (NumberFormatException ne){
                    return -1;
                }
            }
        }

        return -1;
    }

    private void swap(char [] ch , int i, int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    public static void main(String[] args) {
        NextGreaterElement3 ng = new NextGreaterElement3();
        System.out.println(ng.nextGreaterElement(534976));
        System.out.println(ng.nextGreaterElement(21));
        System.out.println(ng.nextGreaterElement(230241));

    }
}
