/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {

        HashSet<Node> visited = new HashSet<>();
        dfs(node, visited);

        for(Node original:map.keySet()){
            Node copy = map.get(original);

            for(Node nei:original.neighbors){
                copy.neighbors.add(map.get(nei));
            }
        }

        return map.get(node);

    }

    public void dfs(Node node, HashSet<Node> visited) {
        if (node == null || visited.contains(node)) {
            return;
        }

        visited.add(node);
        Node copy = new Node(node.val);
        map.put(node, copy);

        List<Node> neighbors = node.neighbors;

        for (Node nei : neighbors) {
            dfs(nei, visited);
        }
    }

}