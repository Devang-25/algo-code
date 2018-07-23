package leetcode.easy;

import java.util.HashSet;

public class WalkingRobotSimulation {

    class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Pair a = (Pair) obj;
            return a.x == this.x && a.y == this.y;
        }

        @Override
        public int hashCode() {
            return (this.x + " " + this.y).hashCode();
        }
    }


    private final Pair[] DIRECTIONS = {new Pair(0, 1), new Pair(1, 0), new Pair(0, -1), new Pair(-1, 0)};

    public int robotSim(int[] commands, int[][] obstacles) {

        int dir = 0, result = 0;
        HashSet<Pair> set = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            set.add(new Pair(obstacles[i][0], obstacles[i][1]));
        }
        Pair currPos = new Pair(0, 0);
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] >= 1) {
                currPos = hasObstacle(currPos, commands[i], dir, set);
                result = Math.max(result, currPos.x * currPos.x + currPos.y * currPos.y);
            } else if (commands[i] == -1) {
                dir += 1;
                dir %= 4;
            } else if (commands[i] == -2) {
                dir += 3;
                dir %= 4;
            }
        }

        return result;
    }

    private Pair hasObstacle(Pair a, int cmd, int dir, HashSet<Pair> set) {
        Pair curr = new Pair(a.x, a.y);
        Pair next = new Pair(a.x, a.y);

        for (int i = 0; i < cmd; i++) {
            next.x += DIRECTIONS[dir].x;
            next.y += DIRECTIONS[dir].y;
            if (set.contains(next)) {
                return curr;
            }
            curr.x = next.x;
            curr.y = next.y;
        }
        return curr;
    }


    public static void main(String[] args) {
        WalkingRobotSimulation ws = new WalkingRobotSimulation();
        System.out.println(ws.robotSim(new int[]{4, -1, 3}, new int[][]{}));
        System.out.println(ws.robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{{2, 4}}));
    }
}
