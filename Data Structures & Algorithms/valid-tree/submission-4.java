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

        if (!dfs(0, -1,  visited, cycle,adj))
            return false;

        return visited.size() == n;
    }

    public boolean dfs(int node, int prev,HashSet<Integer>visited,HashSet<Integer> cycle,List<List<Integer>> adj){
        if(visited.contains(node)){
            return true;
        }
        if(cycle.contains(node)){
            return false;
        }

        cycle.add(node);
        for(int nei:adj.get(node)){
            if(nei!=prev && !dfs(nei,node,visited,cycle,adj)){
                return false;
            }
        }
        cycle.remove(node);
        visited.add(node);

        return true;
    }
}
