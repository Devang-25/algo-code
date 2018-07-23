package leetcode.medium;

public class ReorderPower2 {

    Boolean b;
    public boolean reorderedPowerOf2(int N) {
        if(N == 1){
            return true;
        }

        b = false;
        String s = Integer.toString(N);
        boolean [] picked = new boolean[s.length()];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)-'0') %2 == 0) {
                picked[i] = true;
                sb.append(s.charAt(i));
                reorderedPowerOf2Util(sb,s, picked);
                picked[i] = false;
                sb.setLength(0);
            }
        }

        return b;
    }

    private void reorderedPowerOf2Util(StringBuilder sb , String s, boolean [] picked){
        if(b){
            return;
        }

        if(sb.length() == picked.length){
            StringBuilder sb2 = new StringBuilder(sb);
            if(sb.charAt(sb.length()-1) == '0'){
                return ;
            }
            int i = Integer.parseInt(sb2.reverse().toString());
            b = (i > 0) && ((i & (i-1)) == 0);
            return;
        }

        for(int i=0;i<s.length();i++){
            if(!picked[i]){
                picked[i] = true;
                sb.append(s.charAt(i));
                reorderedPowerOf2Util(sb,s,picked);
                picked[i] = false;
                sb.setLength(sb.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        ReorderPower2 rp = new ReorderPower2();
        System.out.println(rp.reorderedPowerOf2(521));
    }
}
