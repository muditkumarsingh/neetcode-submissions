/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int n = intervals.size();
        if (n == 0) {
            return true;
        }

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        Interval prev = intervals.get(0);
        int i = 1;

        while (i < n) {
            Interval interval = intervals.get(i);
            if (prev.end > interval.start) {
                return false;
            }
            prev.start = Math.min(interval.start, prev.start);
            prev.end = Math.max(interval.end, prev.end);
            i++;
        }
        return true;
    }
}
