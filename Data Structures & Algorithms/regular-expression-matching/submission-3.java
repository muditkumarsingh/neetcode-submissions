

class Solution {
    Boolean[][] dp;
    int len1, len2;

    public boolean isMatch(String s, String p) {
        len1 = s.length();
        len2 = p.length();

        dp = new Boolean[len1 + 1][len2 + 1];

        return dfs(0, 0, s, p);
    }

    public boolean dfs(int i, int j, String s, String p) {
        if (i >= len1 && j >= len2) {
            return true;
        }
        if (j >= len2) {
            return false;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        boolean match = i < len1 && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if (j + 1 < len2 && p.charAt(j + 1) == '*') {
            dp[i][j] = dfs(i, j + 2, s, p) || (match && dfs(i + 1, j, s, p));
            return dp[i][j];
        }

        if (match) {
            dp[i][j] = dfs(i + 1, j + 1, s, p);
            return dp[i][j];
        }

        return false;
    }
}