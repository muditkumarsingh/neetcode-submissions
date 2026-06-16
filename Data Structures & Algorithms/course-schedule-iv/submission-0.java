class Solution {
    HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int edge[] : prerequisites) {
            adj.get(edge[0]).add(edge[1]);

        }

        for(int i=0;i<numCourses ;i++ ){
            dfs(i,adj);
        }

        ArrayList<Boolean> res = new ArrayList<>();

        for (int[] query : queries) {
            int u = query[0];
            int v = query[1];

            res.add(map.get(u).contains(v));
        }
        return res;
    }

    public Set<Integer> dfs(int node, List<List<Integer>> adj) {
        if (map.containsKey(node)) {
            return map.get(node);
        }

        HashSet<Integer> preReq = new HashSet<>();
        for (int next : adj.get(node)) {
            preReq.addAll(dfs(next, adj));
        }
        preReq.add(node);
        map.put(node, preReq);
        return preReq;
    }
}