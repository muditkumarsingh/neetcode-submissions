class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            int min = 10000;
            for (int j = 1; i + j < n && j <= nums[i]; j++) {
                min = Math.min(min, dp[i + j]);
            }
            dp[i] = 1 + min;
        }
        return dp[0];
    }
}