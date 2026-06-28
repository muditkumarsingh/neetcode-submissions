class Solution {
    int[][] memo;

    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return dfs(0, 0, word1, word2);
    }

    public int dfs(int i, int j, String word1, String word2) {
        if (i == word1.length() && j == word2.length()) {
            return 0;
        } else if (i == word1.length() || j == word2.length()) {
            return Math.max(word1.length() - i, word2.length() - j);
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = dfs(i + 1, j + 1, word1, word2);
        } else {
            memo[i][j] = 1 + Math.min(Math.min(dfs(i, j + 1, word1, word2), dfs(i + 1, j, word1, word2)),
                    dfs(i + 1, j + 1, word1, word2));
        }

        return memo[i][j];
    }
}