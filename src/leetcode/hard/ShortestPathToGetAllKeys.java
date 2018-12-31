package hard;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by mns on 12/28/18.
 */
public class ShortestPathToGetAllKeys {
    private static final int [][] DIR = {{0,1},{1,0},{-1,0},{0,-1}};
    public int shortestPathAllKeys(String[] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        HashSet<String> visited = new HashSet<>();
        LinkedList<String> q = new LinkedList<>();
        int moves = 0;
        int numKeys = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length();j++){
                if(grid[i].charAt(j) == '@'){
                    q.add(i+","+j+","+0);
                    visited.add(i+","+j+","+0);
                }else if(Character.isLowerCase(grid[i].charAt(j))){
                    numKeys++;
                }
            }
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int k=0;k<size;k++) {
                String top = q.poll();
                String [] splits = top.split(",");
                int i = Integer.parseInt(splits[0]), j = Integer.parseInt(splits[1]);
                int keys = Integer.parseInt(splits[2]);

                if(keys == (1 << numKeys) -1 ){
                    return moves;
                }

                for(int [] d : DIR){
                    int x = i+d[0];
                    int y = j+d[1];
                    if( x>=0 && x < grid.length && y >=0 && y < grid[0].length()){
                        char ch = grid[x].charAt(y);
                        int newKeys = keys;
                        if( ch == '#')
                            continue;

                        if(Character.isLowerCase(ch)){
                            newKeys = keys | 1 << ((ch - 'a'));
                        }

                        if( Character.isUpperCase(ch) && ((keys >> (ch - 'A')) & 1) == 0 ){
                            continue;
                        }

                        if(!visited.contains(x+","+y+","+newKeys)) {
                            visited.add(x + "," + y+","+newKeys);
                            q.add(x + "," + y + "," + newKeys);
                        }
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    public static void main(String[] args) {
        ShortestPathToGetAllKeys s = new ShortestPathToGetAllKeys();
        System.out.println(s.shortestPathAllKeys(new String[] {
                "@...a",".###A","b.BCc"
        }));
    }
}
