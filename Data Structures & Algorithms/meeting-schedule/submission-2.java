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
        if (intervals.size() == 0) {
            return true;
        }
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        Interval prev = intervals.get(0);
        int n = intervals.size();
        int i = 1;

        while (i < n) {
            if (prev.end > intervals.get(i).start && prev.start < intervals.get(i).end) {
                return false;
            }
            prev = intervals.get(i);
            i++;
        }
        return true;
    }
}
