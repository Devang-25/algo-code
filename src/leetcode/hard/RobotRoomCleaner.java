package leetcode.hard;


import java.util.HashSet;

// This is the robot's control interface.
// You should not implement it, or speculate about its implementation
interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    public boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    public void turnLeft();

    public void turnRight();

    // Clean the current cell.
    public void clean();
}

public class RobotRoomCleaner {
    public static final int [][] DIR = {{0,1},{1,0},{0,-1},{-1,0}};
    public void cleanRoom(Robot robot) {
        HashSet<String> visited = new HashSet<>();
        visit(robot,0,0,visited,0);
    }

    private void visit(Robot r, int x, int y, HashSet<String> visited, int dir){
        String currPos = x+","+y;
        if(visited.contains(currPos)){
            return;
        }
        visited.add(currPos);
        r.clean();

        for(int i=0;i<DIR.length;i++){
            if(r.move()) {
                visit(r, x + DIR[dir][0], y + DIR[dir][1], visited, dir);
                r.turnLeft();r.turnLeft();
                r.move();
                r.turnRight();r.turnRight();
            }
            dir = (dir+1)%DIR.length;
            r.turnRight();

        }
    }

}
