class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int currMax = 1, currMin = 1;

        for (int n : nums) {
            int temp = n * currMax;
            currMax = Math.max(Math.max(n * currMax, n * currMin), n);
            currMin = Math.min(Math.min(temp, n * currMin), n);
            res = Math.max(res, currMax);
        }

        return res;
    }
}