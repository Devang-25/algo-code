package hard;

/**
 * Created by mns on 6/22/18.
 */
public class ValidNumber {
    public boolean isNumber(String s){
       s = s.trim();
       if(s.length() == 0){
           return false;
       }

       boolean foundExp = false;
        int expIndex = 0;
       for(int i=0; i<s.length();i++){
           if(s.charAt(i) == 'e'){
               if(!foundExp){
                   foundExp = true;
                   expIndex = i;
               }else{
                   return false;
               }
           }else if(!(s.charAt(i) >='0'
                   && s.charAt(i) <= '9' )
                   && s.charAt(i) != '.'
                   && s.charAt(i) != '+'
                   && s.charAt(i) != '-'){
               return false;
           }
       }

       if(foundExp){
            return (isInteger(s.substring(0,expIndex)) || isReal(s.substring(0,expIndex))) &&
                    isInteger(s.substring(expIndex+1,s.length()));
       }else{
           return (isInteger(s.substring(0,s.length())) || isReal(s.substring(0,s.length())));
       }
    }

    private boolean isSignedInteger(String s){
        if(s.length() == 0)
            return false;
        for(int i = 0; i<s.length() ;i++){
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }

    private boolean isInteger(String s){
        if(s.length() == 0)
            return false;

        int start = 0;
        if(s.charAt(0) == '+' || s.charAt(0) == '-')
            start = 1;

        return isSignedInteger(s.substring(start));
    }

    private boolean isSignedReal(String s){
        for(int i = 0; i<s.length() ;i++){
            if(s.charAt(i) == '.') {
                if (i == 0) {
                    return isSignedInteger(s.substring(i + 1, s.length()));
                } else if (i == s.length()-1) {
                    return isInteger(s.substring(0, i));
                } else {
                    return isInteger(s.substring(0, i)) && isSignedInteger(s.substring(i + 1, s.length()));
                }
            }
        }
        return false;
    }
    private boolean isReal(String s){
        if(s.length() == 0)
            return false;

        int start = 0;
        if(s.charAt(0) == '+' || s.charAt(0) == '-')
            start = 1;

        return isSignedReal(s.substring(start));
    }

//    public boolean isNumber(String s) {
//        s = s.trim();
//        boolean pointSeen = false;
//        boolean eSeen = false;
//        boolean numberSeen = false;
//        for(int i=0; i<s.length(); i++) {
//            if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
//                numberSeen = true;
//            } else if(s.charAt(i) == '.') {
//                if(eSeen || pointSeen)
//                    return false;
//                pointSeen = true;
//            } else if(s.charAt(i) == 'e') {
//                if(eSeen || !numberSeen)
//                    return false;
//                numberSeen = false;
//                eSeen = true;
//            } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
//                if(i != 0 && s.charAt(i-1) != 'e')
//                    return false;
//            } else
//                return false;
//        }
//        return numberSeen;
//    }

    public static void main(String[] args) {
        ValidNumber vn = new ValidNumber();
        System.out.println(vn.isNumber("45"));
        System.out.println(vn.isNumber("   45   "));
        System.out.println(vn.isNumber("   1.a23   "));
        System.out.println(vn.isNumber("   1.   "));
        System.out.println(vn.isNumber("   1.0e10000  "));
        System.out.println(vn.isNumber("   -1."));
        System.out.println(vn.isNumber("   -1.e+2"));
        System.out.println(vn.isNumber("   -1.ee+2"));
        System.out.println(vn.isNumber("   -1.e-2"));
        System.out.println(vn.isNumber("   +-1.e100"));
        System.out.println(vn.isNumber("   +.8"));
    }
}
