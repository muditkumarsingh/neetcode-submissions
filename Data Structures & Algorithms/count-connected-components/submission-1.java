class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int componentCount = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adj, visited, i);
                componentCount++;
            }
        }

        return componentCount;
    }

    private void dfs(List<Integer>[] adj, boolean[] visited, int i) {
        if (visited[i]) return;
        visited[i] = true;
        for (int j : adj[i]) {
            dfs(adj, visited, j);
        }
    }
}