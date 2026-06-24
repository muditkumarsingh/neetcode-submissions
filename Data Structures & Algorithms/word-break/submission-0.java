class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[len] = true;

        for (int i = len - 1; i >= 0; i--) {
            for(String word:wordDict){
                if(i+word.length()<=len && s.substring(i,i+word.length()).equals(word)){
                    dp[i]=dp[i+word.length()];
                }
                if(dp[i]){
                    break;
                }
            }
        }

        return dp[0];
    }
}