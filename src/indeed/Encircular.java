/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indeed;

import java.util.ArrayList;

/**
 *
 * @author mns
 */
public class Encircular {

    static class Position {

        int x;
        int y;
        int dir;
    }

    static String[] doesCircleExist(String[] commands) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < commands.length; i++) {
            String cmd = commands[i];
            Position pos = new Position();
            pos.x = 0;
            pos.y = 0;
            pos.dir = 0;

            for (int j = 0; j < cmd.length(); j++) {
                if (cmd.charAt(j) == 'G') {
                    if (pos.dir == 0) {
                        pos.y++;
                    } else if (pos.dir == 1) {
                        pos.x++;
                    } else if (pos.dir == 2) {
                        pos.y--;
                    } else if (pos.dir == 3) {
                        pos.x--;
                    }
                } else if (cmd.charAt(j) == 'L') {
                    pos.dir = (pos.dir - 1) % 4;
                } else {
                    pos.dir = (pos.dir + 1) % 4;
                }

            }
            if (pos.dir == 0 && pos.x * pos.x + pos.y * pos.y > 0) {
                list.add("NO");
            } else {
                list.add("YES");
            }
        }

        String[] out = new String[list.size()];
        list.toArray(out);
        return out;

    }
}
