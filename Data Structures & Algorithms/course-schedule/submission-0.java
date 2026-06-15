class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int[] ele : prerequisites) {

            map.putIfAbsent(ele[1], new ArrayList<>());
            map.get(ele[1]).add(ele[0]);
        }


        for (Integer i = 0; i < numCourses; i++) {
            HashSet<Integer> set = new HashSet<>();
            if (isCycle(i, map, set)) {
                return false;
            }
            System.out.println(set);
        }

        return true;
    }

    public boolean isCycle(Integer node, HashMap<Integer, ArrayList<Integer>> map, HashSet<Integer> set) {

        if (set.contains(node)) {
            return true;
        }

        set.add(node);
        if (map.get(node) == null) {
            set.remove(Integer.valueOf(node));
            return false;
        }

        for (Integer next : map.get(node)) {
            if (isCycle(next, map, set)) {
                return true;
            }
        }

        set.remove(Integer.valueOf(node));
        map.put(node,new ArrayList<>());

        return false;
    }
}