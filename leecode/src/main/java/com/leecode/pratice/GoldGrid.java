package com.leecode.pratice;

public class GoldGrid {
    public int getMaximumGold(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                ans = Math.max(ans, dfs(grid, i, j, visited));
            }
        }

        return ans;
    }

    int[] dX = new int[]{0, 0, 1, -1};
    int[] dY = new int[]{1, -1, 0, 0};
    private int dfs(int[][] grid, int x, int y, boolean[][] visited) {
        int max = grid[x][y];
        int gold = grid[x][y];
        visited[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dX[k];
            int ny = y + dY[k];
            if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) {
                continue;
            }
            if (grid[nx][ny] == 0 || visited[nx][ny]) {
                continue;
            }
            max = Math.max(max, gold + dfs(grid, nx, ny, visited));
        }
        visited[x][y] = false;
        return max;
    }
}
