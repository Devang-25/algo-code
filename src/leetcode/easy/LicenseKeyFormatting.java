package leetcode.easy;

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        int l = S.length();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i = l-1;i>=0;i--){
            char ch = S.charAt(i);
            if(ch == '-') continue;
            if(cnt == K){
                cnt = 0;
                sb.append('-');
            }
            sb.append( Character.isDigit(ch)? ch : Character.toUpperCase(ch));
            cnt++;

        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        LicenseKeyFormatting lkf =  new LicenseKeyFormatting();
        System.out.println(lkf.licenseKeyFormatting("2-5g-3-J",2));
        System.out.println(lkf.licenseKeyFormatting("5F3Z-2e-9-w",4));
    }
}
