class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        HashSet<Integer> cycle = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();

        if (!dfs(0, -1, adj, cycle, visited))
            return false;

        return visited.size() == n;
    }

    public boolean dfs(int node, int parent, List<List<Integer>> adj, HashSet<Integer> cycle,
        HashSet<Integer> visited) {
        if (cycle.contains(node)) {
            return false;
        }
        if (visited.contains(node)) {
            return true;
        }

        cycle.add(node);
        for (int next : adj.get(node)) {
            if (next != parent && !dfs(next, node, adj, cycle, visited)) {
                return false;
            }
        }
        cycle.remove(node);
        visited.add(node);

        return true;
    }
}
