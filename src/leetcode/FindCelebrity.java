/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author mns
 */

abstract class Relation {
    abstract public boolean knows(int a, int b);
}
public class FindCelebrity extends Relation {
    public int findCelebrity(int n){
        int celeb = 0;
        for(int i = 1; i < n; i++){
            if(knows(celeb, i))
                celeb = i;
        }
        
        for(int i = 0; i < n; i++){
            if(i != celeb && (knows(celeb, i) || !knows(i, celeb))) return -1;
        }
        return celeb;
    }
    
    public boolean knows(int a , int b){
        //Their implementation
        return false;
    }
    
    
}
