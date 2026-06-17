class Solution {
    int row, col;
    int[][] direction = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;

        boolean visited[][] = new boolean[row][col];
        int res = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid, visited);
                    res++;
                }
            }
        }

        return res;
    }

    public void dfs(int r, int c, char[][] grid, boolean[][] visited) {
        if (r < 0 || c < 0 || r == row || c == col || visited[r][c] || grid[r][c] != '1') {
            return;
        }

        grid[r][c] = '0';

        for (int[] dir : direction) {
            dfs(r + dir[0], c + dir[1], grid, visited);
        }
    }
}