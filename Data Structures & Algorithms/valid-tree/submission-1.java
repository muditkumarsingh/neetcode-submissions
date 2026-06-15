class Solution {
    public boolean validTree(int n, int[][] edges) {
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
        HashSet<Integer> cycle = new HashSet<>();

        if (!dfs(0, -1, map, visited, cycle)) {
            return false;
        }


        return visited.size()==n;
    }

    public boolean dfs(int node, int parent, HashMap<Integer, ArrayList<Integer>> map,
        HashSet<Integer> visited, HashSet<Integer> cycle) {
        if (cycle.contains(node)) {
            return false;
        }
        if (visited.contains(node)) {
            return true;
        }

        cycle.add(node);
        for (int next : map.getOrDefault(node, new ArrayList<>())) {
            if (next == parent) {
                continue;
            }
            if (!dfs(next, node, map, visited, cycle)) {
                return false;
            }
        }
        cycle.remove(node);
        visited.add(node);

        return true;
    }
}
