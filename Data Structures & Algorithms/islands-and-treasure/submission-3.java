class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> que = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    que.offer(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        int dist = 0;

        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int[] index = que.poll();
                int r = index[0], c = index[1];

                if (grid[r][c] == Integer.MAX_VALUE) {
                    grid[r][c] = dist;
                }

                for (int[] dir : directions) {
                    int x = dir[0], y = dir[1];
                    if (r + x >= 0 && r + x < m && c + y >= 0 && c + y < n
                        && !visited[r + x][c + y]&&grid[r+x][c+y]!=-1) {
                        que.offer(new int[] {r + x, c + y});
                        visited[r + x][c + y] = true;
                    }
                }
            }
            dist++;
        }
    }
}
