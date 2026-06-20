class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;

        int[] dp = new int[len];
        Arrays.fill(dp,1);
        int res = 1;

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (nums[j] > nums[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = 1 + dp[j];
                    res = Math.max(res, dp[i]);
                }
            }
        }

        return res;

    }
}