class Solution {
    int rows, cols;
    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> que = new ArrayDeque<>();
        int min = 0;
        rows = grid.length;
        cols = grid[0].length;

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    que.offerLast(new int[] {i, j});
                }
            }
        }

        while (!que.isEmpty()) {
            int size = que.size();

            for (int n = 0; n < size; n++) {
                int[] ele = que.pollFirst();
                int i = ele[0];
                int j = ele[1];

                for (int[] dir : dirs) {
                    int r = i + dir[0];
                    int c = j + dir[1];
                    if (r < 0 || c < 0 || r == rows || c == cols
                        || grid[r][c] != Integer.MAX_VALUE) {
                        continue;
                    }

                    que.offerLast(new int[]{r,c});
                    grid[r][c] = min + 1;
                }
            }
            min++;
        }
    }
}
