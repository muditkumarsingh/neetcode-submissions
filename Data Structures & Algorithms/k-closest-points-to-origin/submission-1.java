class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0] * a[0] + a[1] * a[1]));

        for (int[] point : points) {
            minHeap.offer(new int[] { point[0], point[1] });
        }

        int[][] res = new int[k][2];

        for (int i = 0; i < k; i++) {
            int[] point = minHeap.poll();
            res[i][0] = point[0];
            res[i][1] = point[1];
        }

        return res;
    }
}