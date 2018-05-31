/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import java.util.HashSet;

/**
 *
 * @author sekha
 */
public class CustomObjectHashSet {

    static class Point {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Point p = (Point) obj;
            return this.x == p.x && this.y == p.y;
        }

        @Override
        public int hashCode() {
            return 0;
        }

        
        
        
        

    }

    public static void main(String[] args) {
        Point origin = new Point(0,0);
        HashSet<Point> set = new HashSet<>();
        set.add(origin);
        
        if(set.contains(new Point(0,0))){
            System.out.println("Found");
        }else{
            System.out.println("Not found");
        }
    }
        
}
