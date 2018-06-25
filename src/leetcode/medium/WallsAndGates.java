package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class WallsAndGates {
    class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final int INF = 2147483647;

    public void wallsAndGates(int[][] rooms) {
        ArrayDeque<Coordinate> q = new ArrayDeque<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    q.addLast(new Coordinate(i, j));
                }
            }
        }

        int distFromGate = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            distFromGate++;
            for (int i = 0; i < size; i++) {
                Coordinate c = q.pollFirst();
                ArrayList<Coordinate> neighbors = getNeighbors(rooms.length, rooms[0].length, c);
                for (Coordinate neighbor : neighbors) {
                    if (rooms[neighbor.x][neighbor.y] == INF) {
                        rooms[neighbor.x][neighbor.y] = distFromGate;
                        q.addLast(neighbor);
                    }
                }
            }
        }
    }

    private ArrayList<Coordinate> getNeighbors(int l, int b, Coordinate c) {
        ArrayList<Coordinate> list = new ArrayList<>();
        if (c.x - 1 >= 0) {
            list.add(new Coordinate(c.x - 1, c.y));
        }
        if (c.x + 1 < l) {
            list.add(new Coordinate(c.x + 1, c.y));
        }
        if (c.y - 1 >= 0) {
            list.add(new Coordinate(c.x, c.y - 1));
        }
        if (c.y + 1 < b) {
            list.add(new Coordinate(c.x, c.y + 1));
        }
        return list;
    }

    public static void main(String[] args) {
        WallsAndGates wg = new WallsAndGates();
        int[][] inp = {{INF, - 1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF}};
        wg.wallsAndGates(inp);

        for (int i = 0; i < inp.length; i++) {
            System.out.println(Arrays.toString(inp[i]));
        }
        System.out.println();
    }
}
