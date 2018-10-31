package leetcode.easy;

import java.util.HashSet;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for(String s :emails){
            StringBuilder sb = new StringBuilder();
            String [] names = s.split("@");
            for(int j=0;j<names[0].length();j++){
                if(names[0].charAt(j) == '+'){
                    break;
                }
                if(names[0].charAt(j) != '.'){
                    sb.append(names[0].charAt(j));
                }
            }

            sb.append('@'+names[1]);
            set.add(sb.toString());
        }

        return set.size();
    }

    public static void main(String[] args) {
        UniqueEmailAddresses u = new UniqueEmailAddresses();
        System.out.println(u.numUniqueEmails(new String [] {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
    }

}
