class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        HashSet<Integer> visited = new HashSet<>();

        int res = 0;

        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                res++;
                dfs(i, -1, adj, visited);
            }
        }
        return res;
    }

    public void dfs(int node, int parent, List<List<Integer>> adj, HashSet<Integer> visited) {
        if (visited.contains(node)) {
            return;
        }

        visited.add(node);
        for (int next : adj.get(node)) {
            if (next != parent)
                dfs(next, node, adj, visited);
        }
    }
}
