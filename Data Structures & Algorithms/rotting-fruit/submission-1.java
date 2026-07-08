class Solution {
    public int orangesRotting(int[][] grid) {
        int directions[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        boolean visited[][] = new boolean[m][n];

        Queue<int[]> que = new LinkedList<>();
        int time = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    que.offer(new int[] { i, j });
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        while (!que.isEmpty()) {
            int size = que.size();

            for (int i = 0; i < size; i++) {
                int[] idx = que.poll();
                int r = idx[0];
                int c = idx[1];

                if (grid[r][c] == 1) {
                    grid[r][c] = 2;
                    fresh--;
                }

                for (int[] dir : directions) {
                    int x = dir[0] + idx[0], y = dir[1] + idx[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && grid[x][y] == 1) {
                        que.offer(new int[] { x, y });
                        visited[x][y] = true;
                    }
                }
            }
            if (!que.isEmpty())
                time++;
        }

        return fresh == 0  ? time : -1;

    }
}