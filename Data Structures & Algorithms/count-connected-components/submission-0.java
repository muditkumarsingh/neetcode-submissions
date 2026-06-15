class Solution {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            int n1 = edge[0];
            int n2 = edge[1];

            map.putIfAbsent(n1, new ArrayList<>());
            map.putIfAbsent(n2, new ArrayList<>());

            map.get(n1).add(n2);
            map.get(n2).add(n1);
        }

        HashSet<Integer> visited = new HashSet<>();

        dfs(0,  map, visited);
        int c = 1;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                c++;
                dfs(i,  map, visited);
            }
        }

        return c;
    }

    public void dfs(int node, HashMap<Integer, ArrayList<Integer>> map, HashSet<Integer> visited) {
        if (visited.contains(node)) {
            return;
        }

        visited.add(node);
        for (int next : map.getOrDefault(node, new ArrayList<>())) {
            dfs(next, map, visited);
        }
    }
}
