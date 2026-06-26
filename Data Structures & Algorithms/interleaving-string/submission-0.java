class Solution {
    HashMap<String,Boolean> dp= new HashMap<>();
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() < ((s1 + s2).length())) {
            return false;
        }

        return dfs(0, 0, 0, s1, s2, s3);
    }

    public boolean dfs(int i1, int i2, int i3, String s1, String s2, String s3) {
        if (i1 == s1.length() && i2 == s2.length() && i3 == s3.length()) {
            return true;
        }

        String key = i1+"-"+i2+"-"+13;

        if(dp.containsKey(key)){
            return dp.get(key);
        }

        boolean res = false;

        if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)) {
            res = res || dfs(i1 + 1, i2, i3 + 1, s1, s2, s3);
        }
        if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) {
            res = res || dfs(i1, i2 + 1, i3 + 1, s1, s2, s3);
        }

        dp.put(key,res);

        return dp.get(key);
    }
}