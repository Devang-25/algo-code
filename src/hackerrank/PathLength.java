package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PathLength {

    static class Point {

        int x, y;
        int cost = 0;

        public Point() {

        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return new StringBuilder().append('(').append(x).append(',').append(y).append(')').toString();
        }

        @Override
        public boolean equals(Object obj) {
            Point p = (Point) obj;
            return p.x == x && p.y == y;
        }

    }

    static ArrayList<Point> getNeighBors(Point p, boolean[][] visited, boolean[][] graph) {
        int N = visited.length;
        ArrayList<Point> neighbors = new ArrayList<>();
        for (int i = p.x - 1; i < p.x + 2; i++) {
            for (int j = p.y - 1; j < p.y + 2; j++) {
                if (i >= 0 && i < N && j >= 0 && j < N) {
                    if (!visited[i][j] && graph[i][j]) {
                        neighbors.add(new Point(i, j));
                    }

                }
            }
        }
        
        //System.out.println(neighbors);
        return neighbors;
    }

    public static int doBfs(boolean[][] graph, Point p1, Point p2) {
        Queue<Point> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[graph.length][graph.length];
        p1.cost=-1;
        q.add(p1);
        while (!q.isEmpty()) {
            Point currPoint = q.poll();
            visited[currPoint.x][currPoint.y] = true;
            System.out.println(currPoint);
            ArrayList<Point> neighbors = getNeighBors(currPoint, visited, graph);
            for (Point p : neighbors) {
                p.cost = currPoint.cost + 1;
            }
            if (neighbors.contains(p2)) {
                return currPoint.cost + 1;
            } else {
                q.addAll(neighbors);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        InputReader ir = new InputReader(System.in);
        int N = ir.nextInt();
        boolean[][] graph = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = ir.nextLine();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'X') {
                    graph[i][j] = false;
                } else {
                    graph[i][j] = true;
                }
            }
        }

        Point p1 = new Point();
        Point p2 = new Point();
        p1.x = ir.nextInt();
        p1.y = ir.nextInt();
        p2.x = ir.nextInt();
        p2.y = ir.nextInt();

        System.out.println(doBfs(graph, p1, p2));

    }

    static class InputReader {

        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public float nextFloat() {
            return Float.parseFloat(next());
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException ex) {
                //Logger.getLogger(CuttingBoards.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }
}
