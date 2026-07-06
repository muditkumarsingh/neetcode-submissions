class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int n = intervals.length;
        int i = 1;
        int[] prev = intervals[0];
        ArrayList<int[]> res = new ArrayList<>();

        while (i < n) {
            if (prev[0] <= intervals[i][1] && prev[1] >= intervals[i][0]) {
                prev[0] = Math.min(prev[0], intervals[i][0]);
                prev[1] = Math.max(prev[1], intervals[i][1]);
            } else {
                res.add(prev);
                prev = intervals[i];
            }
            i++;
        }

        res.add(prev);

        return res.toArray(new int[res.size()][]);

    }
}