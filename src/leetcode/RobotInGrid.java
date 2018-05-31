/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;

/**
 *
 * @author mns
 */
public class RobotInGrid {

    static int[][] matrix = {
        {1, 1, 0, 0, 0, 0},
        {1, 1, 1, 1, 0, 0},
        {1, 1, 0, 1, 1, 0},
        {1, 0, 1, 0, 1, 1}};

    private static class Point {

        private int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }

    }

    private static boolean isValid(Point p) {
        if (p != null && p.x >= 0 && p.x < matrix.length && p.y >= 0 && p.y < matrix[0].length && matrix[p.x][p.y] == 1) {
            return true;
        }
        return false;
    }

    public static ArrayList<Point> getPath(int[][] matrix, Point p) {
        if (isValid(p)) {
            if (p.x == 0 && p.y == 0) {
                ArrayList<Point> list = new ArrayList<>();
                list.add(p);
                return list;
            } else {

                ArrayList<Point> list = getPath(matrix, new Point(p.x - 1, p.y));
                ArrayList<Point> list2 = getPath(matrix, new Point(p.x, p.y - 1));
                ArrayList<Point> newList = null;

                //Just prints any one path
                if (list != null) {
                    newList = new ArrayList<>(list);
                    newList.add(p);
                } else if (list2 != null) {
                    newList = new ArrayList<>(list2);
                    newList.add(p);
                }

                return newList;
            }

        }

        return null;
    }

    public static void main(String[] args) {

        System.out.println(getPath(matrix, new Point(matrix.length - 1, matrix[0].length - 1)).toString());

    }
}
