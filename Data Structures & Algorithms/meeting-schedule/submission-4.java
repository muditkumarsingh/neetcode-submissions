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
            if (prev.end > intervals.get(i).start) {
                return false;
            }
            prev = intervals.get(i);
            i++;
        }
        return true;
    }
}
