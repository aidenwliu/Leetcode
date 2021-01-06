class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> grouped = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String cur : strs) {
            char[] characters = cur.toCharArray();
            Arrays.sort(characters);
            String sorted = new String(characters);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(cur);
        }
        grouped.addAll(map.values());
        return grouped;
    }
}
