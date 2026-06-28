class Solution {
    int[][] memo;

    public int maxCoins(int[] nums) {
        int n = nums.length;

        memo = new int[n + 2][n + 2];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int[] newNum = new int[n + 2];
        newNum[0] = 1;
        newNum[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            newNum[i + 1] = nums[i];
        }

        return dfs(newNum, 1, n);
    }

    int dfs(int[] nums, int l, int r) {
        if (l > r) {
            return 0;
        }

        if (memo[l][r] != -1) {
            return memo[l][r];
        }

        int max = 0;

        for (int i = l; i <= r; i++) {
            int cost = nums[l - 1] * nums[i] * nums[r + 1];
            max = Math.max(max, cost + dfs(nums, l, i - 1) + dfs(nums, i + 1, r));
        }
        memo[l][r] = max;

        return max;
    }
}