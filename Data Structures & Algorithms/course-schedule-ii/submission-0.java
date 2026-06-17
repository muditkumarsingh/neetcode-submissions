class Solution {
    ArrayList<Integer> order = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            adj.get(edge[0]).add(edge[1]);
        }

        HashSet<Integer> cycle = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, adj, cycle, visited))
                return new int[0];
        }

        int[] res = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            res[i] = order.get(i);
        }

        return res;
    }

    boolean dfs(int node, List<List<Integer>> adj, HashSet<Integer> cycle, HashSet<Integer> visited) {
        if (cycle.contains(node)) {
            return false;
        }
        if (visited.contains(node)) {
            return true;
        }

        cycle.add(node);
        for (int next : adj.get(node)) {
            if (!dfs(next, adj, cycle, visited)) {
                return false;
            }
        }
        cycle.remove(node);
        visited.add(node);
        order.add(node);

        return true;
    }
}