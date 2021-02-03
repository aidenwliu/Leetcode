class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();
        
        for (String word : words) {
            for (char c : word.toCharArray()) {
                counts.put(c, 0);
                adjList.put(c, new ArrayList<>());
            }
        }
        
        //Step 1: find all edges
        for (int i = 0; i < words.length-1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            
            //Check that w2 is not a prefix of w1.
            if (w1.length() > w2.length() && w1.startsWith(w2))
                return "";
            
            //Find the first non-match and insert the corresponding relation.
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adjList.get(w1.charAt(j)).add(w2.charAt(j));//Add outgoing edges.
                    counts.put(w2.charAt(j),counts.get(w2.charAt(j))+1);
                    break;
                }
            }
        }
        
        
        //Step 2: BFS
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (Character c : counts.keySet()) {
            if (counts.get(c).equals(0))
                queue.add(c);
        }
        
        while (!queue.isEmpty()) {
            Character c = queue.remove();
            sb.append(c);
            for (Character next : adjList.get(c)) {
                counts.put(next, counts.get(next)-1);
                if (counts.get(next).equals(0)) {
                    queue.add(next);
                }
            }
        }
        
        if (sb.length() < counts.size()) {
            return "";
        }
        return sb.toString();
    }
}
