class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n < 2) {
            ArrayList<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++)
                res.add(i);
            return res;
        }
        ArrayList<HashSet<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        
        for (int i = 0; i < edges.length; i++) { //undirected
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        Queue<Integer> leaves = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        
        while (n > 2) {
            n -= leaves.size();
            Queue<Integer> newLeaves = new LinkedList<>();
            while (!leaves.isEmpty()) {
                Integer leaf = leaves.poll();
                Integer neighbor = graph.get(leaf).iterator().next();
                graph.get(neighbor).remove(leaf);
                if (graph.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }
        return new ArrayList<>(leaves);
    }
}
