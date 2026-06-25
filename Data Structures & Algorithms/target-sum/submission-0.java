class Solution {
    HashMap<String, Integer> memo = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {

        return dfs(0, 0, nums, target);
    }

    public int dfs(int amount, int index, int[] nums, int target) {
        if (amount == target && index == nums.length) {
            return 1;
        }
        if (index == nums.length) {
            return 0;
        }

        String key = amount + "-" + index;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int ways = 0;

        // + concatinated
        ways += dfs(amount + nums[index], index + 1, nums, target);
        // - concatinated
        ways += dfs(amount - nums[index], index + 1, nums, target);

        memo.put(key, ways);
        return memo.get(key);

    }
}