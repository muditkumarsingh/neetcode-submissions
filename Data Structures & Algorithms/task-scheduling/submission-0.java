class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        HashMap<Character, Integer> map = new HashMap<>();

        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxHeap.offer(entry.getValue());
        }

        Queue<int[]> que = new LinkedList<>();
        int time = 0;

        while (!que.isEmpty() || !maxHeap.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int val = maxHeap.poll() - 1;
                if (val > 0) {
                    que.offer(new int[] { val, time + n });
                }
            }
            if (!que.isEmpty() && que.peek()[1] == time) {
                int val = que.poll()[0];
                maxHeap.offer(val);
            }
        }

        return time;
    }
}