/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author mns
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        String result = "";
        Deque<String> stack = new ArrayDeque<String>();
        if(path.length() > 0){
            
            String [] items = path.split("/");
            for(int i=1;i<items.length;i++){
                String element = items[i].trim();
                if(!element.isEmpty()){
                    switch(element){
                        case "..":
                            if(!stack.isEmpty()){
                                stack.pop();
                            }
                            break;
                        case ".":
                            break;
                        default:
                            stack.push(element);
                            break;
                    }
                }
            }
        }
        
        if(stack.isEmpty()){
            result = "/";
        }
        while(!stack.isEmpty()){
            result = "/"+stack.pop()+result;
        }
        return result;
    }
    
    public static void main(String[] args) {
        SimplifyPath sp = new SimplifyPath();
        System.out.println(sp.simplifyPath("/a/b/cc/..//dd/e/f"));
        System.out.println(sp.simplifyPath("/home//foo/"));
        System.out.println(sp.simplifyPath("/../"));
        
    }
}
