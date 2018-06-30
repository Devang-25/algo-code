package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mns on 6/5/18.
 */
public class RemoveComments {
    private enum CharacterType {
        NORMAL,
        BLOCK_COMMENT_OPEN,
        BLOCK_COMMENT_CLOSE,
        LINE_COMMENT,
    }

    public List<String> removeComments(String[] source) {

        List<String> result = new ArrayList<>();
        boolean blockComment = false;
        StringBuilder sb = new StringBuilder();
        for (String s : source) {
            for (int i = 0; i < s.length(); i++) {
                if (!blockComment) {
                    CharacterType type = getCharacterType(s,i);
                    if(type == CharacterType.BLOCK_COMMENT_OPEN){
                        blockComment = true;
                        i++;
                    }else if(type == CharacterType.LINE_COMMENT){
                        break;
                    }else{
                        sb.append(s.charAt(i));
                    }
                }else{
                    if(getCharacterType(s,i) == CharacterType.BLOCK_COMMENT_CLOSE){
                        blockComment = false;
                        i++;
                    }
                }
            }

            if(!blockComment && sb.length() > 0){
                result.add(sb.toString());
                sb.setLength(0);
            }
        }

        return result;
    }

    private CharacterType getCharacterType(String s , int i){
       if (s.charAt(i) == '/'
                && i+1 < s.length()
                && s.charAt(i + 1) == '*'){
           return CharacterType.BLOCK_COMMENT_OPEN;
       }
        if(s.charAt(i) == '/'
                && i+1 < s.length()
                && s.charAt(i+1) == '/'){
           return CharacterType.LINE_COMMENT;
        }
        if(s.charAt(i) == '*'
                && i+1 < s.length()
                && s.charAt(i+1) == '/'){
            return CharacterType.BLOCK_COMMENT_CLOSE;
        }

        return CharacterType.NORMAL;
    }

    public static void main(String[] args) {
        RemoveComments rc = new RemoveComments();
        System.out.println(rc.removeComments(new String[]{
                "/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"
        }).toString());
    }
}
