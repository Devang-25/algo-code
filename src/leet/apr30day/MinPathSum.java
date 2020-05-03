package leet.apr30day;

public class MinPathSum {

  private int dfs(int[][] grid, int[][] cache, int i, int j) {
    if (i >= grid.length || j >= grid[0].length) {
      return Integer.MAX_VALUE;
    }

    if (i == grid.length - 1 && j == grid[0].length - 1) {
      return grid[i][j];
    }

    if (cache[i][j] != 0) {
      return cache[i][j];
    }

    int minSum = grid[i][j] + Math.min(dfs(grid, cache, i + 1, j), dfs(grid, cache, i, j + 1));

    return (cache[i][j] = minSum);

  }

  // private int dfsNoCache(int[][] grid, int i, int j) {
  // if (i >= grid.length || j >= grid[0].length) {
  // return Integer.MAX_VALUE;
  // }

  // if (i == grid.length - 1 && j == grid[0].length - 1) {
  // return grid[i][j];
  // }

  // int minSum = grid[i][j] + Math.min(dfsNoCache(grid, i + 1, j),
  // dfsNoCache(grid, i, j + 1));

  // return minSum;

  // }

  public int minPathSum(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int[][] cache = new int[grid.length][grid[0].length];
    return dfs(grid, cache, 0, 0);
    // return dfsNoCache(grid, 0, 0)
  }

  public static void main(String[] args) {
    MinPathSum mps = new MinPathSum();
    System.out.println(mps.minPathSum(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } }));
  }
}
