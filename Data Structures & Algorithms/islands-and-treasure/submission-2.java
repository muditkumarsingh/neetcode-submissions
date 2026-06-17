class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
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
                int[] node = que.poll();
                int r = node[0];
                int c = node[1];

                grid[r][c] = dist;

                for (int[] dir : direction) {
                    int x = r + dir[0];
                    int y = c + dir[1];

                    if (x >= 0 && x < row && y >= 0 && y < col && !visited[x][y]
                        && grid[x][y] == Integer.MAX_VALUE) {
                        que.offer(new int[] {x, y});
                        visited[x][y] = true;
                    }
                }
            }
            dist++;
        }
    }
}
