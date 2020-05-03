package leet.apr30day;

public class NumIslands {
  private static final int[][] DIR = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

  private void dfs(int i, int j, char[][] grid, boolean[][] visited) {
    if (visited[i][j] || grid[i][j] != '1')
      return;

    visited[i][j] = true;
    for (int[] dir : DIR) {
      int x = i + dir[0];
      int y = j + dir[1];
      if (x >= 0 && y >= 0 && x <= grid.length - 1 && y <= grid[0].length - 1) {
        dfs(x, y, grid, visited);
      }
    }
  }

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int numIslands = 0;
    boolean[][] visited = new boolean[grid.length][grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1' && !visited[i][j]) {
          dfs(i, j, grid, visited);
          numIslands++;
        }
      }
    }

    return numIslands;
  }

  public static void main(String[] args) {
    NumIslands ni = new NumIslands();
    System.out.println(ni.numIslands(new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
        { '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } }));

  }
}

/**
 * 11000 11000 00100 00011
 */
