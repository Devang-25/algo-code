/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author sekha
 */
public class PrisonBreak {

    static class Point {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Point p = (Point) obj;
            return p.x == this.x && p.y == this.y;
        }

        @Override
        public int hashCode() {
           return 0;
        }
        
        

    }

    static long prison(int n, int m, int[] h, int[] v) {
        int[][] graph = new int[n][m];
        HashSet<Point> unvisited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = 1;
            }
        }

        for (int i = 0; i < h.length; i++) {
            for (int j = 0; j < m; j++) {
                graph[h[i]][j] = 0;
            }
        }

        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < n; j++) {
                graph[j][h[i]] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    Point p = new Point(i, j);
                    unvisited.add(p);
                }
            }
        }

        int maxComponentSize = 1;
        while (!unvisited.isEmpty()) {

            int compSize = doDfs(graph,unvisited, unvisited.iterator().next());
            if (compSize > maxComponentSize) {
                maxComponentSize = compSize;
            }
        }

        return maxComponentSize;
    }

    static int doDfs(int [][] graph,Set<Point> unvisited, Point start) {
        int currComponentSize = 0;

        Stack<Point> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            Point currPoint = stack.pop();
            unvisited.remove(currPoint);
            currComponentSize += 1;

            Point left = new Point(currPoint.x, currPoint.y - 1);
            Point right = new Point(currPoint.x, currPoint.y + 1);
            Point topLeft = new Point(currPoint.x - 1, currPoint.y - 1);
            Point topRight = new Point(currPoint.x - 1, currPoint.y + 1);

            Point top = new Point(currPoint.x - 1, currPoint.y);
            Point bottom = new Point(currPoint.x + 1, currPoint.y);
            Point bottomLeft = new Point(currPoint.x + 1, currPoint.y - 1);
            Point bottomRight = new Point(currPoint.x + 1, currPoint.y + 1);

            if (unvisited.contains(left)) {
                stack.push(left);
            }

            if (unvisited.contains(right)) {
                stack.push(right);
            }

            if (unvisited.contains(topLeft)) {
                stack.push(topLeft);
            }

            if (unvisited.contains(topRight)) {
                stack.push(topRight);
            }

            if (unvisited.contains(top)) {
                stack.push(top);
            }

            if (unvisited.contains(bottom)) {
                stack.push(bottom);
            }

            if (unvisited.contains(bottomLeft)) {
                stack.push(bottomLeft);
            }

            if (unvisited.contains(bottomRight)) {
                stack.push(bottomRight);
            }

        }

        return currComponentSize;
    }

}
