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

        PriorityQueue<Interval> minHeap = new PriorityQueue<>(Comparator.comparing(a->a.start));
        for(Interval interval:intervals){
            minHeap.offer(interval);
        }

        Interval prev = minHeap.poll();
        int i = 1;

        while (!minHeap.isEmpty()) {
            Interval interval = minHeap.poll();
            if (prev.end > interval.start) {
                return false;
            }
            prev = interval;
            i++;
        }
        return true;
    }
}
