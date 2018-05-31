/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author sekha
 */
public class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        if(moves == null || moves.length() == 0){
            return false;
        }
        
        int length = moves.length();
        int x =0,y = 0 ;
        for(int i=0;i<length;i++){
            switch(moves.charAt(i)){
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'R':
                    x++;
                    break;
                case 'L':
                    x--;
                    break;
                default:
                    return false;
            }
        }
        
        if(x == 0 && y== 0){
            return true;
        }else{
            return false;
        }
    }
   
}
