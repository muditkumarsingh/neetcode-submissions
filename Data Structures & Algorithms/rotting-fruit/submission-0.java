class Solution {
    int rows, cols;
    public int orangesRotting(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        Deque<int[]> que = new ArrayDeque<>();
        int fresh = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    que.offerLast(new int[] {i, j});
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int min = 0;
        int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        while (!que.isEmpty() && fresh > 0) {
            int size = que.size();

            for (int i = 0; i < size; i++) {
                int[] node = que.pollFirst();
                int x = node[0];
                int y = node[1];

                for (int[] dir : direction) {
                    int r = x + dir[0];
                    int c = y + dir[1];

                    if (r < 0 || c < 0 || r == rows || c == cols || grid[r][c] != 1) {
                        continue;
                    }

                    grid[r][c] = 2;
                    fresh--;
                    que.offerLast(new int[] {r, c});
                }
            }
            min++;
        }

        return fresh == 0 ? min : -1;
    }
}
